package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.especialidades;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;

public class ElectricaEspecialidad extends Especialidad {

	@Override
	public boolean puedeAtenderte(Camion camion) {
		return camion.tenesUnElectricista();
	}
}
