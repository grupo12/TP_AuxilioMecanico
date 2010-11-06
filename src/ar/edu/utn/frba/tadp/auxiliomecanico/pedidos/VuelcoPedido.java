package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;

public class VuelcoPedido extends DesastrePedido {
	private static Tiempo tiempoEmpleadoEnReparacion;
	private static int cantidadAtendidos;

	static {
		// Inicializaci�n de variables del tiempo de reparaci�n
		tiempoEmpleadoEnReparacion = new Tiempo().nuevoTiempo(0, 0);
		// Inicializaci�n de cantidad de atendidos
		cantidadAtendidos = 0;
	}
	
	public VuelcoPedido(Pedido sujeto) {
		super(sujeto);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void validarEspecialidadPara(Cliente cliente) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean puedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isReparacionSimple() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isRemolque() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Automovil getAutomovil() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Tiempo calcularTiempoDeAtencion() {
		return VuelcoPedido.tiempoEmpleadoEnReparacion;
	}

	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		VuelcoPedido.cantidadAtendidos += 1;
		VuelcoPedido.tiempoEmpleadoEnReparacion = Tiempo.sumarTiempos(VuelcoPedido.tiempoEmpleadoEnReparacion, tiempo);
	}

		
	@Override
	protected void doValidarEspecialidadPara(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion,
			Automovil automovil) {
		// TODO Auto-generated method stub
		return false;
	}

	// BEGIN SANTI
	@Override
	public boolean puedoAtenderte(Camion camion) {
		return camion.puedeAtenderRemolque(super.getAutomovil());
	}
	// END SANTI

	@Override
	public Tiempo calcularTiempoDeAtencion(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}
