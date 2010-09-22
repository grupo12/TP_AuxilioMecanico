package ar.edu.frba.utn.tadp.auxiliomecanico.pedido;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;

/**
 * Decorador abstracto de un pedido. Por defecto, delega al sujeto (el pedido
 * real) todas sus responsabilidades.
 * 
 */
public abstract class DecoradorPedido implements Pedido {

	private Pedido sujeto;
	
	public DecoradorPedido(Pedido sujeto) {
		this.sujeto = sujeto;
	}
	
	public boolean isReparacionSimple() {
		// No puede ser reparación simple porque estamos en un decorador (remolque o complejo)
		return false;
	}
	
	public boolean isRemolque() {
		// No lo puedo saber, delego
		return sujeto.isRemolque();
	}

	@Override
	public boolean esValidoPara(Cliente cliente) {
		return this.doEsValidoPara(cliente) && this.sujeto.esValidoPara(cliente);
	}

	@Override
	public boolean puedeSerAtendidoPorCamion(Camion unCamion) {
		return this.doPuedeSerAtendidoPorCamion(unCamion) && this.sujeto.puedeSerAtendidoPorCamion(unCamion);
	}

	/**
	 * Responde únicamente para el decorador dado si puede ser o no atentido por un plan.
	 * @param cliente
	 * @return booleano
	 */
	protected abstract boolean doEsValidoPara(Cliente cliente);

	/**
	 * Responde únicamente para el decorador dado si puede ser o no atentido por un camión.
	 * @param unCamion
	 * @return booleano
	 */
	protected abstract boolean doPuedeSerAtendidoPorCamion(Camion unCamion);
}
