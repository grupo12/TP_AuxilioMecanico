package ar.edu.utn.frba.tadp.auxiliomecanico.clientes;

import java.util.Collection;
import java.util.LinkedList;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.estrategias.Estrategia;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.CuotaDesactualizadaException;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.Plan;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.PrestadorServicios;
import ar.edu.utn.frba.tadp.auxiliomecanico.servicios.NuloServicio;
import ar.edu.utn.frba.tadp.auxiliomecanico.servicios.Servicio;

/**
 * Representa un cliente dado dentro del sistema de Auxilio Mecánico.
 * 
 */
public class Cliente {

	private Plan plan;
	private Collection<Pedido> pedidosRealizados;
	private double cuotaMensual;
	private Servicio servicio;

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
		this.setServicio(NuloServicio.getInstance());
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
			throw new CuotaDesactualizadaException("La cuota está desactualizada", this);
	}

	/**
	 * Consulta si la cuota del cliente está al día
	 * 
	 * @param moduloPagos
	 *            Módulo de pagos del sistema
	 * @return Booleano representativo de esta operación
	 */
	public boolean isCuotaAlDia(ModuloPagos moduloPagos) {
		return moduloPagos.moraDe(this) <= this.plan.maximoMoraPara(this, moduloPagos);
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

	public void validarRemolque() {
		this.plan.validarRemolquePara(this);
	}

	public void validarReparacionSimple() {
		this.plan.validarReparacionSimplePara(this);
	}

	public void validarReparacionCompleja() {
		this.plan.validarReparacionComplejaPara(this);
	}

	public boolean EsRentableElCliente() {
		double gastadoEnCliente = injectInto();
		double cuotaAnual = getCuotaAnual();

		return gastadoEnCliente <= cuotaAnual;
	}

	private double injectInto() {
		double total = 0;
		for (Pedido pedido : this.pedidosRealizados) {
			total += calcularCostoAtencion(pedido);
		}
		return total;
	}

	private double calcularCostoAtencion(Pedido pedido) {
		Tiempo tiempoEmpleadoParaPedido = pedido.calcularTiempoDeAtencion();
		return tiempoEmpleadoParaPedido.costoPara(pedido.getEconomicidad());
	}

	private double getCuotaAnual() {
		return this.getCuotaMensual() * 12;
	}

	public Estrategia selectEstrategia(Collection<Estrategia> estrategias) {
		return this.plan.selectEstrategia(estrategias);
	}

	public PrestadorServicios prestadorParaServicioEnTaller(TallerMecanico tallerMecanico) {
		return this.plan.prestadorParaServicioEnTaller(tallerMecanico, this);
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
}
