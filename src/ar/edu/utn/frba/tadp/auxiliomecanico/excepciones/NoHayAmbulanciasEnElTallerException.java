package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;

public class NoHayAmbulanciasEnElTallerException extends UserException {
	private static final long serialVersionUID = 1L;

	private final TallerMecanico tallerMecanico;

	public NoHayAmbulanciasEnElTallerException(TallerMecanico tallerMecanico) {
		this.tallerMecanico = tallerMecanico;
	}

	public TallerMecanico getTallerMecanico() {
		return tallerMecanico;
	}

}
