package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.complejidades;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Reparacion;

public abstract class Complejidad {

	public abstract void validarEspecialidadPara(Cliente cliente, Reparacion reparacion);

}
