package ar.edu.utn.frba.tadp.auxiliomecanico.planes;

import java.util.Collection;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.estrategias.Estrategia;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.estrategias.EstrategiaEconomica;

public class EstadoEconomico implements EstadoPlatinum{

	PlatinumPlan plan;
	
	public EstadoEconomico(PlatinumPlan unPlan){
		plan = unPlan;
	}
	
	public void verificarEstado(Cliente cliente) {
		if (cliente.getRelacionCostoBeneficio() < 75)
			plan.setEstado(new EstadoRapido(plan));
	}

	public Estrategia seleccionarEstrategia(Collection<Estrategia> estrategias) {
		return new EstrategiaEconomica().elegirEstrategia(estrategias);
	}

}
