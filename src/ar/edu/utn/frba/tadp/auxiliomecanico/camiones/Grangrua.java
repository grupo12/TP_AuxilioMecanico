package ar.edu.utn.frba.tadp.auxiliomecanico.camiones;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.CapacidadTecnicosExcedidaException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.PersonalSinExpertoException;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.Personal;

/**
 * Candidata a ser superclase y así unir comportamiento entre granGrua y
 * Minigrua
 * 
 */
public class Grangrua extends Camion {

	private final boolean tallerAltaComplejidad;

	public Grangrua(boolean tallerAltaComplejidad) {
		this.tallerAltaComplejidad = tallerAltaComplejidad;
	}

	@Override
	public int getEconomicidad() {
		return this.tallerAltaComplejidad ? 3 : 2;
	}

	@Override
	public void validarPesonal(Personal personal) {
		if(!personal.hayUnExperto())
			throw new PersonalSinExpertoException("Por cada grupo de personal, se debe contar con un experto.",personal);
		if(personal.cantPersonas() > 3)
			throw new CapacidadTecnicosExcedidaException("La cant. de tecnicos debe ser iguala  1.",personal);
	}

	@Override
	public boolean podesRemolcar(Automovil automovil) {
		return true;
	}
}
