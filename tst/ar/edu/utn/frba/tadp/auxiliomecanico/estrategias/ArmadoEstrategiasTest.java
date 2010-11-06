package ar.edu.utn.frba.tadp.auxiliomecanico.estrategias;

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.builders.CPedidoBuilder;
import ar.edu.utn.frba.tadp.auxiliomecanico.builders.IPedidoBuilder;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Minigrua;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.MockModuloPagos;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.ClassicPlan;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.Plan;

public class ArmadoEstrategiasTest {

	protected IPedidoBuilder pedidoBuilder = new CPedidoBuilder();

	private final Plan planClassic = new ClassicPlan();
	private final Cliente cliente = new Cliente(planClassic, 300);
	private final Automovil automovil = new Automovil(2, cliente);

	private final Minigrua minigrua = new Minigrua();
	
	private Pedido pedidoReparacionMecanica;
	private TallerMecanico tallerMecanico;

	@Before
	public void setUp() throws Exception {
		Pedido.setModuloPagos(new MockModuloPagos(0));
		pedidoReparacionMecanica = pedidoBuilder.pedidoBase(automovil).remolque().build();
		tallerMecanico = new TallerMecanico(minigrua);
		
	}

	@Test
	public void testEstrategiaMinigrua() {
	}
	
}