package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.complejidades;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Reparacion;

public class AltaComplejidad extends Complejidad {

	@Override
	public void validarEspecialidadPara(Cliente cliente, Reparacion reparacion) {
		cliente.validarReparacionCompleja();		
	}

}
