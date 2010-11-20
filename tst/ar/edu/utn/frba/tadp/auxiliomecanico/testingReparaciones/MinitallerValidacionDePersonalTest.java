	package ar.edu.utn.frba.tadp.auxiliomecanico.testingReparaciones;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frba.tadp.auxiliomecanico.AuxilioMecanicoTest;
import ar.edu.utn.frba.tadp.auxiliomecanico.builders.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.MinitallerNoVerificaPersonalException;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.complejidades.AltaComplejidad;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.ClassicPlan;

public class MinitallerValidacionDePersonalTest extends AuxilioMecanicoTest {

	private Personal personalMinitallerSinExperto;
	private Personal personalMinitallerConVariasPersonas;
	private Personal personalMinitallerValido;
	
	@Before
	public void setUp() {
		super.setUp();
		personalMinitallerSinExperto = new Personal();
		personalMinitallerConVariasPersonas = new Personal();
		personalMinitallerValido = new Personal();

		Tecnico srMecanico = new Tecnico(new NivelPrincipiante(new ProblemaMecanico()));
		personalMinitallerSinExperto.addTecnico(srMecanico);

		personalMinitallerConVariasPersonas.addTecnico(srMecanico);
		personalMinitallerConVariasPersonas.addTecnico(new Tecnico(new NivelExperto()));
		
		personalMinitallerValido.addTecnico(new Tecnico(new NivelExperto()));
	}

	@Test (expected = MinitallerNoVerificaPersonalException.class)
	public void minitallerUnicaPersonaNoEsExpertoTest() {
		CamionBuilder cb = new CamionBuilder();
		cb.quieroMiniTaller(personalMinitallerSinExperto);
	}


	@Test (expected = MinitallerNoVerificaPersonalException.class)
	public void minitallerConMasDeUnaPersonaTest() {
		CamionBuilder cb = new CamionBuilder();
		cb.quieroMiniTaller(personalMinitallerConVariasPersonas);
	}
	
	@Test
	public void minitallerVerificaPersonalExitosamenteTest() {
		CamionBuilder cb = new CamionBuilder();
		assertTrue(cb.quieroMiniTaller(personalMinitallerValido).buildCamion().getPersonal().cantPersonas() == 1);
		
	}
	
}