package ar.edu.utn.frba.tadp.auxiliomecanico.planes;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public class ClassicPlan extends Plan {

	private static final int CANTIDAD_MAXIMA_REMOLQUES = 5;

	@Override
	public boolean esValidoRemolquePara(Cliente cliente) {
		return cliente.cantidadRemolquesRealizados() <= CANTIDAD_MAXIMA_REMOLQUES;
	}

	@Override
	protected double maximoMora(Cliente cliente, ModuloPagos moduloPagos) {
		return 200;
	}

}
