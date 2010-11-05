package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

public class ModuloPagosFaltanteException extends SystemException {

	private static final long serialVersionUID = 1L;

	public ModuloPagosFaltanteException() {
		super();
	}

	public ModuloPagosFaltanteException(String message, Throwable cause) {
		super(message, cause);
	}

	public ModuloPagosFaltanteException(String message) {
		super(message);
	}

	public ModuloPagosFaltanteException(Throwable cause) {
		super(cause);
	}

}
