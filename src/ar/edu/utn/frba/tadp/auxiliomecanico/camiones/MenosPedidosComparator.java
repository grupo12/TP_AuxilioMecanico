package ar.edu.utn.frba.tadp.auxiliomecanico.camiones;

import java.util.Comparator;

/**
 * Encargado de definir el criterio de ordenamiento entre camiones seg�n la
 * cantidad de pedidos del mismo.
 * 
 */
public class MenosPedidosComparator implements Comparator<Camion> {

	/**
	 * Realiza la comparaci�n en ordenamiento entre dos camiones seg�n la
	 * cantidad de pedidos que tengan asignados.
	 */
	@Override
	public int compare(Camion camion1, Camion camion2) {
		return camion1.cantidadPedidosPendientes() - camion2.cantidadPedidosPendientes();
	}

}
