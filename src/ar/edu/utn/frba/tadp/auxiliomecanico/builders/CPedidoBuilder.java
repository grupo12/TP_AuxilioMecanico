package ar.edu.utn.frba.tadp.auxiliomecanico.builders;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.NoExistePedidoBaseException;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.PedidoBase;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Remolque;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.ReparacionCompleja;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.ReparacionSimple;

/**
 * Implementa IPedidoBuilder.
 * Precondición: pedidoBase(Automovil automovil) como primer mensaje.
 * Centraliza validaciones concernientes a un Pedido.
 */

public class CPedidoBuilder implements IPedidoBuilder{
	
	protected Pedido pedido;
	
	/**
	 * Bandera para saber si hay PedidoBase y cumple precondición.
	 */
	
	private boolean pedidoBaseConstruido;

	@Override
	public CPedidoBuilder pedidoBase(Automovil automovil) {
		pedido = new PedidoBase(automovil);
		pedidoBaseConstruido = true;
		return this;
	}

	@Override
	public CPedidoBuilder simple() {
		pedidoBaseConstruido();
		pedido = new ReparacionSimple(pedido);
		return this;
	}

	@Override
	public CPedidoBuilder complejidad() {
		pedidoBaseConstruido();
		pedido = new ReparacionCompleja(pedido);
		return this;
	}

	@Override
	public CPedidoBuilder remolque() {
		pedidoBaseConstruido();
		pedido = new Remolque(pedido);
		return this;
	}

	@Override
	public Pedido build() {
		pedidoBaseConstruido();
		pedido.validar();
		pedidoBaseConstruido = false;
		return pedido;
	}

	/**
	 * Controla que se cumpla la precondición de esta Clase.
	 */
	
	private void pedidoBaseConstruido() {
		if (!pedidoBaseConstruido)
			throw new NoExistePedidoBaseException("Precondición: PedidoBase", pedido);
	}

}