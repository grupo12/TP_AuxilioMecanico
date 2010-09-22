package ar.edu.frba.utn.tadp.auxiliomecanico;

import org.junit.*;
import static org.junit.Assert.*;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.ClassicPlan;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.EconomicPlan;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.PlatiniumPlan;
import ar.edu.frba.utn.tadp.testMockObject.MockModuloPagos;

public class ClienteMorosoPidiendoAuxilioTest {

	private static final double CUOTA_CLIENTE_CLASSIC = 0;
	private static final double CUOTA_CLIENTE_ECONOMIC = 0;
	private static final double CUOTA_CLIENTE_PLATINUM = 100;
	
	// public void setUp(){
	/* Creacion Taller y modulo pagos */
	private MockModuloPagos modulo = new MockModuloPagos(300);
	private TallerMecanico taller = new TallerMecanico();
	/* fin Creacion Taller y modulo pagos */

	/* Creación de clientes con distintos planes */
	private Cliente juanClienteClasico = new Cliente(new ClassicPlan(), CUOTA_CLIENTE_CLASSIC);
	private Cliente serguioClienteEconomic = new Cliente(new EconomicPlan(), CUOTA_CLIENTE_ECONOMIC);
	private Cliente marianoClientePlatinium = new Cliente(new PlatiniumPlan(), CUOTA_CLIENTE_PLATINUM);

	/* finCreación de clientes con distintos planes */

	/* Configuracion taller y modulo de pagos */
	@Before
	public void setUp() {
		this.taller.setModuloPagos(modulo);
		// this.taller.setClientes(juanClienteClasico,serguioClienteEconomic,marianoClientePlatinium);
		// En principio el taller mecánico no necesitaría conocer a los clientes
		// para poder funcionar
	}

	/* fin Configuracion taller y modulo de pagos */

	@Test
	public void clientePremiumPidiendoTest() {
		modulo.setNumeroMagico(10);
		assertTrue(marianoClientePlatinium.isCuotaAlDia(modulo));
	}

	@Test
	public void clientePremiumMorosoPidiendoTest() {
		assertFalse(marianoClientePlatinium.isCuotaAlDia(modulo));
	}

	@Test
	public void clienteEcomonomicMorosoPidiendoTest() {
		assertFalse(serguioClienteEconomic.isCuotaAlDia(modulo));
	}

	@Test
	public void clienteClassicMorosoPidiendoTest() {
		assertFalse(juanClienteClasico.isCuotaAlDia(modulo));
	}
}