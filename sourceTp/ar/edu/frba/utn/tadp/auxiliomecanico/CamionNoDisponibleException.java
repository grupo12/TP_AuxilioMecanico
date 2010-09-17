package ar.edu.frba.utn.tadp.auxiliomecanico;

import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.IPedido;

public class CamionNoDisponibleException extends Exception {

	private static final long serialVersionUID = 1L;

	private IPedido pedido;

	public CamionNoDisponibleException(String string, IPedido pedido) {
		super(string);
		this.pedido = pedido;
	}

	public IPedido getPedido() {
		return pedido;
	}

}
