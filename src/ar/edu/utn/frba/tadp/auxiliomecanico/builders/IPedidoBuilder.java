package ar.edu.utn.frba.tadp.auxiliomecanico.builders;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

/**
 * BUILDER PATTERN: Crea PedidoBase y lo decora a piacere.
 * La implementa CPedidoBuilder.
 */

public interface IPedidoBuilder {
	
	public abstract IPedidoBuilder armarPedidoBase(Automovil automovil);
	
	public abstract IPedidoBuilder addReparacionSimple();
	
	public abstract IPedidoBuilder addReparacionCompleja();

	public abstract IPedidoBuilder addRemolque();
	
	public abstract Pedido build();

}