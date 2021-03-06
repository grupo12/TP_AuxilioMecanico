package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;

public class CuotaDesactualizadaException extends UserException {

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
