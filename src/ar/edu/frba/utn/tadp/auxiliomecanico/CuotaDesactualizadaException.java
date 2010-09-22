package ar.edu.frba.utn.tadp.auxiliomecanico;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;

public class CuotaDesactualizadaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	
	public CuotaDesactualizadaException(String message, Cliente cliente) {
		super(message);
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
