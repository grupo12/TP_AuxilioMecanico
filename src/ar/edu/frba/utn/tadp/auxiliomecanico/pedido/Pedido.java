package ar.edu.frba.utn.tadp.auxiliomecanico.pedido;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;

public interface Pedido {

	public boolean esValidoPara(Cliente cliente);

	public boolean puedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil);

	public boolean isReparacionSimple();

	public boolean isRemolque();

	public Cliente getCliente();

	public Automovil getAutomovil();
}
