package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;

public class EconomicNoPuedeAtenderRemolqueException extends UserException {

	private static final long serialVersionUID = 1L;

	private final Cliente cliente;

	public EconomicNoPuedeAtenderRemolqueException(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}
}
