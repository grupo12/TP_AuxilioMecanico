package ar.edu.utn.frba.tadp.auxiliomecanico.estrategias;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.builders.CPedidoBuilder;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Grangrua;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Minigrua;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.NoSePuedeAtenderEspecialidad;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.MockModuloPagos;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.EspecialidadElectricidad;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.EspecialidadMecanica;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.Personal;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.Tecnico;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.ClassicPlan;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.Plan;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.Ambulancia;

public class ArmadoEstrategiasTest {

	protected CPedidoBuilder pedidoBuilder = new CPedidoBuilder();

	private final Plan planClassic = new ClassicPlan();
	private final Cliente cliente = new Cliente(planClassic, 300);
	private final Automovil automovil = new Automovil(3, cliente);


	private Camion minigrua;

	private TallerMecanico tallerMecanico;

	@BeforeClass
	public static void beforeClass() {
		Pedido.setModuloPagos(new MockModuloPagos(0));
	}
	
	@Before
	public void setUp() {
		Tecnico t = new Tecnico(new EspecialidadMecanica());
		t.addEspecialidad(new EspecialidadElectricidad());
		
		Personal personal = new Personal();
		personal.addTecnico(t);

		minigrua = new Minigrua();
		minigrua.asignarPersonal(personal);
		
		tallerMecanico = new TallerMecanico(minigrua);
	}

	@Test
	public void armadoEstrategiasPedidoReparacionMecanicaUnicaSolucion() {
		Pedido pedidoReparacionMecanica = pedidoBuilder.armarPedidoBase(automovil).addReparacionSimple().build();

		assertEquals(1, tallerMecanico.estrategiasPuedenAtender(pedidoReparacionMecanica).size());
	}

	@Test (expected = NoSePuedeAtenderEspecialidad.class)
	public void armadoEstrategiasPedidoIncendioSinSolucion() {
		Pedido pedidoIncendio = pedidoBuilder.armarPedidoBase(automovil).addIncendioPeligroso().build();
		
		tallerMecanico.estrategiasPuedenAtender(pedidoIncendio).size();
	}
	
	@Test
	public void pedidoRemolque() {
		Grangrua grangrua = new Grangrua(true);
		tallerMecanico.agregarCamion(grangrua);
		
		Pedido pedidoRemolque = pedidoBuilder.armarPedidoBase(automovil).addRemolque().build();
		
		assertEquals(2, tallerMecanico.estrategiasPuedenAtender(pedidoRemolque).size());
	}
	
	@Test
	public void pedidoHeridosIncendioRemolque() {
		minigrua.setTieneEquipoEspecialContraIncendio(true);
		minigrua.setTieneEquipoPrimerosAuxilios(true);
		
		Ambulancia ambulancia = new Ambulancia();
		tallerMecanico.agregarAmbulancia(ambulancia);
		
		Pedido pedidoRemolque = pedidoBuilder.armarPedidoBase(automovil).addIncendioPeligroso().addHeridos(false).addRemolque().build();

		assertEquals(2, tallerMecanico.estrategiasPuedenAtender(pedidoRemolque).size());
	}
	
}
