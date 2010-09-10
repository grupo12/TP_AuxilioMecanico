package ar.edu.frba.utn.tadp.auxiliomecanico;


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
