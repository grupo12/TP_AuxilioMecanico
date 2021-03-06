package ar.edu.utn.frba.tadp.auxiliomecanico.camiones;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.camionSinPersonalAsignadoException;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.EspecialidadPedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.Personal;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.PrestadorServicios;

/**
 * Representa la unidad b�sica de atenci�n de un taller mec�nico. Se encarga de
 * la asistencia de pedidos.
 * 
 */
public abstract class Camion implements PrestadorServicios {

	protected List<Pedido> pedidosAsignados;

	private boolean tieneEquipoPrimerosAuxilios; // cada camion puede tenerlo
													// o no
	private boolean tieneEquipoEspecialContraIncendio;

	protected Personal personal;

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
	 *            Pedido de atenci�n a atender
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
		this.pedidosAsignados.add(0, unPedido);
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
		pedido.aumentarEconomicidad(this.getEconomicidad());
		this.pedidosAsignados.remove(pedido);
	}

	public Tiempo tiempoDePedidosPendientes() {
		Tiempo tiempoEstimado = new Tiempo().nuevoTiempo(0, 0);
		for (Pedido pedido : pedidosAsignados) {
			tiempoEstimado = Tiempo.sumarTiempos(tiempoEstimado,
					pedido.calcularTiempoDeAtencion());
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
					"No puede atenderse un servicio si un cami�n no tiene personal asignado que lo haga.",
					ep);
		return ep.puedeSerAtendidoPorCamion(this, ep.getAutomovil());
	}

	public int cantidadAyudantes() {
		return personal.cantidadAyudantesDisponibles();
	}

	public boolean tenesUnElectricista() {
		return personal.hayUnElectricista();
	}

	public boolean hayUnMecanico() {
		return personal.hayUnMecanico();
	}

	public boolean hayEquipoEspecialContraIncendio() {
		return tieneEquipoEspecialContraIncendio;
	}

	public boolean hayTecnicoExpertoInundaciones() {
		return this.personal.hayUnTecnicoExpertoInundaciones();
	}

	public abstract boolean hayRemolque(Automovil automovil);

	public boolean hayReparacionCompleja() {
		return false;
	}

	public boolean tieneEquipoPrimerosAuxilios() {
		return tieneEquipoPrimerosAuxilios;
	}

	public void setTieneEquipoPrimerosAuxilios(boolean tieneEquipoPrimerosAuxilios) {
		this.tieneEquipoPrimerosAuxilios = tieneEquipoPrimerosAuxilios;
	}

	@Override
	public int getCosto(Tiempo tiempoAtencion) {
		return tiempoAtencion.calcularCosto(costoHora);
	}

	public void setTieneEquipoEspecialContraIncendio(boolean tieneEquipoEspecialContraIncendio) {
		this.tieneEquipoEspecialContraIncendio = tieneEquipoEspecialContraIncendio;
	}
	
}
