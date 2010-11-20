package ar.edu.utn.frba.tadp.auxiliomecanico.testingReparaciones;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frba.tadp.auxiliomecanico.AuxilioMecanicoTest;
import ar.edu.utn.frba.tadp.auxiliomecanico.builders.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.complejidades.AltaComplejidad;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.ClassicPlan;

public class ProblemasElectricosTest extends AuxilioMecanicoTest {

	/**
	 * Un test que hace lo siguiente: Se crea un pedido que incluye un vuelco.
	 * 
	 * 
	 */
	private IPedidoBuilder builder;
	private Personal trioLoco;

	@Before
	public void setUp() {
		builder = new CPedidoBuilder();
		super.setUp();
		trioLoco = new Personal();

		Tecnico srMecanico = new Tecnico(new EspecialidadMecanica());
		Tecnico ingElectrico = new Tecnico(new EspecialidadElectricidad());
		Tecnico mrExperto = new Tecnico(new EspecialidadElectricidad());
		mrExperto.addEspecialidad(new EspecialidadMecanica());

		trioLoco.addTecnico(srMecanico);
		trioLoco.addTecnico(ingElectrico);
		trioLoco.addTecnico(mrExperto);
	}

	@Test
	public void pedidoConVuelcoGruaSoportaPesoTest() {
		EspecialidadPedido p = (EspecialidadPedido) builder
				.armarPedidoBase(automovilOtro).addVuelco().build();
		assertTrue(p.puedeSerAtendidoPorCamion(minigrua, automovilOtro));
	}

	@Test
	public void pedidoMecanicoComplejidadAltaPuedeAtenderseTest() {

		Automovil a = new Automovil(1, new Cliente(new ClassicPlan(), 5));
		Pedido p = builder.armarPedidoBase(a)
				.addReparacionMecanica(new AltaComplejidad()).build();

		this.grangruaConTaller.asignarPersonal(trioLoco);

		assertTrue(this.grangruaConTaller.podesAtender((EspecialidadPedido) p));
	}

}