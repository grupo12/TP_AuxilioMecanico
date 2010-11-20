package ar.edu.utn.frba.tadp.auxiliomecanico.personal;

import java.util.ArrayList;
import java.util.Collection;

import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.EspecialidadPedido;

public class Personal {

	private Collection<Tecnico> tecnicos;

	public Personal() {
		super();
		tecnicos = new ArrayList<Tecnico>();
	}

	public void addTecnico(Tecnico t) {
		tecnicos.add(t);
	}

	public void consignarExperiencia() {
		for (Tecnico t : tecnicos) {
			t.participarEnInundacion();
		}
	}

	//Supongo q cada camion tiene un experto, el resto, sean lo que sean, son ayudantes 
	public int cantidadAyudantesDisponibles() {
		return this.cantPersonas() - 1;
	}

	public int cantPersonas() {
		return this.tecnicos.size();
	}


	public boolean hayUnExperto() {
		for (Tecnico t : tecnicos)
			if (t.isExperto())
				return true;
		return false;
	}

	public boolean hayAlgunaTecnicoEspecialistaEn(EspecialidadPedido ep) {
		for(Tecnico t: tecnicos){
			if(t.isEspecialistaEn(ep)){
				return true;
			}
		}
		return false;
	}

}
