package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.complejidades;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Reparacion;

public abstract class Complejidad {

	public abstract void validarEspecialidadPara(Cliente cliente,
			Reparacion reparacion);

	public abstract int cantAyudantesRequeridos();
	
	public boolean puedeAtenderte(Camion camion) {
		return camion.cantidadAyudantes() == this.cantAyudantesRequeridos();
	}

}
