package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;

public class ReparacionCompleja extends EspecialidadPedido {
	
	private static Tiempo tiempoEmpleadoEnReparacion;
	private static int cantidadAtendidos;
	private boolean terminado;
	
	public ReparacionCompleja(Pedido sujeto) {
		super(sujeto);
		tiempoEmpleadoEnReparacion=new Tiempo();
		tiempoEmpleadoEnReparacion.nuevoTiempo(0, 0);
		cantidadAtendidos=0;
		terminado=false;
	}

	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return unCamion.hayReparacionCompleja();
	}

	@Override
	protected void doValidarEspecialidadPara(Cliente cliente) {
		cliente.validarReparacionCompleja();
	}

	@Override
	public Tiempo calcularTiempoDeAtencion() {
		Tiempo tiempoRetorno = Tiempo.promediarTiempo(ReparacionCompleja.tiempoEmpleadoEnReparacion, ReparacionCompleja.cantidadAtendidos);
		return tiempoRetorno;
	}
	
	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		tiempoEmpleadoEnReparacion=Tiempo.sumarTiempos(ReparacionCompleja.tiempoEmpleadoEnReparacion, tiempo);
		cantidadAtendidos += 1;
		terminado = true;
		sujeto.terminarServicioDelPedido(tiempo);
	}
	
	//BEGIN SANTI
	
	/**
	 * Cada EspecialidadPedido (Incendio, Vuelco, etc.) debe responderle a un
	 * camión si puede ser atendido por él. Esto es así, ya que cada
	 * EspecialidadPedido conoce lo que necesita. Ej.: Una reparación mecánica
	 * con complejidad alta necesita de 2 ayudantes, entonces el decorator le
	 * pregunta al camión si tiene dos ayudantes. En caso afirmativo, el camión
	 * puede decir que es capaz de atender ese problema de complejidad alta. La
	 * desición fue provisoriamente mantener a ReparacionSimple y Compleja como
	 * estaba en la 1era entrega, pero luego se utilizará una forma común a
	 * todo.
	 */

	@Override
	
	@Override
	public Tiempo CuantoTardasEnTerminarte() {
		return this.calcularTiempoDeAtencion();
	}
}
