package ar.edu.utn.frba.tadp.auxiliomecanico.planes;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.CantidadRemolquesMaximaClassicSuperadaException;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public class ClassicPlan extends Plan {

	private static final int CANTIDAD_MAXIMA_REMOLQUES = 5;

	@Override
	public double maximoMoraPara(Cliente cliente, ModuloPagos moduloPagos) {
		return 200;
	}

	@Override
	public void validarRemolquePara(Cliente cliente) {
		if(!(cliente.cantidadRemolquesRealizados() <= CANTIDAD_MAXIMA_REMOLQUES))
			throw new CantidadRemolquesMaximaClassicSuperadaException(cliente, CANTIDAD_MAXIMA_REMOLQUES);
	}
}
