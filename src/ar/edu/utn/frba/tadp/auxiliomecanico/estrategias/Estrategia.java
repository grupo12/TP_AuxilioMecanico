package ar.edu.utn.frba.tadp.auxiliomecanico.estrategias;

import java.util.Collection;
import java.util.LinkedList;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

public class Estrategia {
	/**
	 * Una estrategia es un conjunto de camiones que pueden resolver todos los requisitos de un pedido
	 */
	private Collection<Camion> camiones = new LinkedList<Camion>();
	private Pedido pedido;
	
	/**
	 * Inicializa la estrategia con el pedido correspondiente y un primer camion que resuelva alguno de los requisitos del pedido
	 * @param unPedido
	 * 				El pedido al que pertenece la estrategia
	 * @param camion
	 * 				El primer camion de la estrategia
	 */
	public Estrategia(Pedido unPedido, Camion camion){
		pedido = unPedido;
		camiones.add(camion);
	}

	public void atender(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Determina si la estrategia puede resolver la totalidad del pedido
	 */
	public boolean puedeResolverPedido(){
		return pedido.puedeSerAtendidoPorCamiones(camiones);
	}
	
	/**
	 * Chequea que el camion a agregar haga un aporte a la solucion del pedido y en caso de ser afirmativo lo suma a la estrategia
	 * @param camion
	 * 				Un camion a agregar a la estrategia
	 */
	public void agregarCamion(Camion camion){
		if (this.haceFalta(camion))
			camiones.add(camion);		
	}

	/**
	 * Chequea que el camion haga falta o si no aporta en la solucion del pedido
	 * @param camion
	 * 				El camion a ser comprobado
	 */
	public boolean haceFalta(Camion camion){
		return pedido.seComplementan(camiones, camion);
	}
}
