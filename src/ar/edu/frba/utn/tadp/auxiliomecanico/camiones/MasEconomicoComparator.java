package ar.edu.frba.utn.tadp.auxiliomecanico.camiones;

import java.util.Comparator;


public class MasEconomicoComparator implements Comparator<Camion> {

	@Override
	public int compare(Camion camion1, Camion camion2) {
		return camion1.getEconomicidad() - camion2.getEconomicidad();
	}

}
