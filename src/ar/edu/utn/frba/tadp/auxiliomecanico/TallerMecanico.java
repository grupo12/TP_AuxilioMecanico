package ar.edu.utn.frba.tadp.auxiliomecanico;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.estrategias.Estrategia;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.CamionNoDisponibleException;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

/**
 * Representa un taller de reparaci�n y asistencia de autom�viles. Es el
 * responsable de asignar camiones a los distintos pedidos llegados de los
 * clientes del taller.
 * 
 */
public class TallerMecanico {

	private Collection<Camion> camiones;

	/**
	 * Instancia un nuevo taller con los camiones pasados por par�metro.
	 * 
	 * @param camiones
	 *            Camiones a ser asignados al taller para atender pedidos
	 */
	public TallerMecanico(Camion... camiones) {
		this.camiones = Arrays.asList(camiones);
	}

	/**
	 * Inicia la cadena de validaciones sobre un pedido dado y asigna un el
	 * pedido a un cami�n.
	 * 
	 * @param pedido
	 *            Pedido de atenci�n a un cliente
	 */
	public void asistir(Pedido pedido) {
		pedido.validar();
		this.asignarCamion(pedido.getAutomovil(), pedido);
		this.asignarEstrategia(pedido);
	}

	/**
	 * Determina y asigna un cami�n para un autom�vil con un pedido dado.
	 * 
	 * @param automovil
	 *            Autom�vil a atender
	 * @param pedido
	 *            Pedido de atenci�n
	 */
	private void asignarCamion(Automovil automovil, Pedido pedido) {
		this.validarCamionesParaPedido(automovil, pedido);
		this.camionParaAsignarA(pedido).atender(pedido);
	}

	private void asignarEstrategia(Pedido pedido) {
		this.validarCamionesParaPedido(pedido.getAutomovil(), pedido);
		this.estrategiaParaAsignarA(pedido).atender(pedido);
	}

	/**
	 * Valida que haya alg�n cami�n disponible para atender las exigencias del
	 * pedido entrado al sistema.
	 * 
	 * @param automovil
	 *            Autom�vil sobre el cual se aplica el pedido
	 * @param pedido
	 *            Pedido de atenci�n
	 */
	private void validarCamionesParaPedido(Automovil automovil, Pedido pedido) {
		if (!this.algunCamionPuedeAtender(pedido, automovil))
			throw new CamionNoDisponibleException("No hay cami�n disponible para atender el pedido", pedido);
	}

	/**
	 * Determina el cami�n para atender un cierto pedido.
	 * 
	 * @param pedido
	 *            Pedido de atenci�n
	 * @return Cami�n seleccionado para ser asignado
	 */
	protected Camion camionParaAsignarA(Pedido pedido) {
		return pedido.getCliente().selectCamion(this.camionesPuedenAtender(pedido, pedido.getAutomovil()));
	}

	private Estrategia estrategiaParaAsignarA(Pedido pedido) {
		return pedido.getCliente().selectEstrategia(this.estrategiasPuedenAtender(pedido));
	}

	/**
	 * Determina los camiones candidatos a atender un pedido dado de un
	 * autom�vil.
	 * 
	 * @param pedido
	 *            Pedido de atenci�n
	 * @param automovil
	 *            Autom�vil de un cliente
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

	private Collection<Estrategia> estrategiasPuedenAtender(Pedido pedido) {
		// #select:
		Collection<Estrategia> estrategiasPuedenAtender = new LinkedList<Estrategia>();

		for(Camion camion: camiones){
			for(Estrategia estrategia: estrategiasPuedenAtender){
				estrategia.agregarCamion(camion);
			}
			if(pedido.puedeSerAtendidoPorCamion(camion, pedido.getAutomovil()))
				estrategiasPuedenAtender.add(new Estrategia(pedido, camion));
		}
		// TODO Ac� de alguna forma debo poder armar todas las estrategias
		// posibles en base a mis camiones, para atender al pedidito, lalala.
		//
		// for (Camion camion : camiones)
		// if (pedido.puedeSerAtendidoPorCamion(camion, automovil))
		// camionesPuedenAtender.add(camion);

		return estrategiasPuedenAtender;
	}

	/**
	 * Responde si alg�n cami�n perteneciente al taller podr�a llegar a atender
	 * un pedido.
	 * 
	 * @param pedido
	 *            Pedido de atenci�n
	 * @param automovil
	 *            Autom�vil sobre el que se hace el pedido
	 * @return <b>true</b> - En caso afirmativo<br>
	 *         <b>false</b> - En otro caso
	 */
	private boolean algunCamionPuedeAtender(Pedido pedido, Automovil automovil) {
		return !this.camionesPuedenAtender(pedido, automovil).isEmpty();
	}

	/**
	 * Desencadena las acciones necesarias ante el aviso del fin de atenci�n de
	 * un pedido espec�fico.
	 * 
	 * @param camion
	 *            Camion que concluy� el pedido
	 * @param pedido
	 *            Pedido resuelto
	 */
	public void finalizoPedido(Camion camion, Pedido pedido) {
		camion.finalizoPedido(pedido);
		pedido.finalizar();
	}

	/**
	 * Revisar personal hasta encontrar un experto.
	 * @return
	 */
	public boolean tenesExpertoDisponible() {
		return false;
	}
}
