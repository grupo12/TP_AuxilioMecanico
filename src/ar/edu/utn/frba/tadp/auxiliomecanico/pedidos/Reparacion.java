package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.complejidades.Complejidad;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.especialidades.Especialidad;

public class Reparacion extends EspecialidadPedido {

	private static Tiempo tiempoEmpleadoEnReparacion;
	private static int cantidadAtendidos;

	private Especialidad especialidad;
	private Complejidad complejidad;
	private boolean terminado;

	static {
		// Inicialización de variables del tiempo de reparación
		tiempoEmpleadoEnReparacion = new Tiempo().nuevoTiempo(0, 0);
		// Inicialización de cantidad de atendidos
		cantidadAtendidos = 0;
	}

	public Reparacion(Pedido sujeto, Especialidad especialidad, Complejidad complejidad) {
		super(sujeto);
		this.especialidad = especialidad;
		this.complejidad = complejidad;
		this.terminado = false;
	}

	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return unCamion.puedeAtenderReparacionCompleja();
	}

	@Override
	protected void doValidarEspecialidadPara(Cliente cliente) {
		this.complejidad.validarEspecialidadPara(cliente, this);
	}


	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		tiempoEmpleadoEnReparacion = Tiempo.sumarTiempos(Reparacion.tiempoEmpleadoEnReparacion, tiempo);
		cantidadAtendidos += 1;
		terminado = true;
		sujeto.terminarServicioDelPedido(tiempo);
	}

	// BEGIN SANTI
	@Override
	public boolean puedoAtenderte(Camion camion) {
		return complejidad.puedeAtenderte(camion)
				&& especialidad.puedeAtenderte(camion);
	}
	
	public int cantAyudantesRequeridos(){
		return this.complejidad.cantAyudantesRequeridos();
	}
	// END SANTI

	@Override
	public Tiempo calcularTiempoDeAtencion() {
		Tiempo tiempoRetorno = Tiempo.promediarTiempo(Reparacion.tiempoEmpleadoEnReparacion, Reparacion.cantidadAtendidos);
	return tiempoRetorno;
	}

}
