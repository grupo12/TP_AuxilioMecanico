package ar.edu.utn.frba.tadp.auxiliomecanico.personas;

import java.util.Collection;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;

public class Tecnico {

	private Collection<Especialidad> especialidades;
	private Camion camionAsignado;
	private int participacionesEnInundaciones;

	public boolean isTecnicoExperto() {
		return especialidades.size() > 1;
	}

	public boolean isExpertoInundaciones() {
		return participacionesEnInundaciones >= 3;
	}

	public void participarEnInundacion() {
		participacionesEnInundaciones++;

	}

	public void setCamionAsignado(Camion camionAsignado) {
		this.camionAsignado = camionAsignado;
	}

	public Camion getCamionAsignado() {
		return camionAsignado;
	}

}