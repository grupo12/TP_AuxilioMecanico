package ar.edu.utn.frba.tadp.auxiliomecanico.personal;

import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.EspecialidadPedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.InundacionPedido;

public class Tecnico {

	private int participacionesEnInundaciones;
	private NivelTecnico nivelTecnico;
	
	// Si o sí tiene que tener al menos una especialidad
	public Tecnico(NivelTecnico nivelTecnico) {
		super();
		this.nivelTecnico = nivelTecnico;
	}

	public boolean isExpertoEnInundaciones() {
		return participacionesEnInundaciones >= 3;
	}

	public void participarEnInundacion() {
		participacionesEnInundaciones++;
		if(participacionesEnInundaciones == 3)
			if(this.isExperto())
				nivelTecnico.addEspecialidad(new InundacionPedido());
			else
				this.ascenderAExperto(new InundacionPedido());
	}

	public boolean isEspecialistaEn(EspecialidadPedido ep){
		return this.nivelTecnico.isEspecialistaEn(ep);
	}

	public boolean isExperto(){
		return this.nivelTecnico.isExperto();
	}


	public void ascenderAExperto(EspecialidadPedido e){
		if(!nivelTecnico.isExperto()){
		NivelPrincipiante aux = (NivelPrincipiante) nivelTecnico;
		nivelTecnico = new NivelExperto();
		nivelTecnico.addEspecialidad(e);
		nivelTecnico.addEspecialidad(aux.getEspecialidad());
		}
	}

}