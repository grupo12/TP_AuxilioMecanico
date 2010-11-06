package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;

public class CantidadReparacionesSimplesMaximaEconomicSuperadaException extends UserException {

	private static final long serialVersionUID = 1L;
	
	private final Cliente cliente;
	private final int cantidadMaximaReparacionesSimples;

	public CantidadReparacionesSimplesMaximaEconomicSuperadaException(Cliente cliente,
			int cantidadMaximaReparacionesSimples) {
				this.cliente = cliente;
				this.cantidadMaximaReparacionesSimples = cantidadMaximaReparacionesSimples;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getCantidadMaximaReparacionesSimples() {
		return cantidadMaximaReparacionesSimples;
	}
}
