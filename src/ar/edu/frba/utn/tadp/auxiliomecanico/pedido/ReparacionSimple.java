package ar.edu.frba.utn.tadp.auxiliomecanico.pedido;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;

public class ReparacionSimple implements Pedido {

	@Override
	public boolean puedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return unCamion.puedeAtenderReparacionSimple();
	}

	@Override
	public boolean esValidoPara(Cliente cliente) {
		return cliente.esValidoReparacionSimple();
	}

	@Override
	public boolean isReparacionSimple() {
		return true;
	}

	@Override
	public boolean isRemolque() {
		return false;
	}
}
