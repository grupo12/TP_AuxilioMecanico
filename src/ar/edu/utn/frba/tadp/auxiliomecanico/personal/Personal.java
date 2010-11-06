package ar.edu.utn.frba.tadp.auxiliomecanico.personal;

import java.util.Collection;

public class Personal {

	private Collection<Tecnico> tecnicos;

	public boolean hayUnExperto() {
		for (Tecnico t : tecnicos)
			if (t.isTecnicoExperto())
				return true;
		return false;
	}

	public void addTecnico(Tecnico t) {
		tecnicos.add(t);
	}

	public void consignarExperiencia() {
		for (Tecnico t : tecnicos) {
			t.participarEnInundacion();
		}
	}

	public int cantidadAyudantesDisponibles() {
		return 0;
	}

	public boolean hayUnElectricista() {
		for (Tecnico t : tecnicos)
			if (t.isElectricista())
				return true;
		return false;
	}

	public boolean hayUnMecanico() {
		for (Tecnico t : tecnicos)
			if (t.isMecanico())
				return true;
		return false;
	}

	public boolean hayUnTecnicoExpertoInundaciones() {
		for (Tecnico t : tecnicos)
			if (t.isExpertoEnInundaciones())
				return true;
		return false;
	}

	public int cantPersonas() {
		return this.tecnicos.size();
	}
}
