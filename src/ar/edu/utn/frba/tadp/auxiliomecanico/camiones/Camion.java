package ar.edu.utn.frba.tadp.auxiliomecanico.camiones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.camionSinPersonalAsignadoException;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.Personal;

/**
 * Representa la unidad básica de atención de un taller mecánico. Se encarga de
 * la asistencia de pedidos.
 * 
 */
public abstract class Camion {

	protected List<Pedido> pedidosAsignados;

	protected boolean tieneEquipoPrimerosAuxilios; // cada camion puede tenerlo
													// o no
	protected boolean tieneEquipoEspecialContraIncendio;

	protected Personal personal;

	private Collection <EspecialidadPedido> serviciosQuePresta = new ArrayList <EspecialidadPedido>();

	public Personal getPersonal() {
		return personal;
	}

	public void asignarPersonal(Personal personal) {
		/**
		 * En un minitaller hay una unica persona, que siempre es un experto. En
		 * las gruas puede haber hasta 3 personas, de las cuales una debe ser un
		 * experto.
		 */
		this.validarPesonal(personal);
		this.personal = personal;
		this.getClass();
	}

	public abstract void validarPesonal(Personal personal2);

	public Camion() {
		this.pedidosAsignados = new LinkedList<Pedido>();
	}

	private static int costoHora;

	public static void setCostoHora(int unValor) {
		costoHora = unValor;
	}

	public int getCostoHora() {
		return costoHora;
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
	 * Realiza las acciones necesarias a la hora de atender un pedido que es una
	 * urgencia.
	 * 
	 * @param unPedido
	 *            Pedido que tiene la condicion de urgente
	 */
	public void atenderUrgencia(Pedido unPedido) {
		this.pedidosAsignados.add(1, unPedido);
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
		pedido.aumentarEconomicidad(this.getEconomicidad());
		this.pedidosAsignados.remove(pedido);
	}

	public Tiempo tiempoDePedidosPendientes() {
		Tiempo tiempoEstimado = new Tiempo().nuevoTiempo(0, 0);
		for (Pedido pedido : pedidosAsignados) {
			tiempoEstimado = Tiempo.sumarTiempos(tiempoEstimado,
					pedido.calcularTiempoEstimado());
		}
		return tiempoEstimado;
	}

	public Tiempo cuantoTeFaltaParaFinalizarPendiente() {
		Collection<Pedido> pedidoAsignados = getPedidosAsignados();
		Tiempo total = new Tiempo().nuevoTiempo(0, 0);

		for (Pedido pedido : pedidoAsignados)
			total = Tiempo.sumarTiempos(total,
					pedido.calcularTiempoDeAtencion());

		return total;
	}

	public boolean podesAtender(EspecialidadPedido ep) {
		if (this.personal == null)
			throw new camionSinPersonalAsignadoException(
					"No puede atenderse un servicio si un camión no tiene personal asignado que lo haga.",
					ep);
		return ep.puedeSerAtendidoPorCamion(this, ep.getAutomovil());
	}

	/**
	 * Requerimientos personal
	 */


	public boolean hayAlgunTecnicoEspecialistaEn(EspecialidadPedido ep) {
		return personal.hayAlgunaTecnicoEspecialistaEn(ep);
	}

	
	/**
	 * Requerimientos camion
	 */

	public boolean hayEspecialidadParaAuto(EspecialidadPedido ep){
		for(EspecialidadPedido unaEp : this.serviciosQuePresta)
			if(unaEp.getClass() == ep.getClass())
				return true;
		return false;
	}
	
	/**
	 * Otros requerimientos
	 */
	
	public int cantidadAyudantes() {
		return personal.cantidadAyudantesDisponibles();
	}
	public abstract boolean podesRemolcar(Automovil automovil);

	public void addEspecialidad(EspecialidadPedido ep) {
		this.serviciosQuePresta .add(ep);
	}

}
