package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

public class NoHayEstrategiasPosiblesException extends UserException {

	private static final long serialVersionUID = 1L;

	private final Pedido pedido;
	private final TallerMecanico tallerMecanico;

	public NoHayEstrategiasPosiblesException(Pedido pedido, TallerMecanico tallerMecanico) {
		this.pedido = pedido;
		this.tallerMecanico = tallerMecanico;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public TallerMecanico getTallerMecanico() {
		return tallerMecanico;
	}

}
