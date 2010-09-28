package ar.edu.frba.utn.tadp.auxiliomecanico;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.frba.utn.tadp.auxiliomecanico.excepciones.PedidoInvalidoException;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.Remolque;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.ReparacionCompleja;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.ReparacionSimple;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.EconomicPlan;
import ar.edu.frba.utn.tadp.testMockObject.MockModuloPagos;

public class ClienteEconomicNoPuedeAtenderseRemolque extends AuxilioMecanicoTest {
	private static final int DEUDA_CLIENTE_ECONOMIC = 0;
	private static final int PESO_AUTO_ECONOMIC = 12;
	private static final int CUOTA_CLIENTE_ECONOMIC = 1;

	private Cliente clienteEconomic = new Cliente(new EconomicPlan(), CUOTA_CLIENTE_ECONOMIC);
	private Automovil automovilEconomic = new Automovil(PESO_AUTO_ECONOMIC, this.clienteEconomic);

	private Pedido pedidoComplejoConRemolque = new Remolque(new ReparacionCompleja(new ReparacionSimple(
			automovilEconomic)));
	private Pedido pedidoComplejoSinRemolque = new ReparacionCompleja(new ReparacionSimple(automovilEconomic));
	private Pedido pedidoSimpleConRemolque = new Remolque(new ReparacionSimple(automovilEconomic));
	private Pedido pedidoSimpleSinRemolque = new ReparacionSimple(automovilEconomic);

	@Before
	public void setUp() {
		super.setUp();
		this.tallerMecanico.setModuloPagos(new MockModuloPagos(DEUDA_CLIENTE_ECONOMIC));
		this.minigrua.atender(new ReparacionSimple(automovilEconomic));
	}

	@Test(expected = PedidoInvalidoException.class)
	public void clienteEconomicoPuedePedirComplejoConRemolque() {
		this.validarPedidoInvalido(this.pedidoComplejoConRemolque);
	}

	@Test(expected = PedidoInvalidoException.class)
	public void clienteEconomicoPuedePedirSimpleConRemolque() {
		this.validarPedidoInvalido(this.pedidoSimpleConRemolque);
	}

	@Test(expected = PedidoInvalidoException.class)
	public void clienteEconomicoPuedePedirComplejoSinRemolque() throws Exception {
		this.validarPedidoInvalido(this.pedidoComplejoSinRemolque);
	}

	@Test
	public void clienteEconomicoPuedePedirSimpleSinRemolque() {
		this.tallerMecanico.asistir(this.pedidoSimpleSinRemolque);
	}

	private void validarPedidoInvalido(Pedido pedido) {
		assertFalse(pedido.esValidoPara(clienteEconomic));
		this.tallerMecanico.asistir(pedido);
	}
}
