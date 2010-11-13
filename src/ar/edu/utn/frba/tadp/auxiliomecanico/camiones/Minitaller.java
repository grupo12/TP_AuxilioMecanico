package ar.edu.utn.frba.tadp.auxiliomecanico.camiones;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.CapacidadTecnicosExcedidaException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.PersonalSinExpertoException;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.Personal;

public class Minitaller extends Camion {
	
	@Override
	public int getEconomicidad() {
		return 0;
	}

	@Override
	public boolean hayRemolque(Automovil automovil) {
		return false;
	}

	@Override
	public void validarPesonal(Personal personal) {
		if(!personal.hayUnExperto())
			throw new PersonalSinExpertoException("Por cada grupo de personal, se debe contar con un experto.",personal);
		if(personal.cantPersonas() != 1)
			throw new CapacidadTecnicosExcedidaException("Un minitaller no puede tener más de",personal);
	}
	
}
