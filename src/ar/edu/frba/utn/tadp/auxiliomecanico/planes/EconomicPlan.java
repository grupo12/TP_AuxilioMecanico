package ar.edu.frba.utn.tadp.auxiliomecanico.planes;

import java.util.Collection;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public class EconomicPlan extends Plan {
	
	private static final int CANTIDAD_MAXIMA_REPARACIONES_SIMPLES = 5;

	@Override
	public boolean isCuotaAlDia(Cliente cliente, ModuloPagos moduloPagos) {
		return moduloPagos.moraDe(cliente) == 0;
	}

	@Override
	public boolean esValidoReparacionSimplePara(Cliente cliente) {
		return cliente.cantidadReparacionesSimplesRealizadas() <= CANTIDAD_MAXIMA_REPARACIONES_SIMPLES;
	}

	@Override
	public boolean esValidoReparacionComplejaPara(Cliente cliente) {
		return false;
	}

	@Override
	public boolean esValidoRemolquePara(Cliente cliente) {
		return false;
	}

	@Override
	public Camion selectCamion(Collection<Camion> camiones) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected double maximoMora(Cliente cliente, ModuloPagos moduloPagos) {
		return 0;
	}
}
