package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.complejidades;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.ProblemaMecanico;

public abstract class Complejidad {

	public abstract void validarEspecialidadPara(Cliente cliente,
			ProblemaMecanico reparacion);

	public abstract boolean puedeAtenderte(Camion camion);

}
