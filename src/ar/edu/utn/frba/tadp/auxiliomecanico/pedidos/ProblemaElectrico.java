package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;

public class ProblemaElectrico extends EspecialidadPedido {

	private static Tiempo tiempoEmpleadoEnReparacion;
	private static int cantidadAtendidos;

	private boolean terminado;

	static {
		// Inicialización de variables del tiempo de reparación
		tiempoEmpleadoEnReparacion = new Tiempo().nuevoTiempo(0, 0);
		// Inicialización de cantidad de atendidos
		cantidadAtendidos = 0;
	}

	public ProblemaElectrico(Pedido sujeto) {
		super(sujeto);
		this.terminado = false;
	}

	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return unCamion.tenesUnElectricista();
	}

	@Override
	protected void doValidarEspecialidadPara(Cliente cliente) {
		// this.validarEspecialidadPara(cliente);
	}

	@Override
	public Tiempo calcularTiempoDeAtencion() {
		return ProblemaElectrico.tiempoEmpleadoEnReparacion;
	}

	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		tiempoEmpleadoEnReparacion = Tiempo.sumarTiempos(ProblemaElectrico.tiempoEmpleadoEnReparacion, tiempo);
		cantidadAtendidos += 1;

		this.terminado = true;
	}

}
