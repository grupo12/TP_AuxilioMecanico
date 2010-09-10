package ar.edu.frba.utn.tadp.auxiliomecanico.planes;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public class EconomicPlan implements Plan {
	@Override
	public boolean isCuotaAlDia(Cliente cliente, ModuloPagos moduloPagos) {
		return (moduloPagos.moraDe(cliente) == 0) ;
	}

}
