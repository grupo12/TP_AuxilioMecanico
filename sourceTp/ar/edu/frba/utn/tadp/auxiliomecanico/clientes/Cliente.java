package ar.edu.frba.utn.tadp.auxiliomecanico.clientes;

import ar.edu.frba.utn.tadp.auxiliomecanico.planes.Plan;

public class Cliente {

	private Plan plan;

	public Cliente(Plan plan) {
		this.plan = plan;
	}

	public boolean isCuotaAlDia() {
		return plan.isCuotaAlDia(this);
	}

}
