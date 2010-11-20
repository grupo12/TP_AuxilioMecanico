package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;

public class NoHayRemisEnElTallerException extends SystemException {
	private static final long serialVersionUID = 1L;

	private final TallerMecanico tallerMecanico;

	public NoHayRemisEnElTallerException(TallerMecanico tallerMecanico) {
		this.tallerMecanico = tallerMecanico;
	}

	public TallerMecanico getTallerMecanico() {
		return tallerMecanico;
	}

}
