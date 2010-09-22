package ar.edu.frba.utn.tadp.auxiliomecanico.camiones;

import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.Pedido;

public interface Camion {

	public void atender(Pedido unPedido);

	public boolean puedeAtenderReparacionSimple();

	public boolean puedeAtenderRemolque();

	public boolean puedeAtenderReparacionCompleja();
}
