package ar.edu.frba.utn.tadp.auxiliomecanico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Grangrua;
import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Minigrua;
import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Minitaller;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.Pedido;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.Remolque;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.ReparacionSimple;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.ClassicPlan;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.EconomicPlan;
import ar.edu.frba.utn.tadp.testMockObject.MockModuloPagos;

public class ClienteClassicSinDeudaVehiculoLivianoTest {

	private static final int DEUDA_CLIENTE_CLASSIC = 0;
	private static final int PESO_AUTO = 1;
	private static final int CUOTA_MENSUAL = 70;

	private Cliente clienteClassicSinDeuda;
	private Automovil automovilPesado;
	private Pedido pedidoRemolque;
	private TallerMecanico tallerMecanico;
	private Camion minitaller;
	private Camion grangruaConTaller;
	private Camion minigrua;
	private Automovil automovilOtro;

	@Before
	public void setUp() throws Exception {
		this.clienteClassicSinDeuda = new Cliente(new ClassicPlan(), CUOTA_MENSUAL);
		this.automovilPesado = new Automovil(PESO_AUTO, this.clienteClassicSinDeuda);

		this.pedidoRemolque = new Remolque(new ReparacionSimple(this.automovilPesado));
		
		this.automovilOtro = new Automovil(1, new Cliente(new EconomicPlan(), 5));

		this.minitaller = new Minitaller();
		this.grangruaConTaller = new Grangrua(true);
		this.minigrua = new Minigrua();
		this.minigrua.atender(new ReparacionSimple(automovilOtro));
		this.tallerMecanico = new TallerMecanico(this.minitaller, this.minigrua, this.grangruaConTaller);
		this.tallerMecanico.setModuloPagos(new MockModuloPagos(DEUDA_CLIENTE_CLASSIC));
	}

	@Test
	public void testAsignacionGrangrua() throws CamionNoDisponibleException {
		assertEquals(this.minigrua, this.tallerMecanico.camionParaAsignarA(pedidoRemolque));
	}

	@Test
	public void testPedidoRemolqueAsistidoPorGrangrua() throws Exception {
		this.tallerMecanico.asistir(this.pedidoRemolque);

		this.tallerMecanico.finalizoPedido(this.minigrua, this.pedidoRemolque);
		this.validarFinalizacionPedido();
	}

	private void validarFinalizacionPedido() {
		assertEquals(this.pedidoRemolque, this.clienteClassicSinDeuda.getPedidosRealizados().iterator().next());
	}
}
