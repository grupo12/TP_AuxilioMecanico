package ar.edu.utn.frba.tadp.auxiliomecanico.personal;

import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.EspecialidadPedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.InundacionPedido;

public class NivelPrincipiante implements NivelTecnico{

	private EspecialidadPedido especialidad;
	
	public NivelPrincipiante(EspecialidadPedido especialidad) {
		this.especialidad = especialidad;
	}

	public EspecialidadPedido getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(EspecialidadPedido especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public void addEspecialidad(EspecialidadPedido e) {
		this.especialidad = e;
	}

	@Override
	public boolean isEspecialistaEn(EspecialidadPedido esp) {
		return especialidad.getClass() == esp.getClass();
	}

	@Override
	public boolean isExperto() {
		return false;
	}

}