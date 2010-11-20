package ar.edu.utn.frba.tadp.auxiliomecanico.planes;

import java.util.Collection;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.estrategias.Estrategia;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.estrategias.EstrategiaRapida;

public class EstadoRapido implements EstadoPlatinum{

	PlatinumPlan plan;
	
	public EstadoRapido(PlatinumPlan unPlan){
		plan = unPlan;
	}
	
	public void verificarEstado(Cliente cliente) {
		if (!cliente.esRentableElCliente())
			plan.setEstado(new EstadoEconomico(plan));
	}

	public Estrategia seleccionarEstrategia(Collection<Estrategia> estrategias) {
		return new EstrategiaRapida().elegirEstrategia(estrategias);
	}

}
