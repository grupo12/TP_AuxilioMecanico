package ar.edu.frba.utn.tadp.auxiliomecanico.excepciones;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserException() {
	}

	public UserException(String arg0) {
		super(arg0);
	}

	public UserException(Throwable arg0) {
		super(arg0);
	}

	public UserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
