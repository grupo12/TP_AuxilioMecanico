package ar.edu.frba.utn.tadp.auxiliomecanico;

import java.util.Arrays;
import java.util.Collection;

import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.servicios.RemolqueServicio;
import ar.edu.frba.utn.tadp.auxiliomecanico.servicios.Servicio;

public class Pedido {
	
	private Automovil automovil;
	private Collection<Servicio> servicios;

	public Pedido(Automovil automovil, Servicio... servicios) {
		this.automovil = automovil;
		this.servicios = Arrays.asList(servicios);
	}

	public Automovil getAutomovil() {
		return automovil;
	}

	public boolean sonServiciosValidos() {
		// TODO Auto-generated method stub
		return false;
	}

}
