package ar.edu.utn.frba.tadp.auxiliomecanico.clientes;

import java.util.Collection;
import java.util.LinkedList;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.CuotaDesactualizadaException;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.Plan;

/**
 * Representa un cliente dado dentro del sistema de Auxilio Mec�nico.
 * 
 */
public class Cliente {

	private Plan plan;
	private Collection<Pedido> pedidosRealizados;
	private double cuotaMensual;

	/**
	 * Crea un cliente con un plan de servicios dado y la cuota mensual del
	 * mismo.
	 * 
	 * @param plan
	 *            Plan del cliente
	 * @param cuotaMensual
	 *            Cuota mensual en pesos
	 */
	public Cliente(Plan plan, double cuotaMensual) {
		this.plan = plan;
		this.cuotaMensual = cuotaMensual;
		this.pedidosRealizados = new LinkedList<Pedido>();
	}

	public double getCuotaMensual() {
		return this.cuotaMensual;
	}

	/**
	 * Agrega un pedido a la lista de pedidos realizados del cliente.
	 * 
	 * @param pedido
	 *            Pedido finalizado del cliente
	 */
	public void agregarPedido(Pedido pedido) {
		this.pedidosRealizados.add(pedido);
	}
	
	public void validarCuotaAlDia(ModuloPagos moduloPagos) {
		if (!this.isCuotaAlDia(moduloPagos))
			throw new CuotaDesactualizadaException("La cuota est� desactualizada", this); 
	}

	/**
	 * Consulta si la cuota del cliente est� al d�a
	 * 
	 * @param moduloPagos
	 *            M�dulo de pagos del sistema
	 * @return Booleano representativo de esta operaci�n
	 */
	public boolean isCuotaAlDia(ModuloPagos moduloPagos) {
		return moduloPagos.moraDe(this) <= this.plan.maximoMoraPara(this, moduloPagos);
	}

	/**
	 * Selecciona un cami�n entre una colecci�n dada para atender un determinado
	 * pedido.
	 * 
	 * @param camiones
	 *            Camiones que pueden atender al cliente
	 * @return Cami�n escogido seg�n el criterio de selecci�n del cliente
	 */
	public Camion selectCamion(Collection<Camion> camiones) {
		return this.plan.selectCamion(camiones);
	}

	/**
	 * Devuelve la cantidad de veces que el cliente se atendi� con una
	 * reparaci�n simple.
	 * 
	 * @return Cantidad de veces
	 */
	public int cantidadReparacionesSimplesRealizadas() {
		// inject:into:
		int total = 0;

		for (Pedido pedidoRealizado : this.pedidosRealizados)
			if (pedidoRealizado.isReparacionSimple())
				total++;

		return total;
	}

	/**
	 * Devuelve la cantidad de veces que el cliente se atendi� con un remolque.
	 * 
	 * @return Cantidad de veces
	 */
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

	/**
	 * Realiza las acciones correspondientes al finalizar un pedido que el
	 * cliente haya solicitado.
	 * 
	 * @param pedido
	 *            Pedido finalizado
	 */
	public void finalizoPedido(Pedido pedido) {
		this.pedidosRealizados.add(pedido);
	}

	public void validarRemolque() {
		this.plan.validarRemolquePara(this);
	}

	public void validarReparacionSimple() {
		this.plan.validarReparacionSimplePara(this);
	}

	public void validarReparacionCompleja() {
		this.plan.validarReparacionComplejaPara(this);
	}
}
