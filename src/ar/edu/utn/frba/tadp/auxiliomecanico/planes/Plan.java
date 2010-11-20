package ar.edu.utn.frba.tadp.auxiliomecanico.planes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.MasEconomicoComparator;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.estrategias.Estrategia;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.estrategias.EstrategiaEconomica;

/**
 * Representa un plan de servicios ofrecido por el sistema de taller mec�nico a
 * sus clientes.
 * 
 */
public abstract class Plan {

	/**
	 * Responde con el m�ximo de mora que puede tener un cliente en el sistema.
	 * 
	 * @param cliente
	 *            Cliente que tiene al plan
	 * @param moduloPagos
	 *            M�dulo de pagos del sistema
	 * @return Mora m�xima que puede tener el sistema
	 */
	public abstract double maximoMoraPara(Cliente cliente, ModuloPagos moduloPagos);

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

	public abstract void validarRemolquePara(Cliente cliente);

	public void validarReparacionSimplePara(Cliente cliente) {
		// Por defecto es v�lida una reparaci�n simple para los planes
	}

	public void validarReparacionComplejaPara(Cliente cliente) {
		// Por defecto es v�lida una reparaci�n compleja para los planes
	}

	public Estrategia selectEstrategia(Collection<Estrategia> estrategias) {
		return new EstrategiaEconomica().elegirEstrategia(estrategias);
	}
}
