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
		return unCamion.puedeAtenderReparacionSimple();
	}

	@Override
	protected void doValidarEspecialidadPara(Cliente cliente) {
		cliente.validarReparacionSimple();
	}

	@Override
	public Tiempo calcularTiempoDeAtencion(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		tiempoEmpleadoEnReparacion=Tiempo.sumarTiempos(ReparacionSimple.tiempoEmpleadoEnReparacion, tiempo);
		cantidadAtendidos += 1;
		
		terminado = true;
	}

}
