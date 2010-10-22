package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;

public class Remolque extends EspecialidadPedido {
	
	private static int cantidadAtendidos;
	private boolean terminado;
	
	public Remolque(Pedido sujeto) {
		super(sujeto);
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
	public Tiempo calcularTiempoDeAtencion(Pedido pedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean finalizarElPedido() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void terminarPedido(Tiempo tiempo) {
		cantidadAtendidos += 1;
		terminado = true;
	}
	
}
