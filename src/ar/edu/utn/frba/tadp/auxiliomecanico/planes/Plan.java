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
 * Representa un plan de servicios ofrecido por el sistema de taller mecánico a
 * sus clientes.
 * 
 */
public abstract class Plan {

	/**
	 * Responde con el máximo de mora que puede tener un cliente en el sistema.
	 * 
	 * @param cliente
	 *            Cliente que tiene al plan
	 * @param moduloPagos
	 *            Módulo de pagos del sistema
	 * @return Mora máxima que puede tener el sistema
	 */
	public abstract double maximoMoraPara(Cliente cliente, ModuloPagos moduloPagos);

	/**
	 * Selecciona un camión según el criterio específico del plan.
	 * 
	 * @param camiones
	 *            Camiones para atender al cliente del plan
	 * @return Camión seleccionado
	 */
	public Camion selectCamion(Collection<Camion> camiones) {
		List<Camion> camionesOrdenados = new ArrayList<Camion>(camiones);

		Collections.sort(camionesOrdenados, new MasEconomicoComparator());

		return camionesOrdenados.get(0);
	}

	public abstract void validarRemolquePara(Cliente cliente);

	public void validarReparacionSimplePara(Cliente cliente) {
		// Por defecto es válida una reparación simple para los planes
	}

	public void validarReparacionComplejaPara(Cliente cliente) {
		// Por defecto es válida una reparación compleja para los planes
	}

	public Estrategia selectEstrategia(Collection<Estrategia> estrategias) {
		return new EstrategiaEconomica().elegirEstrategia(estrategias);
	}
}
