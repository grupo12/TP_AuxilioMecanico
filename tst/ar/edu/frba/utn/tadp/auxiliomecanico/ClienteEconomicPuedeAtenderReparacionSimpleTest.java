package ar.edu.frba.utn.tadp.auxiliomecanico;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.Pedido;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.ReparacionSimple;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.EconomicPlan;

public class ClienteEconomicPuedeAtenderReparacionSimpleTest {

	private static final double CUOTA_CLIENTE_ECONOMIC = 25;
	
	private Automovil automovil;
	private Pedido reparacionSimple;
	
	@Before
	public void setUp(){
		this.automovil = new Automovil(1, new Cliente(new EconomicPlan(), CUOTA_CLIENTE_ECONOMIC));
		this.reparacionSimple = new ReparacionSimple();
	}
	
	@Test
	public void ClienteEconomicPuedeAtenderReparacionSimple(){
		assertTrue(this.reparacionSimple.esValidoPara(automovil.getCliente()));
	}
}
