package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.especialidades;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;

public class MecanicaEspecialidad extends Especialidad {

	@Override
	public boolean puedeAtenderte(Camion camion) {
		return camion.hayUnMecanico();
	}
}
