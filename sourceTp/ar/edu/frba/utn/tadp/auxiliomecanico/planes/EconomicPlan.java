package ar.edu.frba.utn.tadp.auxiliomecanico.planes;

import java.util.Collection;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public class EconomicPlan implements Plan {
	
	private int CantReparaciones = 0;
	
	@Override
	public boolean isCuotaAlDia(Cliente cliente, ModuloPagos moduloPagos) {
		return (moduloPagos.moraDe(cliente) == 0) ;
	}

	@Override
	public boolean puedeAtenderReparacionSimple() {
		return (this.CantReparaciones <= 5);
	}

	@Override
	public boolean puedeAtenderReparacionCompleja() {
		return false;
	}

	@Override
	public boolean puedeAtenderRemolque() {
		return false;
	}

	@Override
	public Camion selectCamion(Collection<Camion> camiones) {
		// TODO Auto-generated method stub
		return null;
	}

}
