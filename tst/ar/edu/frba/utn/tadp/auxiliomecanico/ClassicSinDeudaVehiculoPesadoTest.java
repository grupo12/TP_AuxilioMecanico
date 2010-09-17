package ar.edu.frba.utn.tadp.auxiliomecanico;

import org.junit.Before;
import org.junit.Test;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Grangrua;
import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Minigrua;
import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Minitaller;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.IPedido;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.Pedido;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.Remolque;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.ClassicPlan;
import ar.edu.frba.utn.tadp.auxiliomecanico.servicios.RemolqueServicio;

public class ClassicSinDeudaVehiculoPesadoTest {
	
	private Cliente clienteClassicSinDeuda;
	private Automovil automovilPesado;
	private IPedido pedidoRemolque;
	private TallerMecanico tallerMecanico;
	private Camion minitaller;
	private Camion grangrua;
	private Camion minigrua;

	@Before
	public void setUp() throws Exception {
		clienteClassicSinDeuda = new Cliente(new ClassicPlan());
		automovilPesado = new Automovil(5, clienteClassicSinDeuda);
		
		pedidoRemolque = new Remolque(new Pedido(automovilPesado));
		
		minitaller = new Minitaller();
		grangrua = new Grangrua(true);
		minigrua = new Minigrua();
		tallerMecanico = new TallerMecanico(minitaller, minigrua, grangrua);
	}

	@Test
	public void testPedidoRemolqueAsistidoGranGrua() {
		
	}
}
