package ar.edu.utn.frba.tadp.auxiliomecanico.builders;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

/**
 * BUILDER PATTERN: Crea PedidoBase y lo decora a piacere.
 * La implementa CPedidoBuilder.
 */

public interface IPedidoBuilder {
	
	public abstract CPedidoBuilder pedidoBase(Automovil automovil);
	
	public abstract CPedidoBuilder simple();
	
	public abstract CPedidoBuilder complejidad();

	public abstract CPedidoBuilder remolque();
	
	public abstract Pedido build();

}