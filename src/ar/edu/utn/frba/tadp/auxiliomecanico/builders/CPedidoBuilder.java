package ar.edu.utn.frba.tadp.auxiliomecanico.builders;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.AsignaPedidoBaseAUnoExistenteException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.NoExistePedidoBaseException;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.complejidades.*;

/**
 * Implementa IPedidoBuilder. Precondición: pedidoBase(Automovil automovil) como
 * primer mensaje. Centraliza validaciones concernientes a un Pedido. Como
 * usarlo: new un builder, y por cada cosa que querramos que tenga un pedido, le
 * enviamos un mensaje al builder, por ej.: addIncencio. No olvidar que al final
 * hay que construir el pedido mensajeandole "build()", lo cual devuelve una
 * instancia de Pedido todo decorado..
 */

public class CPedidoBuilder implements IPedidoBuilder {

	protected Pedido pedido;

	@Override
	public CPedidoBuilder armarPedidoBase(Automovil automovil) {
		if (pedido == null)
			pedido = new PedidoBase(automovil);
		else
			throw new AsignaPedidoBaseAUnoExistenteException(
					"El pedido ya tiene un pedido base.", pedido);

		return this;
	}

	@Override
	public CPedidoBuilder addReparacionSimple() {
		pedidoBaseConstruido();
		pedido = new ReparacionSimple(pedido);
		return this;
	}

	@Override
	public CPedidoBuilder addReparacionCompleja() {
		pedidoBaseConstruido();
		pedido = new ReparacionCompleja(pedido);
		return this;
	}

	@Override
	public CPedidoBuilder addRemolque() {
		pedidoBaseConstruido();
		pedido = new Remolque(pedido);
		return this;
	}


	@Override
	public CPedidoBuilder addVuelco() {
		pedidoBaseConstruido();
		pedido = new VuelcoPedido(pedido);
		return this;
	}

	@Override
	public CPedidoBuilder addInundacion() {
		pedidoBaseConstruido();
		pedido = new InundacionPedido(pedido);
		return this;
	}

	@Override
	public CPedidoBuilder addIncendio() {
		pedidoBaseConstruido();
		IncendioPedido incendio = new IncendioPedido(pedido);
		incendio.setPeligroso(false);
		pedido = incendio;
		return this;
	}
	
	@Override
	public CPedidoBuilder addIncendioPeligroso() {
		pedidoBaseConstruido();
		IncendioPedido incendio = new IncendioPedido(pedido);
		incendio.setPeligroso(true);
		pedido = incendio;
		return this;
	}
	
	@Override
	public CPedidoBuilder addReparacionElectrica() {
		pedidoBaseConstruido();
		pedido = new ProblemaElectrico(pedido);
		return this;
	}
	
	@Override
	public CPedidoBuilder addReparacionMecanica(Complejidad c) {
		pedidoBaseConstruido();
		pedido = new ProblemaMecanico(pedido, c);
		return this;
	}

	@Override
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
			throw new NoExistePedidoBaseException("Precondición: PedidoBase",
					pedido);
	}
}