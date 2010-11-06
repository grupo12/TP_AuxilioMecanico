package ar.edu.utn.frba.tadp.auxiliomecanico.builders;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

/**
 * BUILDER PATTERN: Crea PedidoBase y lo decora a piacere.
 * La implementa CPedidoBuilder.
 */

public interface IPedidoBuilder {
	
	public abstract CPedidoBuilder armarPedidoBase(Automovil automovil);
	
	public abstract CPedidoBuilder addReparacionSimple();
	
	public abstract CPedidoBuilder addReparacionCompleja();

	public abstract CPedidoBuilder addRemolque();
	
	public abstract Pedido build();

	IPedidoBuilder addIncendio();

	IPedidoBuilder addInundacion();

	IPedidoBuilder addVuelco();

}
