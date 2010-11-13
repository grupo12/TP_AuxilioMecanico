package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.complejidades;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.ProblemaMecanico;

public class AltaComplejidad extends Complejidad {

	@Override
	public void validarEspecialidadPara(Cliente cliente, ProblemaMecanico reparacion) {
		cliente.validarReparacionCompleja();		
	}

	@Override
	public boolean puedeAtenderte(Camion camion){
		return camion.cantidadAyudantes() >= 2;
	}


	
}