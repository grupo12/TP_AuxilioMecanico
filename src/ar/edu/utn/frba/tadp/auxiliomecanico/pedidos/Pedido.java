package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;

/**
 * Representa un pedido dado, realizado por un cliente al sistema de auxilio
 * mec�nico.
 * 
 */
public interface Pedido {

	/**
	 * Determina si el mismo es v�lido para ser atendido a un cliente.
	 * 
	 * @param cliente
	 *            Cliente que solicita el pedido
	 * @return Booleano representativo de la respuesta
	 */
	public boolean esValidoPara(Cliente cliente);

	/**
	 * Determina si el mismo es posible ser atendido por un cami�n dado.
	 * 
	 * @param unCamion
	 *            Cami�n candidato a atender el pedido
	 * @param automovil
	 *            Autom�vil para el cual se solicit� el pedido
	 * @return Puede o no puede
	 */
	public boolean puedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil);

	/**
	 * Responde si el pedido es simple.
	 * 
	 * @return <b>true</b> - Es simple<br>
	 *         <b>false</b> - No es simple
	 */
	public boolean isReparacionSimple();

	/**
	 * Responde si el pedido es de remolque.
	 * 
	 * @return <b>true</b> - Es de remolque<br>
	 *         <b>false</b> - No es de remolque
	 */
	public boolean isRemolque();

	public Cliente getCliente();

	public Automovil getAutomovil();
}
