package ar.edu.frba.utn.tadp.auxiliomecanico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.PedidoBase;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.Remolque;

public class ClienteClassicSinDeudaVehiculoPesadoTest extends AuxilioMecanicoTest {
	private static final int PESO_AUTO_PESADO = 5;

	private Automovil automovilPesado;
	private Pedido pedidoRemolque;

	@Before
	public void setUp() {
		super.setUp();
		this.automovilPesado = new Automovil(PESO_AUTO_PESADO, this.clienteClassicSinDeuda);
		this.pedidoRemolque = new Remolque(new PedidoBase(this.automovilPesado));
	}

	@Test
	public void testAsignacionGrangrua() {
		assertEquals(this.grangruaConTaller, this.tallerMecanico.camionParaAsignarA(pedidoRemolque));
	}

	@Test
	public void testPedidoRemolqueAsistidoPorGrangrua() throws Exception {
		this.tallerMecanico.asistir(this.pedidoRemolque);
		this.validarAsignacionPedido();

		this.tallerMecanico.finalizoPedido(this.grangruaConTaller, this.pedidoRemolque);
		this.validarFinalizacionPedido();
	}

	private void validarAsignacionPedido() {
		Pedido pedidoAsignado = this.grangruaConTaller.getPedidosAsignados().iterator().next();
		assertEquals(this.pedidoRemolque, pedidoAsignado);
	}

	private void validarFinalizacionPedido() {
		assertTrue(this.grangruaConTaller.getPedidosAsignados().isEmpty());
		assertEquals(this.pedidoRemolque, this.clienteClassicSinDeuda.getPedidosRealizados().iterator().next());
	}
}
