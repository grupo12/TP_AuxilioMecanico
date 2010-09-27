package ar.edu.frba.utn.tadp.auxiliomecanico.excepciones;

import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.Pedido;

public class CamionNoDisponibleException extends UserException {

	private static final long serialVersionUID = 1L;

	private Pedido pedido;

	public CamionNoDisponibleException(String string, Pedido pedido) {
		super(string);
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

}
