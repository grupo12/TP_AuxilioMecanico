package ar.edu.utn.frba.tadp.auxiliomecanico.personal;

import java.util.Collection;

public class Tecnico {

	private Collection<EspecialidadTecnico> especialidades;
	private int participacionesEnInundaciones;

	public boolean isTecnicoExperto() {
		return especialidades.size() > 1;
	}

	public boolean isExpertoEnInundaciones() {
		return participacionesEnInundaciones >= 3;
	}

	public void participarEnInundacion() {
		participacionesEnInundaciones++;

	}

	public boolean isElectricista() {
		for(EspecialidadTecnico e: this.especialidades)
			if(e.sosElectricista())
				return true;
		return false;
	}

	public boolean isMecanico() {
		for(EspecialidadTecnico e: this.especialidades)
			if(e.sosMecanico())
				return true;
		return false;
	}

}