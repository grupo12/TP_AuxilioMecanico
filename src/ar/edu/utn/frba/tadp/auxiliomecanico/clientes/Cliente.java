package ar.edu.utn.frba.tadp.auxiliomecanico.clientes;

import java.util.Collection;
import java.util.LinkedList;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.Plan;

/**
 * Representa un cliente dado dentro del sistema de Auxilio Mecánico.
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

	/**
	 * Consulta si la cuota del cliente está al día
	 * 
	 * @param moduloPagos
	 *            Módulo de pagos del sistema
	 * @return Booleano representativo de esta operación
	 */
	public boolean isCuotaAlDia(ModuloPagos moduloPagos) {
		return this.plan.isCuotaAlDia(this, moduloPagos);
	}

	/**
	 * Selecciona un camión entre una colección dada para atender un determinado
	 * pedido.
	 * 
	 * @param camiones
	 *            Camiones que pueden atender al cliente
	 * @return Camión escogido según el criterio de selección del cliente
	 */
	public Camion selectCamion(Collection<Camion> camiones) {
		return this.plan.selectCamion(camiones);
	}

	/**
	 * Responde si es válido que el cliente quiera ser atendido con un servicio
	 * de remolque.
	 * 
	 * @return Es válido o no
	 */
	public boolean esValidoRemolque() {
		return this.plan.esValidoRemolquePara(this);
	}

	/**
	 * Responde si es válido que el cliente quiera ser atendido con un servicio
	 * de reparación simple.
	 * 
	 * @return Es válido o no
	 */
	public boolean esValidoReparacionSimple() {
		return this.plan.esValidoReparacionSimplePara(this);
	}

	/**
	 * Responde si es válido que el cliente quiera ser atendido con un servicio
	 * de reparación compleja.
	 * 
	 * @return Es válido o no
	 */
	public boolean esValidoReparacionCompleja() {
		return this.plan.esValidoReparacionComplejaPara(this);
	}

	/**
	 * Devuelve la cantidad de veces que el cliente se atendió con una
	 * reparación simple.
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
	 * Devuelve la cantidad de veces que el cliente se atendió con un remolque.
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
}
