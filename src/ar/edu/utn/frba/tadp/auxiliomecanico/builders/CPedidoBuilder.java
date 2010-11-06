package ar.edu.utn.frba.tadp.auxiliomecanico.builders;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.NoExistePedidoBaseException;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.IncendioPedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.InundacionPedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.PedidoBase;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Remolque;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.ReparacionCompleja;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.ReparacionSimple;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.VuelcoPedido;

/**
 * Implementa IPedidoBuilder.
 * Precondición: pedidoBase(Automovil automovil) como primer mensaje.
 * Centraliza validaciones concernientes a un Pedido.
 */

public class CPedidoBuilder {
	
	protected Pedido pedido;
	
	/**
	 * Bandera para saber si hay PedidoBase y cumple precondición.
	 * @throws AsignaPedidoBaseAUnoExistenteException 
	 */
	
	public CPedidoBuilder armarPedidoBase(Automovil automovil){
		if(pedido == null)
			pedido = new PedidoBase(automovil);
//		else
		//throw new AsignaPedidoBaseAUnoExistenteException("El pedido ya tiene un pedido base.", pedido);
			
		return this;
	}

	public CPedidoBuilder addReparacionSimple() {
		pedidoBaseConstruido();
		pedido = new ReparacionSimple(pedido);
		return this;
	}

	public CPedidoBuilder addReparacionCompleja() {
		pedidoBaseConstruido();
		pedido = new ReparacionCompleja(pedido);
		return this;
	}

	public CPedidoBuilder addRemolque() {
		pedidoBaseConstruido();
		pedido = new Remolque(pedido);
		return this;
	}
	
	public CPedidoBuilder addIncendio(){
		pedidoBaseConstruido();
		pedido = new IncendioPedido(pedido);
		return this;
	}

	public Pedido build() {
		pedidoBaseConstruido();
		pedido.validar();
		return pedido;
	}

	/**
	 * Controla que se cumpla la precondición de esta Clase.
	 */
	
	private void pedidoBaseConstruido() {
		if (pedido == null)
			throw new NoExistePedidoBaseException("Precondición: PedidoBase", pedido);
	}

	public CPedidoBuilder addInundacion() {
		pedidoBaseConstruido();
		pedido = new InundacionPedido(pedido);
		return this;
	}

	public CPedidoBuilder addVuelco() {
		pedidoBaseConstruido();
		pedido = new VuelcoPedido(pedido);
		return this;
	}
}