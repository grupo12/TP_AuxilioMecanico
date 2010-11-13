package ar.edu.utn.frba.tadp.auxiliomecanico.testingReparaciones;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.edu.utn.frba.tadp.auxiliomecanico.builders.CPedidoBuilder;
import ar.edu.utn.frba.tadp.auxiliomecanico.builders.IPedidoBuilder;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Grangrua;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.MockModuloPagos;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.EspecialidadPedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.planes.*;

public class VuelcosTest{

	private IPedidoBuilder builder;
	private Camion grangruaConTaller;

	@Test
	public void vuelcoSoportaPesoTest(){
		Automovil a = new Automovil(4, new Cliente(new PlatinumPlan(), 5));
		
		Pedido.setModuloPagos(new MockModuloPagos(0));

		builder = new CPedidoBuilder();
		Pedido p = builder.armarPedidoBase(a).addVuelco().build();

		Personal trioLoco = new Personal();

		Tecnico srMecanico = new Tecnico(new EspecialidadMecanica());
		Tecnico ingElectrico = new Tecnico(new EspecialidadElectricidad());
		Tecnico mecanicoPepe = new Tecnico(new EspecialidadMecanica());

		trioLoco.addTecnico(srMecanico);
		srMecanico.addEspecialidad(new EspecialidadElectricidad());
		trioLoco.addTecnico(ingElectrico);
		trioLoco.addTecnico(mecanicoPepe);
		this.grangruaConTaller = new Grangrua(true);
		this.grangruaConTaller.asignarPersonal(trioLoco);

		assertTrue(this.grangruaConTaller.podesAtender((EspecialidadPedido) p));
	}
}
