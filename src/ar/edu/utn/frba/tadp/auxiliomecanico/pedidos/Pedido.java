package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.CuotaDesactualizadaException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.ModuloPagosFaltanteException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.PedidoInvalidoException;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

/**
 * Representa un pedido dado, realizado por un cliente al sistema de auxilio
 * mec�nico.
 * 
 */
public abstract class Pedido {
	
	private static ModuloPagos ModuloDePagos;

	public void validar() {
		Cliente cliente = this.getCliente();

		if (ModuloDePagos == null)
			throw new ModuloPagosFaltanteException("No se inicializ� el m�dulo de pagos del taller");
		
		if (!cliente.isCuotaAlDia(ModuloDePagos))
			throw new CuotaDesactualizadaException("La cuota est� desactualizada", cliente);
		
		if (!this.esValidoPara(cliente))
			throw new PedidoInvalidoException("El cliente no puede solicitar este servicio", this);
	}

	/**
	 * Determina si el mismo es v�lido para ser atendido a un cliente.
	 * 
	 * @param cliente
	 *            Cliente que solicita el pedido
	 * @return Booleano representativo de la respuesta
	 */
	public abstract boolean esValidoPara(Cliente cliente);

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
