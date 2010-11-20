package ar.edu.utn.frba.tadp.auxiliomecanico;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.estrategias.Estrategia;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.CamionNoDisponibleException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.NoHayAutoReemplazoEnElTallerException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.NoHayEstrategiasPosiblesException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.NoHayRemisEnElTallerException;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.EspecialidadPedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.Ambulancia;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.AutoReemplazo;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.PrestadorServicios;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.Remis;

/**
 * Representa un taller de reparación y asistencia de automóviles. Es el
 * responsable de asignar camiones a los distintos pedidos llegados de los
 * clientes del taller.
 * 
 */
public class TallerMecanico {

	private Collection<Camion> camiones;
	private Collection<Remis> remises;
	private Collection<AutoReemplazo> autosReemplazos;
	private List<PrestadorServicios> ambulancias;

	/**
	 * Instancia un nuevo taller con los camiones pasados por parámetro.
	 * 
	 * @param camiones
	 *            Camiones a ser asignados al taller para atender pedidos
	 */
	public TallerMecanico(Camion... camiones) {
//		this.camiones = Arrays.asList(camiones); // No permite AGREGAR nuevos camiones esta forma
		this.camiones = new LinkedList<Camion>();
		this.remises = new LinkedList<Remis>();
		this.ambulancias = new LinkedList<PrestadorServicios>();
		this.autosReemplazos = new LinkedList<AutoReemplazo>();

		for (Camion camion : camiones)
			this.camiones.add(camion);
	}

	/**
	 * Inicia la cadena de validaciones sobre un pedido dado y asigna un el
	 * pedido a un camión.
	 * 
	 * @param pedido
	 *            Pedido de atención a un cliente
	 */
	public void asistir(Pedido pedido) {
		pedido.validar();
		this.asignarEstrategia(pedido);
	}

	/**
	 * Determina y asigna un camión para un automóvil con un pedido dado.
	 * 
	 * @param automovil
	 *            Automóvil a atender
	 * @param pedido
	 *            Pedido de atención
	 */
	protected void asignarCamion(Automovil automovil, Pedido pedido) {
		this.validarCamionesParaPedido(automovil, pedido);
		this.camionParaAsignarA(pedido).atender(pedido);
		pedido.setCamion(this.camionParaAsignarA(pedido));
	}

	private void asignarEstrategia(Pedido pedido) {
		this.estrategiaParaAsignarA(pedido).atender(pedido);
	}

	/**
	 * Valida que haya algún camión disponible para atender las exigencias del
	 * pedido entrado al sistema.
	 * 
	 * @param automovil
	 *            Automóvil sobre el cual se aplica el pedido
	 * @param pedido
	 *            Pedido de atención
	 */
	private void validarCamionesParaPedido(Automovil automovil, Pedido pedido) {
		if (!this.algunCamionPuedeAtender(pedido, automovil))
			throw new CamionNoDisponibleException("No hay camión disponible para atender el pedido", pedido);
	}

	/**
	 * Determina el camión para atender un cierto pedido.
	 * 
	 * @param pedido
	 *            Pedido de atención
	 * @return Camión seleccionado para ser asignado
	 */
	protected Camion camionParaAsignarA(Pedido pedido) {
		return pedido.getCliente().selectCamion(this.camionesPuedenAtender(pedido, pedido.getAutomovil()));
	}

	/**
	 * Determina la estrategia para atender un cierto pedido.
	 * 
	 * @param pedido
	 *            Pedido de atención
	 * @return estrategia Seleccionada para ser asignada
	 */
	public Estrategia estrategiaParaAsignarA(Pedido pedido) {
		final Collection<Estrategia> estrategiasPosibles = pedido.estrategiasAtencionEn(this);
		
		this.validarEstrategiasPosibles(pedido, estrategiasPosibles);
		
		return pedido.getCliente().selectEstrategia(estrategiasPosibles);
	}

	private void validarEstrategiasPosibles(Pedido pedido, final Collection<Estrategia> estrategiasPosibles)
			throws NoHayEstrategiasPosiblesException {
		if (estrategiasPosibles.isEmpty())
			throw new NoHayEstrategiasPosiblesException(pedido, this);
	}

