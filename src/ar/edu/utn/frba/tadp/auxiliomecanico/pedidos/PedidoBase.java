package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;

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
}
