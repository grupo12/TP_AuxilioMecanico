package ar.edu.utn.frba.tadp.auxiliomecanico.servicios;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.PrestadorServicios;

public class AutoReemplazoServicio {

	private static AutoReemplazoServicio instance;

	private AutoReemplazoServicio() {
	}
	
	public static AutoReemplazoServicio getInstance() {
		if (instance == null)
			instance = new AutoReemplazoServicio();
	
		return instance;
	}

	public PrestadorServicios getPrestadorServicio(TallerMecanico tallerMecanico) {
		return tallerMecanico.algunAutoReemplazo();
	}

}
