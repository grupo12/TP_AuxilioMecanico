package ar.edu.frba.utn.tadp.auxiliomecanico.pedido;

import ar.edu.frba.utn.tadp.auxiliomecanico.planes.Plan;

public abstract class DecoradorPedido implements IPedido {
	
	public IPedido Decorado;
	
	public Plan getPlan(){
		return this.Decorado.getPlan();
	}

}
