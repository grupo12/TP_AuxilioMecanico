package ar.edu.frba.utn.tadp.auxiliomecanico.pedidos;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;

public class Remolque extends EspecialidadPedido {

	public Remolque(Pedido sujeto) {
		super(sujeto);
	}
	
	public boolean isRemolque() {
		return true;
	}
	
	@Override
	protected boolean doEsValidoPara(Cliente cliente) {
		return cliente.esValidoRemolque();
	}

	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return unCamion.puedeAtenderRemolque(automovil);
	}
}
