package ar.edu.utn.frba.tadp.auxiliomecanico;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.ElPedidoBaseNoPuedeFinalizarseExcepcion;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.PedidoFinalizadoCorrectamente;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.PedidoNoFinalizadoCorrectamente;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.builders.*;

import org.junit.*;

public class FinalizarUnPedidoTest extends AuxilioMecanicoTest {
	
	Automovil autoDePrueba;
	CPedidoBuilder builderPedido;

	/*
	 * setUp() inicializa tanto el  auto de pruebas,
	 * como el builder para poder crear pedidos en cada test
	 */
	@Before
	public void setUp(){
		super.setUp();
		autoDePrueba= new Automovil(1, super.clienteClassicSinDeuda);
		builderPedido = new CPedidoBuilder();
	}
	
	/*
	 * finalizarUnPedidoDeUnClient() consiste en la creacion, asignacion y posterior finalizacion 
	 * de un pedido 
	 * */
	@Test (expected = UnsupportedOperationException.class )
	public void finalizarUnPedidoDeUnClient(){
		
		Pedido pedidoAgregar = builderPedido.pedidoBase(autoDePrueba).simple().build(); 
		
		clienteClassicSinDeuda.agregarPedido(pedidoAgregar);
		
		clienteClassicSinDeuda.finalizoPedido(pedidoAgregar);
	}
	
	/*
	 * finalizarUnPedidoDeUnClient() consiste en la creacion y posterior finalizacion 
	 * de un pedido basico 
	 * */
	@Test (expected = ElPedidoBaseNoPuedeFinalizarseExcepcion.class )
	public void finalizarUnPedidoBase(){
		
		Pedido pedidoBase = builderPedido.pedidoBase(autoDePrueba).build(); 
		pedidoBase.terminarServicioDelPedido(null);
	}


}
