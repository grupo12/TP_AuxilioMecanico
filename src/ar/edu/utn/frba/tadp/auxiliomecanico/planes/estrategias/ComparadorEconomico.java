package ar.edu.utn.frba.tadp.auxiliomecanico.planes.estrategias;

import java.util.Comparator;

import ar.edu.utn.frba.tadp.auxiliomecanico.estrategias.Estrategia;

public class ComparadorEconomico implements Comparator<Estrategia>{

	@Override
	public int compare(Estrategia o1, Estrategia o2) {
		return o1.getCosto() - o2.getCosto();
	}
}
