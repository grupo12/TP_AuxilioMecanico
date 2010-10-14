package ar.edu.utn.frba.tadp.auxiliomecanico.planes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.MasEconomicoComparator;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

/**
 * Representa un plan de servicios ofrecido por el sistema de taller mec�nico a
 * sus clientes.
 * 
 */
public abstract class Plan {

	/**
	 * Determina si un cliente est� al d�a con sus pagos en base al m�dulo de
	 * pagos del sistema.
	 * 
	 * @param cliente
	 *            Cliente que tiene al plan
	 * @param moduloPagos
	 *            M�dulo de pagos del sistema
	 * @return �Est� la cuota al d�a?
	 */
	public boolean isCuotaAlDia(Cliente cliente, ModuloPagos moduloPagos) {
		return moduloPagos.moraDe(cliente) <= this.maximoMora(cliente, moduloPagos);
	}

	/**
	 * Responde con el m�ximo de mora que puede tener un cliente en el sistema.
	 * 
	 * @param cliente
	 *            Cliente que tiene al plan
	 * @param moduloPagos
	 *            M�dulo de pagos del sistema
	 * @return Mora m�xima que puede tener el sistema
	 */
	protected abstract double maximoMora(Cliente cliente, ModuloPagos moduloPagos);

	/**
	 * Responde si el cliente del plan puede atender con un servicio de
	 * reparaci�n simple.
	 * 
	 * @param cliente
	 *            Cliente del plan
	 * @return Valor de validez
	 */
	public boolean esValidoReparacionSimplePara(Cliente cliente) {
		return true;
	}

	/**
	 * Responde si el cliente del plan puede atender con un servicio de
	 * reparaci�n compleja.
	 * 
	 * @param cliente
	 *            Cliente del plan
	 * @return Valor de validez
	 */

	public boolean esValidoReparacionComplejaPara(Cliente cliente) {
		return true;
	}

	/**
	 * Responde si el cliente del plan puede atender con un servicio de
	 * remolque.
	 * 
	 * @param cliente
	 *            Cliente del plan
	 * @return Valor de validez
	 */

	public abstract boolean esValidoRemolquePara(Cliente cliente);

	/**
	 * Selecciona un cami�n seg�n el criterio espec�fico del plan.
	 * 
	 * @param camiones
	 *            Camiones para atender al cliente del plan
	 * @return Cami�n seleccionado
	 */
	public Camion selectCamion(Collection<Camion> camiones) {
		List<Camion> camionesOrdenados = new ArrayList<Camion>(camiones);

		Collections.sort(camionesOrdenados, new MasEconomicoComparator());

		return camionesOrdenados.get(0);
	}
}
