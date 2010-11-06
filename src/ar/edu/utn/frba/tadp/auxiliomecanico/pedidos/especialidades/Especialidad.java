package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.especialidades;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;

public abstract class Especialidad {

	public abstract boolean puedeAtenderte(Camion camion);
	
}
