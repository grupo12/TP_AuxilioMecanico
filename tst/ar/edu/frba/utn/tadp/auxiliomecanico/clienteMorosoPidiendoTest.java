package ar.edu.frba.utn.tadp.auxiliomecanico;

import org.junit.Before;
import org.junit.Test;

import ar.edu.frba.utn.tadp.auxiliomecanico.Pedido;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.frba.utn.tadp.auxiliomecanico.servicios.RemolqueServicio;
import ar.edu.frba.utn.tadp.auxiliomecanico.servicios.ReparacionServicio;
import ar.edu.frba.utn.tadp.testMockObject.MockModuloPagos;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.*;



public class clienteMorosoPidiendoTest {
	
	//public void setUp(){ 
		/*Creacion Taller y modulo pagos*/
			private MockModuloPagos modulo = new MockModuloPagos(); 
			private TallerMecanico taller = new TallerMecanico();
		/*fin Creacion Taller y modulo pagos*/
		
		/*Creación de clientes con distintos planes*/
			private Cliente juanClienteClasico = new Cliente(new ClassicPlan());
			private Cliente serguioClienteEconomic = new Cliente(new EconomicPlan());
			private Cliente marianoClientePlatiniumPlan = new Cliente(new PlatiniumPlan(100));
		/*finCreación de clientes con distintos planes*/
		
		/*Configuracion taller y modulo de pagos*/	
			
			this.taller.agregarModuloPagos(modulo);
			this.taller.setClientes(juanClienteClasico,serguioClienteEconomic,marianoClientePlatinium); 
		/* fin Configuracion taller y modulo de pagos*/				
	
}	
}
