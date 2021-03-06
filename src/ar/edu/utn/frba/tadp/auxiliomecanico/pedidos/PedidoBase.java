package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.ElPedidoBaseNoPuedeFinalizarseExcepcion;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.PrestadorServicios;

/**
 * Representa un pedido base, sin ning�n tipo de servicio real asociado al
 * mismo.<br>
 * <br>
 * Se podr�a comprender al mismo como un elemento neutro dentro de la jerarqu�a
 * de pedidos, para ser decorado con otros servicios.
 * 
 */
public class PedidoBase extends Pedido {

	private final Automovil automovil;

	public PedidoBase(Automovil automovil) {
		this.automovil = automovil;
	}

	public Cliente getCliente() {
		return this.automovil.getCliente();
	}

	public Automovil getAutomovil() {
		return this.automovil;
	}

	@Override
	public boolean puedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return true;
	}

	@Override
	public boolean isReparacionSimple() {
		return false;
	}

	@Override
	public boolean isRemolque() {
		return false;
	}

	@Override
	protected void validarEspecialidadPara(Cliente cliente) {
		// No necesita validar nada espec�fico ya que en s� el PedidoBase no es
		// un pedido real.
	}

	@Override
	public Tiempo calcularTiempoDeAtencion() {
		throw new ElPedidoBaseNoPuedeFinalizarseExcepcion("No es correcto pedir el tiempo de atencion a un pedido base");
	}

	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		// No se hace nada porque es el final del camino y al pedido base no se
		// le solicita el tiempo.
	}

	@Override
	public boolean puedeSerAtendidoPorCamiones(Collection<Camion> camiones) {
		return true;
	}

	@Override
	public boolean seComplementan(Collection<Camion> camiones, Camion camion) {
		return false;
	}

	@Override
	public boolean algunCamionPuedeResolver(Collection<Camion> camiones) {
		return true;
	}

	@Override
	protected List<List<PrestadorServicios>> prestadoresParaAtenderPorEspecialidad(TallerMecanico tallerMecanico,
			Pedido pedidoOriginal) {
		return new LinkedList<List<PrestadorServicios>>();
	}

	public boolean tieneUrgencias() {
		return false;
	}

	@Override
	public boolean isIncendio() {
		return false;
	}

	@Override
	public boolean isInundacion() {
		return false;
	}
}
