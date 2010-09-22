package ar.edu.frba.utn.tadp.auxiliomecanico.planes;

import java.util.Collection;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public class ClassicPlan extends Plan {

	private static final int CANTIDAD_MAXIMA_REMOLQUES = 5;

	@Override
	public boolean esValidoRemolquePara(Cliente cliente) {
		return cliente.cantidadRemolquesRealizados() <= CANTIDAD_MAXIMA_REMOLQUES;
	}

	@Override
	public Camion selectCamion(Collection<Camion> camiones) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected double maximoMora(Cliente cliente, ModuloPagos moduloPagos) {
		return 200;
	}

}
