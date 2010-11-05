package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

public class AsignaPedidoBaseAUnoExistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	private Pedido pedido;

	public AsignaPedidoBaseAUnoExistenteException(String string, Pedido pedido) {
		super(string);
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

}
