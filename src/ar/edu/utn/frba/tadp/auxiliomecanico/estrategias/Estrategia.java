package ar.edu.utn.frba.tadp.auxiliomecanico.estrategias;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

public class Estrategia implements Cloneable {
	/**
	 * Una estrategia es un conjunto de camiones que pueden resolver todos los requisitos de un pedido
	 */
	private Set<Camion> camiones = new HashSet<Camion>();
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

	public Estrategia(Camion... camiones) {
		this.camiones = new HashSet<Camion>(Arrays.asList(camiones));
	}

	public Estrategia(Pedido pedido) {
		this.pedido = pedido;
	}

	public Estrategia clone() {
		try {
			return (Estrategia) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atender(Pedido pedido) {
		for (Camion camion: camiones){
			camion.atender(pedido);
		}
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
	
	
	public Tiempo getTiempoEstimado(){
		return Tiempo.sumarTiempos(this.tiempoDePedidosPendientes(),pedido.calcularTiempoDeAtencion());
	}
	
	public Tiempo tiempoDePedidosPendientes(){
		Tiempo max = new Tiempo().nuevoTiempo(0,0);
		Tiempo aux = new Tiempo().nuevoTiempo(0,0);
		for(Camion camion: camiones){
			aux = camion.tiempoDePedidosPendientes();
			if (Tiempo.esMayor(aux, max))
				max = aux;
		}
		return max;
	}

	public int getCosto() {
		int costoHoraCamiones = 0;
		for(Camion camion: camiones){
			costoHoraCamiones += camion.getCostoHora();
		}
		return Tiempo.calcularCosto(pedido.calcularTiempoDeAtencion(), costoHoraCamiones);
	}
	
	public void atender() {
		for(Camion camion: camiones){
			camion.atender(pedido);
		}
	}
	
	public void atenderUrgencia() {
		for(Camion camion: camiones){
			camion.atenderUrgencia(pedido);
		}
	}
}
