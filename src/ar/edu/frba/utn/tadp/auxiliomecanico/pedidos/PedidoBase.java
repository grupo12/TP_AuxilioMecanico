package ar.edu.frba.utn.tadp.auxiliomecanico.pedidos;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;

public class PedidoBase implements Pedido {

	private final Automovil automovil;
	
	public PedidoBase(Automovil automovil) {
		this.automovil = automovil;
	}
	
	public Cliente getCliente() {
		return this.automovil.getCliente();
	}

	public Automovil getAutomovil() {
		return this.automovil;
	}

	@Override
	public boolean esValidoPara(Cliente cliente) {
		return true;
	}

	@Override
	public boolean puedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return true;
	}

	@Override
	public boolean isReparacionSimple() {
		return false;
	}

	@Override
	public boolean isRemolque() {
		return false;
	}
}
