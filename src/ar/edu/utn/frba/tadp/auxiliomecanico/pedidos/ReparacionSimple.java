package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;

public class ReparacionSimple extends EspecialidadPedido {

	private static Tiempo tiempoEmpleadoEnReparacion;
	private static int cantidadAtendidos;
	
	private boolean terminado;
	
	public ReparacionSimple(Pedido sujeto) {
		super(sujeto);
		tiempoEmpleadoEnReparacion=new Tiempo();
		tiempoEmpleadoEnReparacion.nuevoTiempo(0, 0);
		cantidadAtendidos=0;
		terminado=false;
	}

	@Override
	public boolean isReparacionSimple() {
		return true;
	}

	@Override
	public boolean isRemolque() {
		return false;
	}

	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return true;
	}

	@Override
	protected void doValidarEspecialidadPara(Cliente cliente) {
		cliente.validarReparacionSimple();
	}


	@Override
	public Tiempo calcularTiempoDeAtencion() {
		Tiempo tiempoReparacionTiempo = Tiempo.promediarTiempo(ReparacionSimple.tiempoEmpleadoEnReparacion, ReparacionSimple.cantidadAtendidos);
		return tiempoReparacionTiempo;
	}
	
	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		tiempoEmpleadoEnReparacion=Tiempo.sumarTiempos(ReparacionSimple.tiempoEmpleadoEnReparacion, tiempo);
		cantidadAtendidos += 1;
		terminado = true;
		sujeto.terminarServicioDelPedido(tiempo);
	}

	/**
	 * Cada EspecialidadPedido (Incendio, Vuelco, etc.) debe responderle a un
	 * cami�n si puede ser atendido por �l. Esto es as�, ya que cada
	 * EspecialidadPedido conoce lo que necesita. Ej.: Una reparaci�n mec�nica
	 * con complejidad alta necesita de 2 ayudantes, entonces el decorator le
	 * pregunta al cami�n si tiene dos ayudantes. En caso afirmativo, el cami�n
	 * puede decir que es capaz de atender ese problema de complejidad alta. La
	 * desici�n fue provisoriamente mantener a ReparacionSimple y Compleja como
	 * estaba en la 1era entrega, pero luego se utilizar� una forma com�n a
	 * todo.
	 */
	
	@Override
	public Tiempo CuantoTardasEnTerminarte() {
		return this.calcularTiempoDeAtencion();
	}
}
