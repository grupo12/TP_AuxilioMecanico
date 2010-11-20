package ar.edu.utn.frba.tadp.auxiliomecanico.personal;

import java.util.ArrayList;
import java.util.Collection;

public class Tecnico {

	private Collection<EspecialidadTecnico> especialidades;
	private int participacionesEnInundaciones;

	
	// Si o sí tiene que tener al menos una especialidad
	public Tecnico(EspecialidadTecnico e) {
		super();
		this.especialidades = new ArrayList<EspecialidadTecnico>();
		this.addEspecialidad(e);
		this.participacionesEnInundaciones = 0;
	}

	public boolean isTecnicoExperto() {
		return especialidades.size() > 1;
	}
	
	public void addEspecialidad(EspecialidadTecnico e){
		this.especialidades.add(e);
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