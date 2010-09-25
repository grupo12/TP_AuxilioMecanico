package ar.edu.frba.utn.tadp.auxiliomecanico;

import static org.junit.Assert.assertEquals;

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
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.PlatinumPlan;
import ar.edu.frba.utn.tadp.testMockObject.MockModuloPagos;

public class ClientePlatinumSeLeAsignaCamionMasLibreTest {

	private static final int DEUDA_CLIENTE = 0;
	private static final int PESO_AUTO_LIVIANO = 1;
	private static final int PESO_AUTO_PESADO = 3;
	private static final int CUOTA_MENSUAL_ECONOMIC = 20;
	private static final int CUOTA_MENSUAL_CLASIC = 50;
	private static final int CUOTA_MENSUAL_PLATINUM = 100;

	private Cliente clientePlatinumSinDeuda;
	private Automovil automovilLivianoPlatinum;
	private Pedido pedidoPlatinum;

	private Cliente clienteEconomic;
	private Automovil automovilLivianoEconomic;
	private Pedido pedidoEconomic;
	
	private Cliente clienteClassic;
	private Automovil automovilPesadoClassic;
	private Pedido pedidoClassic;
	
	private TallerMecanico tallerMecanico;
	private Camion minitaller;
	private Camion grangrua;
	private Camion minigrua;
	
	@Before
	public void setUp(){
		this.clientePlatinumSinDeuda = new Cliente(new PlatinumPlan(), CUOTA_MENSUAL_PLATINUM);
		this.automovilLivianoPlatinum = new Automovil(PESO_AUTO_LIVIANO, this.clientePlatinumSinDeuda);
		this.pedidoPlatinum = new ReparacionSimple(this.automovilLivianoPlatinum);

		this.clienteEconomic = new Cliente(new EconomicPlan(), CUOTA_MENSUAL_ECONOMIC);
		this.automovilLivianoEconomic = new Automovil(PESO_AUTO_LIVIANO, this.clienteEconomic);
		this.pedidoEconomic = new ReparacionSimple(this.automovilLivianoEconomic);
		
		this.clienteClassic = new Cliente(new ClassicPlan(), CUOTA_MENSUAL_CLASIC);
		this.automovilPesadoClassic = new Automovil(PESO_AUTO_PESADO, this.clienteClassic);
		this.pedidoClassic = new Remolque(new ReparacionSimple(this.automovilPesadoClassic));
		
		this.minitaller = new Minitaller();
		this.grangrua = new Grangrua(false);
		this.minigrua = new Minigrua();
		
		this.minitaller.atender(this.pedidoEconomic);
		this.minigrua.atender(this.pedidoClassic);
		
		this.tallerMecanico = new TallerMecanico(this.minitaller, this.minigrua, this.grangrua);
		this.tallerMecanico.setModuloPagos(new MockModuloPagos(DEUDA_CLIENTE));
	}
	
	@Test
	public void ClientePlatinumSeLeAsignaCamionMasLibre() throws CuotaDesactualizadaException, ServicioInvalidoException, CamionNoDisponibleException{
		this.tallerMecanico.asistir(pedidoPlatinum);
		validarAsignacionPedido();
	}
	
	private void validarAsignacionPedido() {
		Pedido pedidoAsignado = this.grangrua.getPedidosAsignados().iterator().next();
		assertEquals(this.pedidoPlatinum, pedidoAsignado);
	}
}
