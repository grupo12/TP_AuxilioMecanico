package ar.edu.utn.frba.tadp.auxiliomecanico;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.PedidoBase;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.ReparacionSimple;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.EconomicPlan;

public class ClienteEconomicPuedeAtenderReparacionSimpleTest {

	private static final int PESO_AUTO = 1;
	private static final double CUOTA_CLIENTE_ECONOMIC = 25;
	
	private Automovil automovil;
	private Pedido reparacionSimple;
	
	@Before
	public void setUp(){
		this.automovil = new Automovil(PESO_AUTO, new Cliente(new EconomicPlan(), CUOTA_CLIENTE_ECONOMIC));
		this.reparacionSimple = new ReparacionSimple(new PedidoBase(this.automovil));
	}
	
	@Test
	public void ClienteEconomicPuedeAtenderReparacionSimple() {
		assertTrue(this.reparacionSimple.esValidoPara(this.automovil.getCliente()));
	}
}
