package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;

public class MinitallerNoVerificaPersonalException extends UserException {

	private static final long serialVersionUID = 1L;

	private Camion camion;

	public MinitallerNoVerificaPersonalException(String string, Camion camion) {
		super(string);
		this.camion = camion;
	}

	public Camion getCamion() {
		return camion;
	}

}
