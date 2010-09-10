package ar.edu.frba.utn.tadp.auxiliomecanico;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import ar.edu.frba.utn.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.frba.utn.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

public class TallerMecanico {

	private Collection<Camion> camiones;
	private Collection<Cliente> Clientes;
	
	public ModuloPagos moduloDePagos;
	
	public TallerMecanico(Camion... camiones) {
		this.camiones = Arrays.asList(camiones);
		this.moduloDePagos = null;
	}
	
	public void asistir(Pedido pedido) throws CuotaDesactualizadaException, ServicioInvalidoException, CamionNoDisponibleException {
		Cliente cliente = pedido.getAutomovil().getCliente();
		
		if ( !cliente.isCuotaAlDia(this.moduloDePagos) )
			throw new CuotaDesactualizadaException("La cuota está desactualizada", cliente);
		if ( !pedido.sonServiciosValidos() )
			throw new ServicioInvalidoException("El cliente no puede solicitar este servicio", pedido);
		
		this.asignarCamion(pedido);
	}

	private void asignarCamion(Pedido pedido) throws CamionNoDisponibleException {
		if ( !this.algunCamionPuedeAtender(pedido) )
			throw new CamionNoDisponibleException("No hay camión disponible para atender el pedido", pedido);
		
		Camion camion = pedido.getAutomovil().getCliente().selectCamion( this.camionesPuedenAtender(pedido) );
		camion.atender(pedido);
	}

	private Collection<Camion> camionesPuedenAtender(Pedido pedido) {
		// #select:
		Collection<Camion> camionesPuedenAtender = new LinkedList<Camion>();
		
		for (Camion camion : camiones)
			if ( pedido.puedeSerAtendidoPor(camion) )
				camionesPuedenAtender.add(camion);
		
		return camionesPuedenAtender;
	}

	private boolean algunCamionPuedeAtender(Pedido pedido) {
		return !this.camionesPuedenAtender(pedido).isEmpty();
	}
	
	public void agregarModuloPagos(ModuloPagos moduloDePagos) {
		this.moduloDePagos = moduloDePagos;
	}
	
	public void setClientes ( Cliente...clientes ){
		this.Clientes = Arrays.asList(clientes);	
	}
}

