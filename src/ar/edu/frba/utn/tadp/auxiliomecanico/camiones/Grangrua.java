package ar.edu.frba.utn.tadp.auxiliomecanico.camiones;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;

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
	public boolean puedeAtenderRemolque(Automovil automovil) {
		return true;
	}

	@Override
	public boolean puedeAtenderReparacionCompleja() {
		return this.tallerAltaComplejidad;
	}
}
