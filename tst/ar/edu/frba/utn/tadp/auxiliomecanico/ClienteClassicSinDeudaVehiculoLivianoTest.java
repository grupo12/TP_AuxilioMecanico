package ar.edu.frba.utn.tadp.auxiliomecanico;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.Remolque;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.ReparacionSimple;

public class ClienteClassicSinDeudaVehiculoLivianoTest extends AuxilioMecanicoTest {
	private static final int PESO_AUTO_LIVIANO = 1;

	private Automovil automovilLiviano;
	private Pedido pedidoRemolque;

	@Before
	public void setUp() {
		super.setUp();
		this.automovilLiviano = new Automovil(PESO_AUTO_LIVIANO, this.clienteClassicSinDeuda);
		this.pedidoRemolque = new Remolque(new ReparacionSimple(this.automovilLiviano));
	}

	@Test
	public void testAsignacionGrangrua() {
		assertEquals(this.minigrua, this.tallerMecanico.camionParaAsignarA(pedidoRemolque));
	}

	@Test
	public void testPedidoRemolqueAsistidoPorGrangrua() {
		this.tallerMecanico.asistir(this.pedidoRemolque);

		this.tallerMecanico.finalizoPedido(this.minigrua, this.pedidoRemolque);
		this.validarFinalizacionPedido();
	}

	private void validarFinalizacionPedido() {
		assertEquals(this.pedidoRemolque, this.clienteClassicSinDeuda.getPedidosRealizados().iterator().next());
	}
}
