package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;

public class NoHayAutoReemplazoEnElTallerException extends SystemException {
	private static final long serialVersionUID = 1L;

	private final TallerMecanico tallerMecanico;

	public NoHayAutoReemplazoEnElTallerException(TallerMecanico tallerMecanico) {
		this.tallerMecanico = tallerMecanico;
	}

	public TallerMecanico getTallerMecanico() {
		return tallerMecanico;
	}

}
