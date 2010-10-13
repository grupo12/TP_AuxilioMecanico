package ar.edu.frba.utn.tadp.auxiliomecanico.pedidos;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;

public class ReparacionCompleja extends EspecialidadPedido {

	public ReparacionCompleja(Pedido sujeto) {
		super(sujeto);
	}

	@Override
	protected boolean doEsValidoPara(Cliente cliente) {
		return cliente.esValidoReparacionCompleja();
	}

	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return unCamion.puedeAtenderReparacionCompleja();
	}
}
