package ar.edu.utn.frba.tadp.auxiliomecanico.camiones;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.CapacidadTecnicosExcedidaException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.PersonalSinExpertoException;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.Personal;

/**
 * Candidata a ser superclase y as� unir comportamiento entre granGrua y
 * Minigrua
 * 
 */
public class Minigrua extends Camion {

	private static final int LIMITE_PESO = 3;

	@Override
	public int getEconomicidad() {
		return 1;
	}

	@Override
	public void validarPesonal(Personal personal) {
		if (!personal.hayUnExperto())
			throw new PersonalSinExpertoException(
					"Por cada grupo de personal, se debe contar con un experto.",
					personal);
		if (personal.cantPersonas() > 3)
			throw new CapacidadTecnicosExcedidaException(
					"La cant. de tecnicos debe ser iguala  1.", personal);
	}

	@Override
	public boolean podesRemolcar(Automovil automovil) {
		return !automovil.esMasPesadoQue(LIMITE_PESO);
	}
}
