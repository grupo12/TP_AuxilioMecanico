package ar.edu.utn.frba.tadp.auxiliomecanico.estrategias;

import java.util.Arrays;
import java.util.Collection;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

public class Estrategia {
	
	private Collection<Camion> camiones;

	public Estrategia(Camion... camiones) {
		this.camiones = Arrays.asList(camiones);
	}

	public void atender(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
