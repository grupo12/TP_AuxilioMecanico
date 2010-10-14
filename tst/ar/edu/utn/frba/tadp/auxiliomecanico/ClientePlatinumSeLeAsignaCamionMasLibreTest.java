package ar.edu.utn.frba.tadp.auxiliomecanico;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.PedidoBase;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Remolque;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.ReparacionSimple;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.PlatinumPlan;

public class ClientePlatinumSeLeAsignaCamionMasLibreTest extends AuxilioMecanicoTest {
	private static final int PESO_AUTO_LIVIANO = 1;
	private static final int CUOTA_MENSUAL_PLATINUM = 100;

	private Cliente clientePlatinumSinDeuda;
	private Automovil automovilLivianoPlatinum;
	private Pedido pedidoPlatinum;
	
	@Before
	public void setUp(){
		super.setUp();
		this.clientePlatinumSinDeuda = new Cliente(new PlatinumPlan(), CUOTA_MENSUAL_PLATINUM);
		this.automovilLivianoPlatinum = new Automovil(PESO_AUTO_LIVIANO, this.clientePlatinumSinDeuda);
		this.pedidoPlatinum = new Remolque(new ReparacionSimple(new PedidoBase(this.automovilLivianoPlatinum)));
	}
	
	@Test
	public void ClientePlatinumSeLeAsignaCamionMasLibre() {
		this.tallerMecanico.asistir(pedidoPlatinum);
		this.validarAsignacionPedido();
	}
	
	private void validarAsignacionPedido() {
		Pedido pedidoAsignado = this.grangruaConTaller.getPedidosAsignados().iterator().next();
		assertEquals(this.pedidoPlatinum, pedidoAsignado);
	}
}
