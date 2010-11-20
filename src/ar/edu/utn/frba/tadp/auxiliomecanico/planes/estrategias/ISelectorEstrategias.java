package ar.edu.utn.frba.tadp.auxiliomecanico.planes.estrategias;

import java.util.Collection;

import ar.edu.utn.frba.tadp.auxiliomecanico.estrategias.Estrategia;

public interface ISelectorEstrategias {

	public Estrategia elegirEstrategia(Collection<Estrategia> estrategias);
}
