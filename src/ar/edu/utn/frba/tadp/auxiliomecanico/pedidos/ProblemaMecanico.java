package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.complejidades.Complejidad;

public class ProblemaMecanico extends EspecialidadPedido {

	private static Tiempo tiempoEmpleadoEnReparacion;
	private static int cantidadAtendidos;

	private Complejidad complejidad;
	private boolean terminado;

	static {
		// Inicialización de variables del tiempo de reparación
		tiempoEmpleadoEnReparacion = new Tiempo().nuevoTiempo(0, 0);
		// Inicialización de cantidad de atendidos
		cantidadAtendidos = 0;
	}

	public ProblemaMecanico(Pedido sujeto, Complejidad complejidad) {
		super(sujeto);
		this.complejidad = complejidad;
		this.terminado = false;
	}

	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return complejidad.puedeAtenderte(unCamion)
		&& unCamion.hayUnMecanico();
	}

	@Override
	protected void doValidarEspecialidadPara(Cliente cliente) {
		this.complejidad.validarEspecialidadPara(cliente, this);
	}

	@Override
	public Tiempo calcularTiempoDeAtencion() {
		return ProblemaMecanico.tiempoEmpleadoEnReparacion;
	}

	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		tiempoEmpleadoEnReparacion = Tiempo.sumarTiempos(ProblemaMecanico.tiempoEmpleadoEnReparacion, tiempo);
		cantidadAtendidos += 1;

		this.terminado = true;
	}

	@Override
	public void finalizarElPedido() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Tiempo calcularTiempoDeAtencion(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
