package ar.edu.utn.frba.tadp.auxiliomecanico.servicios;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.PrestadorServicios;

public class RemisServicio implements Servicio {

	private static RemisServicio instance;

	private RemisServicio() {
	}
	
	public static RemisServicio getInstance() {
		if (instance == null)
			instance = new RemisServicio();
	
		return instance;
	}

	public PrestadorServicios getPrestadorServicio(TallerMecanico tallerMecanico) {
		return tallerMecanico.algunRemis();
	}

}
