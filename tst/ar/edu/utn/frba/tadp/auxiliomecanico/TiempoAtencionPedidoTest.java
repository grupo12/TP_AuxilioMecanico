package ar.edu.utn.frba.tadp.auxiliomecanico;

import static org.junit.Assert.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.builders.CPedidoBuilder;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.EconomicPlan;

import org.junit.*;

public class TiempoAtencionPedidoTest {
	public Tiempo tiempoPrueba;
	public Automovil automovil = new Automovil(1, new Cliente(new EconomicPlan(), 5));
	
	@Before
	public void setUp(){
		tiempoPrueba = new Tiempo();
	}
	
	@Test 
	public void tiempoDeAtencionDeUnIncendioInicialmente(){
		Pedido pedidoNuevo = new CPedidoBuilder().armarPedidoBase(automovil).addIncendio().build();
		
		assertTrue(Tiempo.sonTiemposIguales(pedidoNuevo.calcularTiempoDeAtencion(), tiempoPrueba.nuevoTiempo(0,0)));
	}
	
	@Test 
	public void tiempoDeAtencionDeUnIncendio(){
		Pedido pedidoNuevo = new CPedidoBuilder().armarPedidoBase(automovil).addIncendio().build();
		
		sumarTiempos(pedidoNuevo);
		
		assertTrue(Tiempo.sonTiemposIguales(pedidoNuevo.calcularTiempoDeAtencion(), tiempoPrueba.nuevoTiempo(34,2)));
	}
	
	@Test 
	public void tiempoDeAtencionDeUnaInundacionInicialmente(){
		Pedido pedidoNuevo = new CPedidoBuilder().armarPedidoBase(automovil).addInundacion().build();
		assertTrue(Tiempo.sonTiemposIguales(pedidoNuevo.calcularTiempoDeAtencion(), tiempoPrueba.nuevoTiempo(0,0)));
	}
	@Test 
	public void tiempoDeAtencionDeUnaInundacion(){
		Pedido pedidoNuevo = new CPedidoBuilder().armarPedidoBase(automovil).addInundacion().build();
		
		sumarTiempos(pedidoNuevo);
		
		assertTrue(Tiempo.sonTiemposIguales(pedidoNuevo.calcularTiempoDeAtencion(), tiempoPrueba.nuevoTiempo(34,2)));
	}

	@Test 
	public void tiempoDeAtencionDeUnVuelcoInicialmente(){
		Pedido pedidoNuevo = new CPedidoBuilder().armarPedidoBase(automovil).addVuelco().build();
		
		assertTrue(Tiempo.sonTiemposIguales(pedidoNuevo.calcularTiempoDeAtencion(), tiempoPrueba.nuevoTiempo(0,0)));
	}
	
	@Test 
	public void tiempoDeAtencionDeUnVuelco(){
		Pedido pedidoNuevo = new CPedidoBuilder().armarPedidoBase(automovil).addVuelco().build();
		
		sumarTiempos(pedidoNuevo);
		
		assertTrue(Tiempo.sonTiemposIguales(pedidoNuevo.calcularTiempoDeAtencion(), tiempoPrueba.nuevoTiempo(34,2)));
	}
	
	private void sumarTiempos(Pedido pedidoNuevo) {
		Tiempo tiempo = new Tiempo();
		tiempo = (tiempo.nuevoTiempo(10,25));
		pedidoNuevo.terminarServicioDelPedido(tiempo);
		
		tiempo = (tiempo.nuevoTiempo(12,05));
		pedidoNuevo.terminarServicioDelPedido(tiempo);
		
		tiempo = (tiempo.nuevoTiempo(11,32));
		pedidoNuevo.terminarServicioDelPedido(tiempo);
	}
}
