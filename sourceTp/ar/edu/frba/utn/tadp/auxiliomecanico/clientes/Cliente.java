package ar.edu.frba.utn.tadp.auxiliomecanico.clientes;

import ar.edu.frba.utn.tadp.auxiliomecanico.planes.Plan;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public class Cliente {

	private Plan plan;

	public Cliente(Plan plan) {
		this.plan = plan;
	}

	public boolean isCuotaAlDia(ModuloPagos moduloPagos) {
		return plan.isCuotaAlDia(this,moduloPagos);
	}

	public Plan getPlan(){
		return this.plan;
	}
}
