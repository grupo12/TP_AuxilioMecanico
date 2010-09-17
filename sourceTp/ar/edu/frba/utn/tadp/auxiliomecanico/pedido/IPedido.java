package ar.edu.frba.utn.tadp.auxiliomecanico.pedido;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.Plan;

public interface IPedido {

	public boolean puedeSerAtendidoPorPlan ();
	public boolean puedeSerAtendidoPorCamion (Camion unCamion);
	public Plan getPlan();
	
}
