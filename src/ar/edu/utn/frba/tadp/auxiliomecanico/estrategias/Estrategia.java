package ar.edu.utn.frba.tadp.auxiliomecanico.estrategias;

import java.util.Collection;
import java.util.LinkedList;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

public class Estrategia {
	
	private Collection<Camion> camiones = new LinkedList<Camion>();
	private Pedido pedido;
	
	public Estrategia(Pedido unPedido, Camion camion){
		pedido = unPedido;
		camiones.add(camion);
	}

	public void atender(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
	public boolean puedeResolverPedido(){
		return pedido.puedeSerAtendidoPorCamiones(camiones);
	}
	
	public void agregarCamion(Camion camion){
		if (this.haceFalta(camion))
			camiones.add(camion);		
	}

	public boolean haceFalta(Camion camion){
		return pedido.seComplementan(camiones, camion);
	}
}
