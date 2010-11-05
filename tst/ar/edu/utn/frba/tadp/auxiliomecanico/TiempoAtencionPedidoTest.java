package ar.edu.utn.frba.tadp.auxiliomecanico;

import static org.junit.Assert.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.*;
import org.junit.*;

public class TiempoAtencionPedidoTest {
	public Tiempo tiempoPrueba;
	
	@Before
	public void setUp(){
		tiempoPrueba = new Tiempo();
	}
	
	@Test 
	public void tiempoDeAtencionDeUnIncendioInicialmente(){
		IncendioPedido pedidoNuevo = new IncendioPedido();
		
		assertTrue(Tiempo.sonTiemposIguales(pedidoNuevo.calcularTiempoDeAtencion(), tiempoPrueba.nuevoTiempo(0,0)));
	}
	
	@Test 
	public void tiempoDeAtencionDeUnIncendio(){
		IncendioPedido pedidoNuevo = new IncendioPedido();
		
		sumarTiempos(pedidoNuevo);
		
		assertTrue(Tiempo.sonTiemposIguales(pedidoNuevo.calcularTiempoDeAtencion(), tiempoPrueba.nuevoTiempo(34,2)));
	}
	
	@Test 
	public void tiempoDeAtencionDeUnaInundacionInicialmente(){
		InundacionPedido pedidoNuevo = new InundacionPedido();
		assertTrue(Tiempo.sonTiemposIguales(pedidoNuevo.calcularTiempoDeAtencion(), tiempoPrueba.nuevoTiempo(0,0)));
	}
	@Test 
	public void tiempoDeAtencionDeUnaInundacion(){
		InundacionPedido pedidoNuevo = new InundacionPedido();
		
		sumarTiempos(pedidoNuevo);
		
		assertTrue(Tiempo.sonTiemposIguales(pedidoNuevo.calcularTiempoDeAtencion(), tiempoPrueba.nuevoTiempo(34,2)));
	}

	@Test 
	public void tiempoDeAtencionDeUnVuelvoInicialmente(){
		VuelvoPedido pedidoNuevo = new VuelvoPedido();
		
		assertTrue(Tiempo.sonTiemposIguales(pedidoNuevo.calcularTiempoDeAtencion(), tiempoPrueba.nuevoTiempo(0,0)));
	}
	
	@Test 
	public void tiempoDeAtencionDeUnVuelvo(){
		VuelvoPedido pedidoNuevo = new VuelvoPedido();
		
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
