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
		return unCamion.puedeAtenderRemolque(automovil);
	}

	@Override
	protected void doValidarEspecialidadPara(Cliente cliente) {
		cliente.validarRemolque();
	}

	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		cantidadAtendidos += 1;
		terminado = true;
		sujeto.terminarServicioDelPedido(tiempo);
	}
	
	// BEGIN SANTI
	@Override
	public boolean puedoAtenderte(Camion camion) {
		Automovil a = super.getAutomovil();
		return camion.puedeAtenderRemolque(a);
	}
	// END SANTI

	/*Esto lo resuelve el objeto gps*/
	@Override
	public Tiempo calcularTiempoDeAtencion() {
		throw new UnsupportedOperationException();
	}

}
