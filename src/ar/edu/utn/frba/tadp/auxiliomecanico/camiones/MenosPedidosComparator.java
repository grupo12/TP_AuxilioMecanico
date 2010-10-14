package ar.edu.utn.frba.tadp.auxiliomecanico.camiones;

import java.util.Comparator;

/**
 * Encargado de definir el criterio de ordenamiento entre camiones según la
 * cantidad de pedidos del mismo.
 * 
 */
public class MenosPedidosComparator implements Comparator<Camion> {

	/**
	 * Realiza la comparación en ordenamiento entre dos camiones según la
	 * cantidad de pedidos que tengan asignados.
	 */
	@Override
	public int compare(Camion camion1, Camion camion2) {
		return camion1.cantidadPedidosPendientes() - camion2.cantidadPedidosPendientes();
	}

}
