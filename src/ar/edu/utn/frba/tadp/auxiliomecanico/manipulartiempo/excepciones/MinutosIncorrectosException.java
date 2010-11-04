package ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.UserException;

public class MinutosIncorrectosException extends UserException {

	private static final long serialVersionUID = 1L;

	public MinutosIncorrectosException(String string) {
		super(string);
	}

}
