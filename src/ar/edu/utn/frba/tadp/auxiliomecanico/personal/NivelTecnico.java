package ar.edu.utn.frba.tadp.auxiliomecanico.personal;

import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.EspecialidadPedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.InundacionPedido;

public interface NivelTecnico {

	public void addEspecialidad(EspecialidadPedido e);
	
	public boolean isEspecialistaEn(EspecialidadPedido esp);

	public boolean isExperto();

}
