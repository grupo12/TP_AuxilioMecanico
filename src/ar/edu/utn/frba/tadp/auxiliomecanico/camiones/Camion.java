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

/**
 * Representa la unidad b�sica de atenci�n de un taller mec�nico. Se encarga de
 * la asistencia de pedidos.
 * 
 */
public abstract class Camion {

	protected List<Pedido> pedidosAsignados;

	protected boolean tieneEquipoPrimerosAuxilios; // cada camion puede tenerlo
													// o no
	protected boolean tieneEquipoEspecial;
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
		pedido.aumentarEconomicidad(this.getEconomicidad());
		this.pedidosAsignados.remove(pedido);
	}

	public boolean podesAtender(EspecialidadPedido ep) {
		if(this.personal == null)
			throw new camionSinPersonalAsignadoException("No puede atenderse un servicio si un cami�n no tiene personal asignado que lo haga.",ep);
		return ep.puedoAtenderte(this);
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

	public boolean tenesEquipoEspecial() {
		return tieneEquipoEspecial;
	}

	public boolean puedeAtenderIncendio() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public boolean puedeAtenderInundacion() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
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

	public boolean hayTecnicoExpertoInundaciones() {
		return this.personal.hayUnTecnicoExpertoInundaciones();
	}
}
