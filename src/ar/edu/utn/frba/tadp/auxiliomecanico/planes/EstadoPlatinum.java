package ar.edu.utn.frba.tadp.auxiliomecanico.planes;

import java.util.Collection;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.estrategias.Estrategia;

public interface EstadoPlatinum {
	
	public void verificarEstado(Cliente cliente);
	
	public Estrategia seleccionarEstrategia(Collection<Estrategia> estrategias);

}
