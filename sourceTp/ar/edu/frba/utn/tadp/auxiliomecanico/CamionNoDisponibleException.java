package ar.edu.frba.utn.tadp.auxiliomecanico;

public class CamionNoDisponibleException extends Exception {

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
