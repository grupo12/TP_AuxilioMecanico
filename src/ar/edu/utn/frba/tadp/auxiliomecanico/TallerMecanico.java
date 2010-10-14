package ar.edu.utn.frba.tadp.auxiliomecanico;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.CamionNoDisponibleException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.CuotaDesactualizadaException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.ModuloPagosFaltanteException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.PedidoInvalidoException;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

/**
 * Representa un taller de reparaci�n y asistencia de autom�viles. Es el
 * responsable de asignar camiones a los distintos pedidos llegados de los
 * clientes del taller.
 * 
 */
public class TallerMecanico {

	private Collection<Camion> camiones;
	private ModuloPagos moduloDePagos;

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
		Cliente cliente = pedido.getCliente();

		if (this.moduloDePagos == null)
			throw new ModuloPagosFaltanteException("No se inicializ� el m�dulo de pagos del taller");
		if (!cliente.isCuotaAlDia(this.moduloDePagos))
			throw new CuotaDesactualizadaException("La cuota est� desactualizada", cliente);
		if (!pedido.esValidoPara(cliente))
			throw new PedidoInvalidoException("El cliente no puede solicitar este servicio", pedido);

		this.asignarCamion(pedido.getAutomovil(), pedido);
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
		if (!this.algunCamionPuedeAtender(pedido, automovil))
			throw new CamionNoDisponibleException("No hay cami�n disponible para atender el pedido", pedido);

		this.camionParaAsignarA(pedido).atender(pedido);
	}

	/**
	 * Determina el cami�n para atender un cierto pedido.
	 * 
	 * @param pedido
	 *            Pedido de atenci�n
	 * @return Cami�n seleccionado para ser asignado
	 */
	protected Camion camionParaAsignarA(Pedido pedido) {
		return pedido.getAutomovil().getCliente()
				.selectCamion(this.camionesPuedenAtender(pedido, pedido.getAutomovil()));
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

	public void setModuloPagos(ModuloPagos moduloDePagos) {
		this.moduloDePagos = moduloDePagos;
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
		pedido.getCliente().finalizoPedido(pedido);
	}
}
