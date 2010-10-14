package ar.edu.utn.frba.tadp.auxiliomecanico.camiones;

import java.util.Comparator;

/**
 * Encargado de definir el criterio de ordenamiento entre camiones según la
 * economicidad del mismo.
 * 
 */
public class MasEconomicoComparator implements Comparator<Camion> {

	/**
	 * Realiza la comparación en ordenamiento entre dos camiones según su
	 * economicidad.
	 */
	@Override
	public int compare(Camion camion1, Camion camion2) {
		return camion1.getEconomicidad() - camion2.getEconomicidad();
	}

}
