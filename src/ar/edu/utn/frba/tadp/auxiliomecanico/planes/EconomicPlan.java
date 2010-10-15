package ar.edu.utn.frba.tadp.auxiliomecanico.planes;

import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.CantidadReparacionesSimplesMaximaEconomicSuperadaException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.EconomicNoPuedeAtenderRemolqueException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.ReparacionComplejaInvalidaParaEconomicException;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public class EconomicPlan extends Plan {
	
	private static final int CANTIDAD_MAXIMA_REPARACIONES_SIMPLES = 5;

	@Override
	public double maximoMoraPara(Cliente cliente, ModuloPagos moduloPagos) {
		return 0;
	}

	@Override
	public void validarRemolquePara(Cliente cliente) {
		throw new EconomicNoPuedeAtenderRemolqueException(cliente);
	}
	
	@Override
	public void validarReparacionSimplePara(Cliente cliente) {
		if (!(cliente.cantidadReparacionesSimplesRealizadas() <= CANTIDAD_MAXIMA_REPARACIONES_SIMPLES))
			throw new CantidadReparacionesSimplesMaximaEconomicSuperadaException(cliente, CANTIDAD_MAXIMA_REPARACIONES_SIMPLES);
	}

	@Override
	public void validarReparacionComplejaPara(Cliente cliente) {
		throw new ReparacionComplejaInvalidaParaEconomicException(cliente);
	}
}
