package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;

public class CantidadRemolquesMaximaClassicSuperadaException extends UserException {

	private static final long serialVersionUID = 1L;
	
	private final Cliente cliente;
	private final int cantidadMaximaRemolques;

	public CantidadRemolquesMaximaClassicSuperadaException(Cliente cliente, int cantidadMaximaRemolques) {
		this.cliente = cliente;
		this.cantidadMaximaRemolques = cantidadMaximaRemolques;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getCantidadMaximaRemolques() {
		return cantidadMaximaRemolques;
	}
}
