package ar.edu.frba.utn.tadp.auxiliomecanico.pedido;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;

public class Remolque extends DecoradorPedido {

	public Remolque (IPedido unDecorado){
		this.Decorado = unDecorado;
	}
	
	@Override
	public boolean puedeSerAtendidoPorPlan() {
		if (this.getPlan().puedeAtenderRemolque())
			return this.Decorado.puedeSerAtendidoPorPlan();
		return false;
	}

	@Override
	public boolean puedeSerAtendidoPorCamion(Camion unCamion) {
		// TODO Auto-generated method stub
		return false;
	}

}
