package ar.edu.frba.utn.tadp.auxiliomecanico.pedido;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;

public interface Pedido {

	public boolean esValidoPara(Cliente cliente);

	public boolean puedeSerAtendidoPorCamion(Camion unCamion);

	public boolean isReparacionSimple();

	public boolean isRemolque();
}
