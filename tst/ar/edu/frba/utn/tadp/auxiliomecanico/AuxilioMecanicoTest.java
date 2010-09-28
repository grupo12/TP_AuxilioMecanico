package ar.edu.frba.utn.tadp.auxiliomecanico;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Grangrua;
import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Minigrua;
import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Minitaller;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedidos.ReparacionSimple;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.ClassicPlan;
import ar.edu.frba.utn.tadp.auxiliomecanico.planes.EconomicPlan;
import ar.edu.frba.utn.tadp.testMockObject.MockModuloPagos;

public abstract class AuxilioMecanicoTest {

	protected static final int DEUDA_CLIENTE_CLASSIC = 0;
	protected static final int PESO_AUTO_LIVIANO = 1;
	protected static final int CUOTA_MENSUAL_CLIENTE_CLASSIC = 70;
	protected static final int PESO_AUTO_PESADO = 5;

	protected Cliente clienteClassicSinDeuda;

	protected Automovil automovilOtro;
	
	protected Pedido pedidoRemolque;
	
	protected Camion minitaller;
	protected Camion minigrua;
	protected Camion grangruaConTaller;

	protected TallerMecanico tallerMecanico;

	public void setUp() {
		this.clienteClassicSinDeuda = new Cliente(new ClassicPlan(), CUOTA_MENSUAL_CLIENTE_CLASSIC);
		
		this.automovilOtro = new Automovil(1, new Cliente(new EconomicPlan(), 5));

		this.minitaller = new Minitaller();
		this.grangruaConTaller = new Grangrua(true);
		this.minigrua = new Minigrua();
		this.minigrua.atender(new ReparacionSimple(automovilOtro));
		this.tallerMecanico = new TallerMecanico(this.minitaller, this.minigrua, this.grangruaConTaller);
		this.tallerMecanico.setModuloPagos(new MockModuloPagos(DEUDA_CLIENTE_CLASSIC));
	}
}
