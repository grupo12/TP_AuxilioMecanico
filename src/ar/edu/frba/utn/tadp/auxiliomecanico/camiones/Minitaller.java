package ar.edu.frba.utn.tadp.auxiliomecanico.camiones;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;


public class Minitaller extends Camion {
	
	@Override
	public int getEconomicidad() {
		return 0;
	}

	@Override
	public boolean puedeAtenderRemolque(Automovil automovil) {
		return false;
	}

	@Override
	public boolean puedeAtenderReparacionCompleja() {
		return false;
	}
}
