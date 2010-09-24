package ar.edu.frba.utn.tadp.auxiliomecanico.pedido;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
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
	public boolean puedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return this.doPuedeSerAtendidoPorCamion(unCamion, automovil) && this.sujeto.puedeSerAtendidoPorCamion(unCamion, automovil);
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
	 * @param automovil
	 * @return booleano
	 */
	protected abstract boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil);
	
	public Cliente getCliente() {
		return this.sujeto.getCliente();
	}

	public Automovil getAutomovil() {
		return this.sujeto.getAutomovil();
	}
}
