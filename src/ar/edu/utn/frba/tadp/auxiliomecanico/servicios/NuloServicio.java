package ar.edu.utn.frba.tadp.auxiliomecanico.servicios;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.PrestadorServicios;

public class NuloServicio implements Servicio {

	private static NuloServicio instance;

	private NuloServicio() {
	}
	
	public static NuloServicio getInstance() {
		if (instance == null)
			instance = new NuloServicio();
	
		return instance;
	}

	@Override
	public PrestadorServicios getPrestadorServicio(TallerMecanico tallerMecanico) {
		return null;
	}

}
