package ar.edu.frba.utn.tadp.auxiliomecanico;

import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.Pedido;


public class ServicioInvalidoException extends Exception {

	private static final long serialVersionUID = 1;
	
	private Pedido pedido;

	public ServicioInvalidoException(String string, Pedido pedido) {
		super(string);
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

}
