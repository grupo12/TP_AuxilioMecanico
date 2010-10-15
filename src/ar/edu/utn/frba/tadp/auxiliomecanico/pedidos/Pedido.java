package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.ModuloPagosFaltanteException;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

/**
 * Representa un pedido dado, realizado por un cliente al sistema de auxilio
 * mec�nico.
 * 
 */
public abstract class Pedido {

	private static ModuloPagos ModuloDePagos;

	/**
	 * Realiza todas las operaciones correspondientes a la validaci�n del mismo
	 * en el sistema.
	 */
	public void validar() {

		this.validarExistenciaModuloPagos();
		this.validarCliente();
	}

	/**
	 * Realiza todas las validaciones del pedido en relaci�n al cliente que lo
	 * solicita.
	 */
	private void validarCliente() {
		Cliente cliente = this.getCliente();
		cliente.validarCuotaAlDia(ModuloDePagos);
		this.validarEspecialidadPara(cliente);
	}
	
	/**
	 * Valida que haya efectivamente un m�dulo de pagos establecido.
	 */
	private void validarExistenciaModuloPagos() {
		if (ModuloDePagos == null)
			throw new ModuloPagosFaltanteException("No se inicializ� el m�dulo de pagos del taller");
	}

	/**
	 * Realiza las validaciones espec�ficas de cada especialidad de pedido sobre
	 * el cliente.
	 * 
	 * @param cliente
	 *            Cliente que solicita el pedido
	 */
	protected abstract void validarEspecialidadPara(Cliente cliente);

	/**
	 * Determina si el mismo es posible ser atendido por un cami�n dado.
	 * 
	 * @param unCamion
	 *            Cami�n candidato a atender el pedido
	 * @param automovil
	 *            Autom�vil para el cual se solicit� el pedido
	 * @return Puede o no puede
	 */
	public abstract boolean puedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil);

	/**
	 * Responde si el pedido es simple.
	 * 
	 * @return <b>true</b> - Es simple<br>
	 *         <b>false</b> - No es simple
	 */
	public abstract boolean isReparacionSimple();

	/**
	 * Responde si el pedido es de remolque.
	 * 
	 * @return <b>true</b> - Es de remolque<br>
	 *         <b>false</b> - No es de remolque
	 */
	public abstract boolean isRemolque();

	public abstract Cliente getCliente();

	public abstract Automovil getAutomovil();

	public static void setModuloPagos(ModuloPagos moduloDePagos) {
		ModuloDePagos = moduloDePagos;
	}
}