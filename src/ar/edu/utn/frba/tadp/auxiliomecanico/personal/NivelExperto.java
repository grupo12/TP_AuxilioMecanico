package ar.edu.utn.frba.tadp.auxiliomecanico.personal;

import java.util.ArrayList;
import java.util.Collection;

import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.EspecialidadPedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.InundacionPedido;

public class NivelExperto implements NivelTecnico{

	private Collection<EspecialidadPedido> especialidades = new ArrayList<EspecialidadPedido>();

	@Override
	public boolean isEspecialistaEn(EspecialidadPedido esp){
		for(EspecialidadPedido e : especialidades)
			if(esp.getClass() == e.getClass())
			return true;
		return false;
	}
	
	@Override
	public void addEspecialidad(EspecialidadPedido e){
		this.especialidades.add(e);
	}

	@Override
	public boolean isExperto() {
		return true;
	}

}
