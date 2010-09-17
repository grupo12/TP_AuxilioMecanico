package ar.edu.frba.utn.tadp.auxiliomecanico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.IPedido;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.Pedido;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.ReparacionSimple;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.EconomicPlan;

public class ClienteEconomicPuedeAtenderReparacionSimpleTest {

	private Automovil automovil;
	private IPedido reparacionSimple;
	
	@Before
	public void setUp(){
		this.automovil = new Automovil(1, new Cliente(new EconomicPlan()));
		this.reparacionSimple = new ReparacionSimple(new Pedido(this.automovil));
	}
	
	@Test
	public void ClienteEconomicPuedeAtenderReparacionSimple(){
		assertTrue(this.reparacionSimple.puedeSerAtendidoPorPlan());
	}
}
