package ar.edu.utn.frba.tadp.auxiliomecanico.clientes;

/**
 * Representa el vehículo de un cliente determinado.
 *
 */
public class Automovil {

	private Cliente cliente;
	private double peso;

	/**
	 * Instancia un nuevo automóvil con su peso y cliente determinados.
	 * @param peso Peso del nuevo automóvil
	 * @param cliente Cliente al que pertenecerá el nuevo automóvil
	 */
	public Automovil(double peso, Cliente cliente) {
		this.cliente = cliente;
		this.peso = peso;
	}

	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Permite saber si un auto es más pesado que un peso dado.
	 * @param peso Peso en toneladas
	 * @return	<b>true</b> - El auto es más pesado<br>
	 * 			<b>false</b> - En otro caso
	 */
	public boolean esMasPesadoQue(double peso) {
		return this.peso > peso;
	}
}
