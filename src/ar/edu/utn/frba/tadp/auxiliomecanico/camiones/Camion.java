package ar.edu.utn.frba.tadp.auxiliomecanico.camiones;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

/**
 * Representa la unidad básica de atención de un taller mecánico. Se encarga de
 * la asistencia de pedidos.
 * 
 */
public abstract class Camion {

	protected List<Pedido> pedidosAsignados;

	public Camion() {
		this.pedidosAsignados = new LinkedList<Pedido>();
	}

	/**
	 * Realiza las acciones necesarias a la hora de ser asignado a un pedido.
	 * 
	 * @param unPedido
	 *            Pedido de atención a atender
	 */
	public void atender(Pedido unPedido) {
		this.pedidosAsignados.add(unPedido);
	}

	/**
	 * Retorna la cantidad de pedidos pendientes.
	 * 
	 * @return Cantidad de pedidos pendientes
	 */
	public int cantidadPedidosPendientes() {
		return this.pedidosAsignados.size();
	}

	/**
	 * Determina si un cierto camión puede atender un pedido de atención que
	 * necesite servicios de reparación simple.
	 * 
	 * @return <b>true</b> - El camión puede antender este servicio<br>
	 *         <b>false</b> - Caso contrario
	 */
	public boolean puedeAtenderReparacionSimple() {
		return true;
	}

	/**
	 * Determina si un cierto camión puede atender un pedido de atención que
	 * necesite servicios de remolque.
	 * 
	 * @return <b>true</b> - El camión puede antender este servicio<br>
	 *         <b>false</b> - Caso contrario
	 */
	public abstract boolean puedeAtenderRemolque(Automovil automovil);

	/**
	 * Determina si un cierto camión puede atender un pedido de atención que
	 * necesite servicios de reparación compleja.
	 * 
	 * @return <b>true</b> - El camión puede antender este servicio<br>
	 *         <b>false</b> - Caso contrario
	 */
	public abstract boolean puedeAtenderReparacionCompleja();

	/**
	 * Nivel de economicidad según el camión y sus características. Permite su
	 * ordenamiento según el valor económico del mismo.
	 * 
	 */
	public abstract int getEconomicidad();

	public Collection<Pedido> getPedidosAsignados() {
		return this.pedidosAsignados;
	}

	/**
	 * Realiza todas las acciones necesarias por un camión cuando concluye un
	 * pedido asignado.
	 * 
	 * @param pedido
	 *            Pedido finalizado
	 */
	public void finalizoPedido(Pedido pedido) {
		this.pedidosAsignados.remove(pedido);
	}
}
