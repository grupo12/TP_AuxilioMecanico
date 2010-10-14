package ar.edu.utn.frba.tadp.auxiliomecanico.camiones;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

/**
 * Representa la unidad b�sica de atenci�n de un taller mec�nico. Se encarga de
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
	 *            Pedido de atenci�n a atender
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
	 * Determina si un cierto cami�n puede atender un pedido de atenci�n que
	 * necesite servicios de reparaci�n simple.
	 * 
	 * @return <b>true</b> - El cami�n puede antender este servicio<br>
	 *         <b>false</b> - Caso contrario
	 */
	public boolean puedeAtenderReparacionSimple() {
		return true;
	}

	/**
	 * Determina si un cierto cami�n puede atender un pedido de atenci�n que
	 * necesite servicios de remolque.
	 * 
	 * @return <b>true</b> - El cami�n puede antender este servicio<br>
	 *         <b>false</b> - Caso contrario
	 */
	public abstract boolean puedeAtenderRemolque(Automovil automovil);

	/**
	 * Determina si un cierto cami�n puede atender un pedido de atenci�n que
	 * necesite servicios de reparaci�n compleja.
	 * 
	 * @return <b>true</b> - El cami�n puede antender este servicio<br>
	 *         <b>false</b> - Caso contrario
	 */
	public abstract boolean puedeAtenderReparacionCompleja();

	/**
	 * Nivel de economicidad seg�n el cami�n y sus caracter�sticas. Permite su
	 * ordenamiento seg�n el valor econ�mico del mismo.
	 * 
	 */
	public abstract int getEconomicidad();

	public Collection<Pedido> getPedidosAsignados() {
		return this.pedidosAsignados;
	}

	/**
	 * Realiza todas las acciones necesarias por un cami�n cuando concluye un
	 * pedido asignado.
	 * 
	 * @param pedido
	 *            Pedido finalizado
	 */
	public void finalizoPedido(Pedido pedido) {
		this.pedidosAsignados.remove(pedido);
	}
}
