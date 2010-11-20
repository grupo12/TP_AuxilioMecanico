package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

public class NoPuedeHaberHeridosSinIncendioOInundacionException extends UserException {

	private static final long serialVersionUID = 1L;

	private final Pedido pedido;

	public NoPuedeHaberHeridosSinIncendioOInundacionException(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

}
