package ar.edu.utn.frba.tadp.auxiliomecanico.builders;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.complejidades.Complejidad;

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

	public abstract CPedidoBuilder addInundacion();

	public abstract CPedidoBuilder addVuelco();

	public abstract CPedidoBuilder addReparacionElectrica();

	public abstract CPedidoBuilder addReparacionMecanica(Complejidad c);

	public abstract CPedidoBuilder addIncendio(boolean isPeligroso);

}
