package ar.edu.utn.frba.tadp.auxiliomecanico;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.frba.tadp.auxiliomecanico.builders.CPedidoBuilder;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.*;


public class CostoDelClienteACompaniaTest extends AuxilioMecanicoTest {

	/**
	 * En este test es necesario recrear el sistema con un taller, con un módulo de pagos
	 * con varios camiones, varios clientes y pedidos.
	 * Luego se procederá a finalizar pedidos, y buscando en la lista de pedidos finalizados de 
	 * cada camion se procedera a contar el tiempo usado para resolver el pedido y se lo multiplicara
	 * por el monton fijo que tiene ese tipo de camion para saber cuanto le salio el cliente a la
	 * compania
	 */
	private Cliente clienteDeTest;
	
	@Before
	public void setUp(){
		super.setUp();
	}
	
	@Test 
	public void ClienteNoRentableParaCompaníaTest(){
	
		setUpCliente(new  PlatinumPlan(), 0.2);
		
		doClienteRealizarPedidos();
		
		assertFalse(clienteDeTest.esRentableElCliente());
	}
	
	@Test 
	public void clienteRentableParaCompaníaTest(){
		
		setUpCliente(new  PlatinumPlan(), 100);
		
		doClienteRealizarPedidos();
		
		assertTrue(clienteDeTest.esRentableElCliente());
	}

	
	
	/*
	 * Funciones especificas para resolver el test.
	 *  */
	
	private void setUpCliente(Plan planDeCliente,double cuotaDeCliente){
		clienteDeTest= new Cliente(planDeCliente, cuotaDeCliente);
		automovilOtro= new Automovil(1, clienteDeTest);
	}
	
	private void doClienteRealizarPedidos() {
		Pedido pedidoBase;
		pedidoBase = new CPedidoBuilder().armarPedidoBase(super.automovilOtro).addReparacionSimple().build();
		tratarUnPedido(clienteDeTest,pedidoBase);
		
		pedidoBase = new CPedidoBuilder().armarPedidoBase(super.automovilOtro).addReparacionSimple().build(); 
		tratarUnPedido(clienteDeTest,pedidoBase);
		
		pedidoBase = new CPedidoBuilder().armarPedidoBase(super.automovilOtro).addReparacionSimple().build(); 
		tratarUnPedido(clienteDeTest,pedidoBase);
	}
	/*
		La idea es a un cliente asignarle varios pedidos finalizarlos y luego calcular cuanto sale 
		a la compania el cliente en funcion de los pedidos que realizo y lo que paga
	*/
	private void tratarUnPedido(Cliente clienteQuePidio,Pedido pedidoRealizado){
		clienteQuePidio.agregarPedido(pedidoRealizado);
		tallerMecanico.asistir(pedidoRealizado);
		tallerMecanico.finalizoPedido(camionQueRealizo(pedidoRealizado), pedidoRealizado,new Tiempo().nuevoTiempo(0,40));
	}
	
	/*
	 * Esta funcion solo sirve para realizar el test, se dedica a busca un pedido dentro
	 * de los camiones que tiene el taller mecanico y retorna aquel que atendio dicho pedido
	 * de esta forma es mas simple dar con que camion realizo un pedido
	 * */
	private Camion camionQueRealizo(Pedido finalizoPedido){
		Collection<Pedido> pedidosAsignados= null;
		
		pedidosAsignados = super.grangruaConTaller.getPedidosAsignados();
		if(pedidosAsignados.contains(finalizoPedido))
			return grangruaConTaller;
		
		pedidosAsignados = minigrua.getPedidosAsignados();
		if(pedidosAsignados.contains(finalizoPedido))
			return minigrua;
		
		pedidosAsignados= minitaller.getPedidosAsignados();
		if(pedidosAsignados.contains(finalizoPedido))
			return minitaller;
		
		return null;
	}
	
}
