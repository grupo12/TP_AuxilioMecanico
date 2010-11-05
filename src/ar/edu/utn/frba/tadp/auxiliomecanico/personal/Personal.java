package ar.edu.utn.frba.tadp.auxiliomecanico.personal;

import java.util.Collection;

public class Personal {

	private Collection <Tecnico> tecnicos;
	
	public boolean hayExpertos() {
		for(Tecnico t:tecnicos) 
			if(t.isTecnicoExperto())
				return true;
		return false;
	}

	public void addTecnico(Tecnico t){
		tecnicos.add(t);
	}
	
	public void consignarExperiencia(){
		for(Tecnico t: tecnicos){
			t.participarEnInundacion();
		}
	}

	public int cantidadAyudantesDisponibles() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean hayUnElectricista() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hayUnMecanico() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hayTecnicoExpertoInundaciones() {
		// TODO Auto-generated method stub
		return false;
	}
}
