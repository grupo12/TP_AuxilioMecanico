package ar.edu.frba.utn.tadp.auxiliomecanico.clientes;

import java.util.Collection;
import java.util.LinkedList;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.Pedido;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.Plan;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public class Cliente {

	private Plan plan;
	private Collection<Pedido> pedidosRealizados;
	private double cuotaMensual;

	public Cliente(Plan plan, double cuotaMensual) {
		this.plan = plan;
		this.cuotaMensual = cuotaMensual;
		this.pedidosRealizados = new LinkedList<Pedido>();
	}

	public double getCuotaMensual() {
		return this.cuotaMensual;
	}

	public void agregarPedido(Pedido pedido) {
		this.pedidosRealizados.add(pedido);
	}

	public boolean isCuotaAlDia(ModuloPagos moduloPagos) {
		return this.plan.isCuotaAlDia(this, moduloPagos);
	}

	public Camion selectCamion(Collection<Camion> camiones) {
		return this.plan.selectCamion(camiones);
	}

	public boolean esValidoRemolque() {
		return this.plan.esValidoRemolquePara(this);
	}

	public boolean esValidoReparacionSimple() {
		return this.plan.esValidoReparacionSimplePara(this);
	}

	public boolean esValidoReparacionCompleja() {
		return this.plan.esValidoReparacionComplejaPara(this);
	}

	public int cantidadReparacionesSimplesRealizadas() {
		int total = 0;

		for (Pedido pedidoRealizado : this.pedidosRealizados)
			if (pedidoRealizado.isReparacionSimple())
				total++;

		return total;
	}

	public int cantidadRemolquesRealizados() {
		int total = 0;

		for (Pedido pedidoRealizado : this.pedidosRealizados)
			if (pedidoRealizado.isRemolque())
				total++;

		return total;
	}

	public Collection<Pedido> getPedidosRealizados() {
		return this.pedidosRealizados;
	}

	public void finalizoPedido(Pedido pedido) {
		this.pedidosRealizados.add(pedido);
	}
}
