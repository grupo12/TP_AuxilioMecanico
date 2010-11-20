package ar.edu.utn.frba.tadp.auxiliomecanico.planes.estrategias;

import java.util.Collection;
import java.util.Collections;

import ar.edu.utn.frba.tadp.auxiliomecanico.estrategias.Estrategia;

public class EstrategiaEconomica implements ISelectorEstrategias{

	@Override
	public Estrategia elegirEstrategia(Collection<Estrategia> estrategias) {
		return Collections.min(estrategias, new ComparadorEconomico());
	}
}
