package ar.edu.utn.frba.tadp.auxiliomecanico.estrategias;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.builders.CPedidoBuilder;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Minigrua;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.MockModuloPagos;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.EspecialidadElectricidad;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.EspecialidadMecanica;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.Personal;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.Tecnico;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.ClassicPlan;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.Plan;

public class ArmadoEstrategiasTest {

	protected CPedidoBuilder pedidoBuilder = new CPedidoBuilder();

	private final Plan planClassic = new ClassicPlan();
	private final Cliente cliente = new Cliente(planClassic, 300);
	private final Automovil automovil = new Automovil(3, cliente);

	private Pedido pedidoReparacionMecanica;

	private Camion minigrua;

	private TallerMecanico tallerMecanico;

	@Before
	public void setUp() throws Exception {
		Pedido.setModuloPagos(new MockModuloPagos(0));
		pedidoReparacionMecanica = pedidoBuilder.armarPedidoBase(automovil).addReparacionSimple().build();
		minigrua = new Minigrua();
		Personal personal = new Personal();
		Tecnico t = new Tecnico(new EspecialidadElectricidad());
		t.addEspecialidad(new EspecialidadMecanica());
		personal.addTecnico(t);
		minigrua.asignarPersonal(personal);
		tallerMecanico = new TallerMecanico(minigrua);
	}

	@Test
	public void armadoEstrategiasPedidoReparacionMecanica() {
		assertEquals(1, tallerMecanico.estrategiasPuedenAtender(pedidoReparacionMecanica).size());
	}

}
