package ar.edu.utn.frba.tadp.auxiliomecanico;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Grangrua;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Minigrua;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Minitaller;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.MockModuloPagos;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.PedidoBase;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.ReparacionSimple;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.ClassicPlan;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.EconomicPlan;

/**
 * 
 * Genera: 
 * - Automovil: de una tonelada con cliente Economic y valor de cuota = $5
 * - Camiones: uno de cada tipo (sin complejidad)
 * - Un módulo de pagos para la clase Pedido
 * - Un taller con los camiones arriba mencionados
 * 
 */

public abstract class AuxilioMecanicoTest {

	protected static final int DEUDA_CLIENTE_CLASSIC = 0;
	protected static final int PESO_AUTO_LIVIANO = 1; // toneladas
	protected static final int CUOTA_MENSUAL_CLIENTE_CLASSIC = 70; //$
	protected static final int PESO_AUTO_PESADO = 5;

	protected Automovil automovilOtro;
	
	protected Pedido pedidoRemolque;
	
	protected Camion minitaller;
	protected Camion minigrua;
	protected Camion grangruaConTaller;

	protected TallerMecanico tallerMecanico;
	protected Cliente clienteClassicSinDeuda;

	public void setUp() {
		
		this.clienteClassicSinDeuda = new Cliente(new ClassicPlan(), CUOTA_MENSUAL_CLIENTE_CLASSIC);
		this.automovilOtro = new Automovil(1, new Cliente(new EconomicPlan(), 5));
		this.minitaller = new Minitaller();
		this.grangruaConTaller = new Grangrua(true);
		this.minigrua = new Minigrua();
		this.minigrua.atender(new ReparacionSimple(new PedidoBase(automovilOtro)));
		this.tallerMecanico = new TallerMecanico(this.minitaller, this.minigrua, this.grangruaConTaller);
		Pedido.setModuloPagos(new MockModuloPagos(DEUDA_CLIENTE_CLASSIC));

	}
}
