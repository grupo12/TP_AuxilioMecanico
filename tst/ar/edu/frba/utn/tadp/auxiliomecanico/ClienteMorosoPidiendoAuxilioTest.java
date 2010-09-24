package ar.edu.frba.utn.tadp.auxiliomecanico;

import org.junit.*;
import static org.junit.Assert.*;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.*;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.*;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.*;
import ar.edu.frba.utn.tadp.testMockObject.MockModuloPagos;
//import ar.edu.frba.utn.tadp.auxiliomecanico.*;

public class ClienteMorosoPidiendoAuxilioTest {

	private static final double CUOTA_CLIENTE_CLASSIC = 0;
	private static final double CUOTA_CLIENTE_ECONOMIC = 0;
	private static final double CUOTA_CLIENTE_PLATINUM = 100;
	
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
	
	@Test (expected= CuotaDesactualizadaException.class)
	public void clienteEcomonomicMorosoPedidoTest() throws CuotaDesactualizadaException, ServicioInvalidoException, CamionNoDisponibleException {
		Pedido pedido = seteosPreviosDeCliente();
		taller.asistir(pedido);	
	}
	
	private Pedido seteosPreviosDeCliente() {
			Automovil auto = new Automovil(2, marianoClientePlatinium);
			Pedido pedido = new ReparacionSimple(auto);
	return pedido;
	}
}