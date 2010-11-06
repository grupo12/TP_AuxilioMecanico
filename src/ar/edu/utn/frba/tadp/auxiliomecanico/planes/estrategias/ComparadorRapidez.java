package ar.edu.utn.frba.tadp.auxiliomecanico.planes.estrategias;

import java.util.Comparator;

import ar.edu.utn.frba.tadp.auxiliomecanico.estrategias.Estrategia;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;

public class ComparadorRapidez implements Comparator<Estrategia>{

	@Override
	public int compare(Estrategia o1, Estrategia o2) {
		if (Tiempo.esMayor(o1.getTiempoEstimado(), o2.getTiempoEstimado()))
			return 1;
		return -1;
	}

}
