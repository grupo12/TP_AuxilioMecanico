package ar.edu.utn.frba.tadp.auxiliomecanico.camiones;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;

public class Minigrua extends Camion {
	
	private static final int LIMITE_PESO = 3;

	@Override
	public int getEconomicidad() {
		return 1;
	}

	@Override
	public boolean puedeAtenderRemolque(Automovil automovil) {
		return !automovil.esMasPesadoQue(LIMITE_PESO);
	}

	@Override
	public boolean puedeAtenderReparacionCompleja() {
		return false;
	}
}
