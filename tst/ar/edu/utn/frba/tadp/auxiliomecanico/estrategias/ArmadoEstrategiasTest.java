package ar.edu.utn.frba.tadp.aux

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frba.tadp.auxiliomecanico.builders.CPedidoBuilder;
import ar.edu.utn.frba.tadp.auxiliomecanico.builders.IPedidoBuilder;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.ClassicPlan;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.Plan;

public class SeleccionEstrategiaReparacionTest {

	protected IPedidoBuilder pedidoBuilder = new CPedidoBuilder();
	protected CPedidoBuilder pedidoBuilder = new CPedidoBuilder();

	private final Plan planClassic = new ClassicPlan();
	private final Cliente cliente = new Cliente(planClassic, 300);
	private final Automovil automovil = new Automovil(3, cliente);
	
	private Pedido pedidoReparacionMecanica;

	@Before
	public void setUp() throws Exception {
		pedidoReparacionMecanica = pedidoBuilder.pedidoBase(automovil).build();
		pedidoReparacionMecanica = pedidoBuilder.armarPedidoBase(automovil).build();



	}

	@Test
	public void sarasa() {
		
	}
	
}
