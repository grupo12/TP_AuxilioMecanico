package ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.UserException;

public class HorasIncorrectasException extends UserException {
	
	private static final long serialVersionUID = 1L;

	public HorasIncorrectasException(String string) {
		super(string);
	}

}
