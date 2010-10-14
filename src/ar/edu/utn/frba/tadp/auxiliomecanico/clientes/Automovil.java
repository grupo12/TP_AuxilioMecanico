package ar.edu.utn.frba.tadp.auxiliomecanico.clientes;

/**
 * Representa el veh�culo de un cliente determinado.
 *
 */
public class Automovil {

	private Cliente cliente;
	private double peso;

	/**
	 * Instancia un nuevo autom�vil con su peso y cliente determinados.
	 * @param peso Peso del nuevo autom�vil
	 * @param cliente Cliente al que pertenecer� el nuevo autom�vil
	 */
	public Automovil(double peso, Cliente cliente) {
		this.cliente = cliente;
		this.peso = peso;
	}

	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Permite saber si un auto es m�s pesado que un peso dado.
	 * @param peso Peso en toneladas
	 * @return	<b>true</b> - El auto es m�s pesado<br>
	 * 			<b>false</b> - En otro caso
	 */
	public boolean esMasPesadoQue(double peso) {
		return this.peso > peso;
	}
}