	/**
	 * Determina los camiones candidatos a atender un pedido dado de un
	 * automóvil.
	 * 
	 * @param pedido
	 *            Pedido de atención
	 * @param automovil
	 *            Automóvil de un cliente
	 * @return Camiones que pueden atender el pedido
	 */
	protected Collection<Camion> camionesPuedenAtender(Pedido pedido, Automovil automovil) {
		// #select:
		Collection<Camion> camionesPuedenAtender = new LinkedList<Camion>();

		for (Camion camion : camiones)
			if (pedido.puedeSerAtendidoPorCamion(camion, automovil))
				camionesPuedenAtender.add(camion);

		return camionesPuedenAtender;
	}

	/**
	 * Arma todas las estrategias que pueden resolver el Pedido
	 * 
	 * @param pedido
	 *            Pedido de atención
	 * @return Estrategias que pueden resolver el pedido
	 * */
	public Collection<Estrategia> estrategiasPuedenAtender(Pedido pedido) {
		return pedido.estrategiasAtencionEn(this);
	}

	/**
	 * Responde si algún camión perteneciente al taller podría llegar a atender
	 * un pedido.
	 * 
	 * @param pedido
	 *            Pedido de atención
	 * @param automovil
	 *            Automóvil sobre el que se hace el pedido
	 * @return <b>true</b> - En caso afirmativo<br>
	 *         <b>false</b> - En otro caso
	 */
	private boolean algunCamionPuedeAtender(Pedido pedido, Automovil automovil) {
		return !this.camionesPuedenAtender(pedido, automovil).isEmpty();
	}

	/**
	 * Desencadena las acciones necesarias ante el aviso del fin de atención de
	 * un pedido específico.
	 * 
	 * @param camion
	 *            Camion que concluyó el pedido
	 * @param pedido
	 *            Pedido resuelto
	 */
	public void finalizoPedido(Camion camion, Pedido pedido, Tiempo tiempo) {
		camion.finalizoPedido(pedido);
		pedido.finalizar(tiempo);
	}

	/**
	 * Revisar personal hasta encontrar un experto.
	 * 
	 * @return
	 */
	public boolean tenesExpertoDisponible() {
		return false;
	}

	public List<PrestadorServicios> camionesParaAtender(EspecialidadPedido especialidadPedido) {
		List<PrestadorServicios> camionesParaEspecialidad = new LinkedList<PrestadorServicios>();

		for (Camion camion : this.camiones)
			if (camion.podesAtender(especialidadPedido))
				camionesParaEspecialidad.add(camion);

		return camionesParaEspecialidad;
	}
	
	public List<PrestadorServicios> camionesParaAtenderEspecialidad(EspecialidadPedido especialidadPedido) {
		List<PrestadorServicios> camionesParaEspecialidad = new LinkedList<PrestadorServicios>();

		for (Camion camion : this.camiones)
			if (especialidadPedido.puedeAtenderte(camion))
				camionesParaEspecialidad.add(camion);

		return camionesParaEspecialidad;
	}

	public PrestadorServicios algunAutoReemplazo() {
		if (this.autosReemplazos.isEmpty())
			throw new NoHayAutoReemplazoEnElTallerException(this);

		return this.autosReemplazos.iterator().next();
	}

	public PrestadorServicios algunRemis() {
		if (this.remises.isEmpty())
			throw new NoHayRemisEnElTallerException(this);

		return this.remises.iterator().next();
	}

	public List<PrestadorServicios> getAmbulancias() {
		return this.ambulancias;
	}
	
	public void agregarAmbulancia(Ambulancia a) {
		this.ambulancias.add(a);
	}
	
	public void agregarRemis(Remis a) {
		this.remises.add(a);
	}
	
	public void agregarAutoReemplazo(AutoReemplazo a) {
		this.autosReemplazos.add(a);
	}

	public void agregarCamion(Camion camion) {
		this.camiones.add(camion);
	}
	
}
