package ar.edu.frba.utn.tadp.auxiliomecanico.pedido;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.Plan;

public class Pedido implements IPedido {
	
	private Automovil automovil;

	public Pedido(Automovil automovil) {
		this.automovil = automovil;
	}

	public Automovil getAutomovil() {
		return automovil;
	}

	public boolean sonServiciosValidos() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedeSerAtendidoPorPlan() {
		return true;
	}

	@Override
	public Plan getPlan() {
		return this.automovil.getPlan();
	}

	@Override
	public boolean puedeSerAtendidoPorCamion(Camion unCamion) {
		// TODO Auto-generated method stub
		return false;
	}

}
