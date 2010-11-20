package ar.edu.utn.frba.tadp.auxiliomecanico.servicios;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.PrestadorServicios;

public interface Servicio {

	public PrestadorServicios getPrestadorServicio(TallerMecanico tallerMecanico);

}
