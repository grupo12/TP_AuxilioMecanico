package ar.edu.utn.frba.tadp.auxiliomecanico;

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.EconomicNoPuedeAtenderRemolqueException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.ReparacionComplejaInvalidaParaEconomicException;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.MockModuloPagos;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.PedidoBase;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Remolque;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.ReparacionCompleja;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.ReparacionSimple;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.EconomicPlan;

public class ClienteEconomicNoPuedeAtenderseRemolque extends AuxilioMecanicoTest {
	private static final int DEUDA_CLIENTE_ECONOMIC = 0;
	private static final int PESO_AUTO_ECONOMIC = 12;
	private static final int CUOTA_CLIENTE_ECONOMIC = 1;

	private Cliente clienteEconomic = new Cliente(new EconomicPlan(), CUOTA_CLIENTE_ECONOMIC);
	private Automovil automovilEconomic = new Automovil(PESO_AUTO_ECONOMIC, this.clienteEconomic);

	private Pedido pedidoComplejoConRemolque = new Remolque(new ReparacionCompleja(new PedidoBase(
			automovilEconomic)));
	private Pedido pedidoComplejoSinRemolque = new ReparacionCompleja(new PedidoBase(automovilEconomic));
	private Pedido pedidoSimpleConRemolque = new Remolque(new ReparacionSimple(new PedidoBase(automovilEconomic)));
	private Pedido pedidoSimpleSinRemolque = new ReparacionSimple(new PedidoBase(automovilEconomic));
	


	@Before
	public void setUp() {
		super.setUp();
		Pedido.setModuloPagos(new MockModuloPagos(DEUDA_CLIENTE_ECONOMIC));
		this.minigrua.atender(new ReparacionSimple(new PedidoBase(automovilEconomic)));
	}

	@Test(expected = EconomicNoPuedeAtenderRemolqueException.class)
	public void clienteEconomicoPuedePedirComplejoConRemolque() {
		this.validarPedidoInvalido(this.pedidoComplejoConRemolque);
	}

	@Test(expected = EconomicNoPuedeAtenderRemolqueException.class)
	public void clienteEconomicoPuedePedirSimpleConRemolque() {
		this.validarPedidoInvalido(this.pedidoSimpleConRemolque);
	}

	@Test(expected = ReparacionComplejaInvalidaParaEconomicException.class)
	public void clienteEconomicoPuedePedirComplejoSinRemolque() throws Exception {
		this.validarPedidoInvalido(this.pedidoComplejoSinRemolque);
	}

	@Test
	public void clienteEconomicoPuedePedirSimpleSinRemolque() {
		this.tallerMecanico.asistir(this.pedidoSimpleSinRemolque);
	}

	private void validarPedidoInvalido(Pedido pedido) {
		this.tallerMecanico.asistir(pedido);
	}
}
