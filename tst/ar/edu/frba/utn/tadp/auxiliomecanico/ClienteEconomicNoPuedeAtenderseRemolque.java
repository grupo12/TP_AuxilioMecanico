package ar.edu.frba.utn.tadp.auxiliomecanico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Minitaller;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.Pedido;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.Remolque;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.ReparacionCompleja;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.ReparacionSimple;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.EconomicPlan;
import ar.edu.frba.utn.tadp.testMockObject.MockModuloPagos;

public class ClienteEconomicNoPuedeAtenderseRemolque {
	private static final int DEUDA_CLIENTE_ECONOMIC = 0;
	private static final int PESO_AUTO_ECONOMIC = 12;
	private static final int CUOTA_CLIENTE_ECONOMIC = 1;

	private Cliente clienteEconomic = new Cliente(new EconomicPlan(),
			CUOTA_CLIENTE_ECONOMIC);
	private Automovil automovilEconomic = new Automovil(PESO_AUTO_ECONOMIC,
			this.clienteEconomic);

	private Pedido pedidoComplejoConRemolque = new Remolque(
			new ReparacionCompleja(new ReparacionSimple(automovilEconomic)));
	private Pedido pedidoComplejoSinRemolque = new ReparacionCompleja(
			new ReparacionSimple(automovilEconomic));
	private Pedido pedidoSimpleConRemolque = new Remolque(new ReparacionSimple(
			automovilEconomic));
	private Pedido pedidoSimpleSinRemolque = new ReparacionSimple(
			automovilEconomic);

	private final Minitaller minitaller = new Minitaller();
	private final TallerMecanico tallerMecanico = new TallerMecanico(
			this.minitaller);

	@Before
	public void setUp() throws Exception {
		this.tallerMecanico.setModuloPagos(new MockModuloPagos(
				DEUDA_CLIENTE_ECONOMIC));
	}

	@Test(expected = ServicioInvalidoException.class)
	public void clienteEconomicoPuedePedirComplejoConRemolque()
			throws Exception {
		this.validarPedidoInvalido(this.pedidoComplejoConRemolque);
	}

	@Test(expected = ServicioInvalidoException.class)
	public void clienteEconomicoPuedePedirSimpleConRemolque() throws Exception {
		this.validarPedidoInvalido(this.pedidoSimpleConRemolque);
	}

	@Test(expected = ServicioInvalidoException.class)
	public void clienteEconomicoPuedePedirComplejoSinRemolque() throws Exception {
		this.validarPedidoInvalido(this.pedidoComplejoSinRemolque);
	}

	@Test
	public void clienteEconomicoPuedePedirSimpleSinRemolque() throws Exception {
		this.tallerMecanico.asistir(this.pedidoSimpleSinRemolque);
	}

	private void validarPedidoInvalido(Pedido pedido) throws Exception {
		assertFalse(pedido.esValidoPara(clienteEconomic));
		this.tallerMecanico.asistir(pedido);
	}
}
