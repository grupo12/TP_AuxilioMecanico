package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;

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
