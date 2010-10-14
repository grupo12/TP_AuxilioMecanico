package ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;

/**
 * Representa la interfaz específica con el módulo de pagos del sistema.
 * 
 */
public interface ModuloPagos {

	/**
	 * Responde la mora que tiene un cliente dado en el momento de ser
	 * consultado el módulo.
	 * 
	 * @param cliente
	 *            Cliente del sistema
	 * @return Mora del cliente
	 */
	public double moraDe(Cliente cliente);

}
