package ar.edu.frba.utn.tadp.auxiliomecanico;

import org.junit.Test;

import ar.edu.frba.utn.tadp.auxiliomecanico.Pedido;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.frba.utn.tadp.auxiliomecanico.servicios.RemolqueServicio;
import ar.edu.frba.utn.tadp.auxiliomecanico.servicios.ReparacionServicio;

public class PuedeSolicitarPedidoTest {
	Cliente cliente = new Cliente (new PlanClassic());
	Pedido pedido = new Pedido (new Automovil(peso, cliente), new ReparacionServicio(), new RemolqueServicio());

	@Test 
	public void esMorosoTest(){
	  assertFalse (cliente.podesPedir(pedido));	
	}
}
