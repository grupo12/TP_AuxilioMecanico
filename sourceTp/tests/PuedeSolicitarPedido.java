package tests;

public class PuedeSolicitarPedido {
	Cliente cliente = new Cliente (new PlanClasic());
	Pedido pedido = new Pedido (new Automovil(peso), new ReparacionServicio(), new RemolqueServicio());

	@Test 
	public void esMorosoTest(){
	  asserFalse (cliente.podesPedir(pedido));	
	}
}
