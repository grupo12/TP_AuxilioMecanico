package ar.edu.frba.utn.tadp.auxiliomecanico;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.frba.utn.tadp.auxiliomecanico.pedido.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public class TallerMecanico {

	private Collection<Camion> camiones;
	private ModuloPagos moduloDePagos;
	
	public TallerMecanico(Camion... camiones) {
		this.camiones = Arrays.asList(camiones);
	}
	
	public void asistir(Pedido pedido) throws CuotaDesactualizadaException, ServicioInvalidoException, CamionNoDisponibleException {
		Cliente cliente = pedido.getCliente();
		
		if ( this.moduloDePagos == null)
			throw new ModuloPagosFaltanteException("No se inicializó el módulo de pagos del taller");
		if ( !cliente.isCuotaAlDia(this.moduloDePagos) )
			throw new CuotaDesactualizadaException("La cuota está desactualizada", cliente);
		if ( !pedido.esValidoPara(cliente) )
			throw new ServicioInvalidoException("El cliente no puede solicitar este servicio", pedido);
		
		this.asignarCamion(pedido.getAutomovil(), pedido);
	}

	private void asignarCamion(Automovil automovil, Pedido pedido) throws CamionNoDisponibleException {
		if ( !this.algunCamionPuedeAtender(pedido, automovil) )
			throw new CamionNoDisponibleException("No hay camión disponible para atender el pedido", pedido);
		
		this.camionParaAsignarA(pedido).atender(pedido);
	}

	protected Camion camionParaAsignarA(Pedido pedido) {
		return pedido.getAutomovil().getCliente().selectCamion( this.camionesPuedenAtender(pedido, pedido.getAutomovil()) );
	}

	protected Collection<Camion> camionesPuedenAtender(Pedido pedido, Automovil automovil) {
		// #select:
		Collection<Camion> camionesPuedenAtender = new LinkedList<Camion>();
		
		for (Camion camion : camiones)
			if ( pedido.puedeSerAtendidoPorCamion(camion, automovil) )
				camionesPuedenAtender.add(camion);
		
		return camionesPuedenAtender;
	}

	private boolean algunCamionPuedeAtender(Pedido pedido, Automovil automovil) {
		return !this.camionesPuedenAtender(pedido, automovil).isEmpty();
	}
	
	public void setModuloPagos(ModuloPagos moduloDePagos) {
		this.moduloDePagos = moduloDePagos;
	}

	public void finalizoPedido(Camion camion, Pedido pedido) {
		camion.finalizoPedido(pedido);
		pedido.getCliente().finalizoPedido(pedido);
	}
}
