package ar.edu.frba.utn.tadp.auxiliomecanico;

import org.junit.*;
import static org.junit.Assert.*;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.ClassicPlan;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.EconomicPlan;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.PlatiniumPlan;
import ar.edu.frba.utn.tadp.testMockObject.MockModuloPagos;


public class ClienteMorosoPidiendoAuxilioTest {
	
	//public void setUp(){ 
		/*Creacion Taller y modulo pagos*/
			private MockModuloPagos modulo = new MockModuloPagos(300); 
			private TallerMecanico taller = new TallerMecanico();
		/*fin Creacion Taller y modulo pagos*/
		
		/*Creación de clientes con distintos planes*/
			private Cliente juanClienteClasico = new Cliente(new ClassicPlan());
			private Cliente serguioClienteEconomic = new Cliente(new EconomicPlan());
			private Cliente marianoClientePlatinium = new Cliente(new PlatiniumPlan(100));
		/*finCreación de clientes con distintos planes*/
		
		/*Configuracion taller y modulo de pagos*/	
			@Before
			public void setUp(){
				this.taller.agregarModuloPagos(modulo);
				this.taller.setClientes(juanClienteClasico,serguioClienteEconomic,marianoClientePlatinium);
			}
		/* fin Configuracion taller y modulo de pagos*/		
		
			@Test
			public void clientePremiumPidiendoTest() {
				modulo.setNumeroMagico(10);
				assertTrue(marianoClientePlatinium.isCuotaAlDia(modulo));
			}
			
			@Test
			public void clientePremiumMorosoPidiendoTest() {
				assertFalse(marianoClientePlatinium.isCuotaAlDia(modulo));
			}
			
			@Test
			public void clienteEcomonomicMorosoPidiendoTest() {
				assertFalse(serguioClienteEconomic.isCuotaAlDia(modulo));
			}
			
			@Test
			public void clienteClassicMorosoPidiendoTest() {
				assertFalse(juanClienteClasico.isCuotaAlDia(modulo));
			}		
}