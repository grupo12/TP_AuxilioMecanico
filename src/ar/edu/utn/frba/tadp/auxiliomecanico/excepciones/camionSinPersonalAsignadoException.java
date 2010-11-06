package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.EspecialidadPedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

public class camionSinPersonalAsignadoException extends UserException {

	private static final long serialVersionUID = 1L;

	private Pedido ep;

	public camionSinPersonalAsignadoException(String string, EspecialidadPedido ep) {
		super(string);
		this.ep = ep;
	}

	public Pedido getPedido() {
		return ep;
	}

}

