package ar.edu.utn.frba.tadp.auxiliomecanico;

import static org.junit.Assert.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.*;
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
	 * finalizarUnPedidoBaseDeUnClient() consiste en la creacion, asignacion y posterior finalizacion 
	 * de un pedido base y se espera que el mismo tire la excepcion que no puede finalizarse. 
	 * */
	@Test  
	public void finalizarUnPedidoBaseDeUnClient(){
		Tiempo tiempoDeFinalizacion = new Tiempo().nuevoTiempo(10, 15);
		
		Pedido pedidoAgregar = builderPedido.armarPedidoBase(autoDePrueba).addReparacionSimple().build();
		
		pedidoAgregar.finalizar(tiempoDeFinalizacion);
		
		assertTrue(Tiempo.sonTiemposIguales(pedidoAgregar.calcularTiempoDeAtencion(),tiempoDeFinalizacion.nuevoTiempo(10, 15)));
	}
	
	/*
	 * finalizarUnPedidoDeUnClient() consiste en la creacion, asignacion y posterior finalizacion 
	 * de un pedido, dos veces con lo cual se suma 6 veces dos tiempos distintos de finalizacion
	 * por utlimo se calcula el promedio de atencion de Reparacion Simple comprobando que da el resultado
	 * Deseado 
	 * */
	@Test //(expected = UnsupportedOperationException.class )
	public void finalizarUnPedidoDeUnClient(){
		Tiempo tiempoDeFinalizacion = new Tiempo().nuevoTiempo(10, 15);
		
		Pedido pedidoAgregar = builderPedido.armarPedidoBase(autoDePrueba).addReparacionSimple().addReparacionSimple().addReparacionSimple().build();
		
		clienteClassicSinDeuda.agregarPedido(pedidoAgregar);
		
		pedidoAgregar.finalizar(tiempoDeFinalizacion);
		
		tiempoDeFinalizacion = new Tiempo().nuevoTiempo(12, 15);
		
		clienteClassicSinDeuda.agregarPedido(pedidoAgregar);
		
		pedidoAgregar.finalizar(tiempoDeFinalizacion);
		
		assertTrue(Tiempo.sonTiemposIguales(pedidoAgregar.calcularTiempoDeAtencion(),new Tiempo().nuevoTiempo(11, 15)));
	}
	


}
