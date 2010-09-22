package ar.edu.frba.utn.tadp.auxiliomecanico.camiones;

import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.Pedido;

public class Grangrua implements Camion {

	private final boolean tallerAltaComplejidad;

	public Grangrua(boolean tallerAltaComplejidad) {
		this.tallerAltaComplejidad = tallerAltaComplejidad;
	}

	@Override
	public void atender(Pedido unPedido) {
		// TODO Auto-generated method stub
	}

}
