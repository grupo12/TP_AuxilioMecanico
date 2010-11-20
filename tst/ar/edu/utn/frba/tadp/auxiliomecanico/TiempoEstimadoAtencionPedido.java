package ar.edu.utn.frba.tadp.auxiliomecanico;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frba.tadp.auxiliomecanico.builders.CPedidoBuilder;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.gps.Lugar;
import ar.edu.utn.frba.tadp.auxiliomecanico.gps.MockGps;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.PlatinumPlan;

public class TiempoEstimadoAtencionPedido extends AuxilioMecanicoTest {
	public MockGps gps;
	public Tiempo tiempoParaProbar;
	Pedido pedido;
	
	@Before
	public void setUp(){
		super.setUp();
		Pedido pedido = new CPedidoBuilder().armarPedidoBase(automovilOtro).addReparacionSimple().build();
		aRodarPedidos(pedido);
		super.minitaller.atender(pedido);
		
		pedido = new CPedidoBuilder().armarPedidoBase(automovilOtro).addReparacionSimple().build();
		aRodarPedidos(pedido);
		super.minitaller.atender(pedido);
		
		pedido = new CPedidoBuilder().armarPedidoBase(automovilOtro).addReparacionSimple().build();
		aRodarPedidos(pedido);
		super.minitaller.atender(pedido);
		
		tiempoParaProbar= new Tiempo().nuevoTiempo(0, 0);
		gps = new MockGps().nuevoGps();
		
		clienteClassicSinDeuda = new Cliente(new PlatinumPlan(), CUOTA_MENSUAL_CLIENTE_CLASSIC);
		this.automovilOtro = new Automovil(1, clienteClassicSinDeuda);
	}
		
	@Test
	public void probarCuantoTardaEnTerminarseElTrabajoEnElLugar(){
		Pedido pedidoNuevo = new CPedidoBuilder().armarPedidoBase(automovilOtro).addReparacionSimple().build();
		assertTrue(Tiempo.sonTiemposIguales(pedidoNuevo.CuantoTardasEnTerminarte(), new Tiempo().nuevoTiempo(0, 0)));
	}
	
	@Test
	public void probarCuantoTardaEnTerminarseElTrabajoQueDigaElGps(){
		Pedido pedidoNuevo = new CPedidoBuilder().armarPedidoBase(automovilOtro).addRemolque().build();
		pedidoNuevo.setCamion(minitaller);
		assertTrue(Tiempo.sonTiemposIguales( gps.paraIrDesdeHasta(Lugar.tigre, Lugar.moreno), pedidoNuevo.CuantoTardasEnTerminarte()));
	}
	
	@Test
	public void cuantoTardaEnFinalizarPendientes(){
		assertEquals(minitaller.cantidadPedidosPendientes(),3);
		assertTrue(Tiempo.sonTiemposIguales(minitaller.cuantoTeFaltaParaFinalizarPendiente(), new Tiempo().nuevoTiempo(34, 0)));	
	}
	
	@Test
	public void ProbarCuantoTardaEnViajarTiempoEstandar (){
		tiempoParaProbar = gps.paraIrDesdeHasta(Lugar.lugano, Lugar.moreno);
		assertEquals(tiempoParaProbar.getMinutos(),30);
		assertEquals(tiempoParaProbar.getHoras(),1);
	}
	@Test
	public void ProbarCuantoTardaEnViajarCambiandoElTiempo (){
		gps.setMinutosPorUnidadKilometros(new Tiempo().nuevoTiempo(0, 10));
		tiempoParaProbar = gps.paraIrDesdeHasta(Lugar.palermo, Lugar.lujan);
		assertEquals(tiempoParaProbar.getMinutos(),0);
		assertEquals(tiempoParaProbar.getHoras(),15);
	}
	
	/*
	 * Funciones especificas para los test
	 * */
	/*
	 * Finaliza 3 veces los servicios de un pedido haciendo posible que la sumatoria de minutos 
	 * tenga un valor distinto al inicial
	 * */
	public void aRodarPedidos(Pedido pedidoNuevo){
		Tiempo tiempo = new Tiempo();
		tiempo = (tiempo.nuevoTiempo(10,25));
		pedidoNuevo.terminarServicioDelPedido(tiempo);
		
		tiempo = (tiempo.nuevoTiempo(12,05));
		pedidoNuevo.terminarServicioDelPedido(tiempo);
		
		tiempo = (tiempo.nuevoTiempo(11,32));
		pedidoNuevo.terminarServicioDelPedido(tiempo);
	
	}
}