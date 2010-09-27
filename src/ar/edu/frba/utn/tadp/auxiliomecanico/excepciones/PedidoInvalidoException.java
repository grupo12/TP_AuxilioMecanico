package ar.edu.frba.utn.tadp.auxiliomecanico.excepciones;

import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.Pedido;

public class PedidoInvalidoException extends UserException {

	private static final long serialVersionUID = 1;
	
	private Pedido pedido;

	public PedidoInvalidoException(String string, Pedido pedido) {
		super(string);
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}
}
