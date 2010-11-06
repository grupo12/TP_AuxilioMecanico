package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

import ar.edu.utn.frba.tadp.auxiliomecanico.personal.Personal;

public class CapacidadTecnicosExcedidaException extends UserException {

	private static final long serialVersionUID = 1L;
	
	private Personal personal;
	
	public CapacidadTecnicosExcedidaException(String message, Personal personal) {
		super(message);
		this.personal = personal;
	}

	public Personal getPersonal() {
		return personal;
	}

}
