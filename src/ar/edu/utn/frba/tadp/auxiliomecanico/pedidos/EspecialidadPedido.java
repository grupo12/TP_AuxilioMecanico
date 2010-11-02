package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;

/**
 * Decorador abstracto de un pedido. Por defecto, delega al sujeto (el pedido
 * real) todas sus responsabilidades.
 * 
 */
public abstract class EspecialidadPedido extends Pedido {

	private Pedido sujeto;

	public EspecialidadPedido(Pedido sujeto) {
		this.sujeto = sujeto;
	}

	public boolean isReparacionSimple() {
		return false;
	}

	public boolean isRemolque() {
		return sujeto.isRemolque();
	}

	@Override
	protected void validarEspecialidadPara(Cliente cliente) {
		this.doValidarEspecialidadPara(cliente);
		this.sujeto.validarEspecialidadPara(cliente);
	}
	
	protected abstract void doValidarEspecialidadPara(Cliente cliente);

	@Override
	public boolean puedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return this.doPuedeSerAtendidoPorCamion(unCamion, automovil)
				&& this.sujeto.puedeSerAtendidoPorCamion(unCamion, automovil);
	}

	/**
	 * Responde únicamente para el decorador dado si puede ser o no atentido por
	 * un camión.
	 * 
	 * @param unCamion
	 *            Camión candidato a resolver el mismo
	 * @param automovil
	 *            Automóvil a ser atendido
	 * @return Booleano
	 */
	protected abstract boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil);

	public Cliente getCliente() {
		return this.sujeto.getCliente();
	}

	public Automovil getAutomovil() {
		return this.sujeto.getAutomovil();
	}	
}