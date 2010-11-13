package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.complejidades;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.ProblemaMecanico;

public class MediaComplejidad extends Complejidad {

	@Override
	public void validarEspecialidadPara(Cliente cliente, ProblemaMecanico reparacion) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean puedeAtenderte(Camion camion){
		return camion.cantidadAyudantes() >= 1;
	}
	
}
