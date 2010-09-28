package ar.edu.frba.utn.tadp.auxiliomecanico;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.frba.utn.tadp.auxiliomecanico.excepciones.CuotaDesactualizadaException;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.ReparacionSimple;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.ClassicPlan;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.EconomicPlan;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.PlatinumPlan;
import ar.edu.frba.utn.tadp.testMockObject.MockModuloPagos;

//import ar.edu.frba.utn.tadp.auxiliomecanico.*;

public class ClienteMorosoPidiendoAuxilioTest extends AuxilioMecanicoTest {

	private static final double CUOTA_CLIENTE_CLASSIC = 0;
	private static final double CUOTA_CLIENTE_ECONOMIC = 0;
	private static final double CUOTA_CLIENTE_PLATINUM = 100;

	/* Creacion Taller y modulo pagos */
	private MockModuloPagos modulo = new MockModuloPagos(300);
	/* fin Creacion Taller y modulo pagos */

	/* Creación de clientes con distintos planes */
	private Cliente juanClienteClasico = new Cliente(new ClassicPlan(), CUOTA_CLIENTE_CLASSIC);
	private Cliente serguioClienteEconomic = new Cliente(new EconomicPlan(), CUOTA_CLIENTE_ECONOMIC);
	private Cliente marianoClientePlatinium = new Cliente(new PlatinumPlan(), CUOTA_CLIENTE_PLATINUM);

	/* finCreación de clientes con distintos planes */

	/* Configuracion taller y modulo de pagos */
	@Before
	public void setUp() {
		super.setUp();
		this.tallerMecanico.setModuloPagos(this.modulo);
	}

	/* fin Configuracion taller y modulo de pagos */

	@Test
	public void clientePremiumPidiendoTest() {
		this.modulo.setDeuda(10);
		assertTrue(this.marianoClientePlatinium.isCuotaAlDia(this.modulo));
	}

	@Test
	public void clientePremiumMorosoPidiendoTest() {
		assertFalse(this.marianoClientePlatinium.isCuotaAlDia(this.modulo));
	}

	@Test
	public void clienteEcomonomicMorosoPidiendoTest() {
		assertFalse(this.serguioClienteEconomic.isCuotaAlDia(this.modulo));
	}

	@Test
	public void clienteClassicMorosoPidiendoTest() {
		assertFalse(juanClienteClasico.isCuotaAlDia(modulo));
	}

	@Test(expected = CuotaDesactualizadaException.class)
	public void clienteEcomonomicMorosoPedidoTest() {
		Pedido pedido = seteosPreviosDeCliente();
		this.tallerMecanico.asistir(pedido);
	}

	private Pedido seteosPreviosDeCliente() {
		Automovil auto = new Automovil(2, this.marianoClientePlatinium);
		Pedido pedido = new ReparacionSimple(auto);
		return pedido;
	}
}