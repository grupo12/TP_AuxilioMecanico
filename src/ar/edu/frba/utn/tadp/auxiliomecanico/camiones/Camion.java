package ar.edu.frba.utn.tadp.auxiliomecanico.camiones;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.Pedido;

public abstract class Camion {

	protected List<Pedido> pedidosAsignados;

	public Camion() {
		this.pedidosAsignados = new LinkedList<Pedido>();
	}

	public void atender(Pedido unPedido) {
		this.pedidosAsignados.add(unPedido);
	}
	public int cantidadPedidosPendientes() {
		return this.pedidosAsignados.size();
	}

	public boolean puedeAtenderReparacionSimple() {
		return true;
	}
	
	public abstract boolean puedeAtenderRemolque(Automovil automovil);

	public abstract boolean puedeAtenderReparacionCompleja();

	/**
	 * Nivel de economicidad según el camión y sus características. Permite su
	 * ordenamiento según valor.
	 * 
	 */
	public abstract int getEconomicidad();

	public Collection<Pedido> getPedidosAsignados() {
		return this.pedidosAsignados;
	}

	public void finalizoPedido(Pedido pedido) {
		this.pedidosAsignados.remove(pedido);
	}
}
