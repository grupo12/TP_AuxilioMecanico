package ar.edu.utn.frba.tadp.auxiliomecanico;

import static org.junit.Assert.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.builders.CPedidoBuilder;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Excepciones.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.EconomicPlan;

import org.junit.*;

public class TiempoAtencionPedidoTest extends AuxilioMecanicoTest {
	public Tiempo tiempoPrueba;
	public Automovil automovil = new Automovil(1, new Cliente(new EconomicPlan(), 5));
	
	@Before
	public void setUp(){
		super.setUp();
		tiempoPrueba = new Tiempo();
	}
	
	@Test 
	public void tiempoDeAtencionInicialmente(){
		Pedido pedidoNuevo = new CPedidoBuilder().armarPedidoBase(automovil).addReparacionSimple().build();
		
		assertTrue(Tiempo.sonTiemposIguales(pedidoNuevo.calcularTiempoDeAtencion(), tiempoPrueba.nuevoTiempo(0,0)));
	}
	
	@Test 
	public void tiempoDeAtencionDeUnaReparacion(){
		Pedido pedidoNuevo = new CPedidoBuilder().armarPedidoBase(automovil).addReparacionSimple().build();
		
		sumarTiempos(pedidoNuevo);
		
		assertTrue(Tiempo.sonTiemposIguales(pedidoNuevo.calcularTiempoDeAtencion(), tiempoPrueba.nuevoTiempo(11,20)));
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
