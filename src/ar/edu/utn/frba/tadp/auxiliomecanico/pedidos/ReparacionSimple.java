package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;

public class ReparacionSimple extends EspecialidadPedido {

	public ReparacionSimple(Pedido sujeto) {
		super(sujeto);
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
}
