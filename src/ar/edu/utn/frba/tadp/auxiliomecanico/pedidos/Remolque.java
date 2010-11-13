package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;

public class Remolque extends EspecialidadPedido {
	
	private static int cantidadAtendidos;
	private boolean terminado;

	static {
		cantidadAtendidos = 0;
		
	}
	
	public Remolque(Pedido sujeto) {
		super(sujeto);
		terminado = false;
	}
	
	public boolean isRemolque() {
		return true;
	}

	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
			Automovil a = super.getAutomovil();
			return unCamion.hayRemolque(a);
	}

	@Override
	protected void doValidarEspecialidadPara(Cliente cliente) {
		cliente.validarRemolque();
	}

	
	@Override
	public Tiempo calcularTiempoDeAtencion() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void finalizarElPedido() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		cantidadAtendidos += 1;
		terminado = true;
	}
	
	@Override
	public Tiempo calcularTiempoDeAtencion(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
