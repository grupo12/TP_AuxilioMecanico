package ar.edu.utn.frba.tadp.auxiliomecanico.planes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.MenosPedidosComparator;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.estrategias.Estrategia;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.PrestadorServicios;
import ar.edu.utn.frba.tadp.auxiliomecanico.servicios.AutoReemplazoServicio;

public class PlatinumPlan extends Plan {

	EstadoPlatinum estado;
	
	public PlatinumPlan(){
		estado = new EstadoRapido(this);
	}
	
	@Override
	public Camion selectCamion(Collection<Camion> camiones) {
		List<Camion> camionesOrdenados = new ArrayList<Camion>(camiones);
		
		Collections.sort(camionesOrdenados, new MenosPedidosComparator());
		
		return camionesOrdenados.get(0); 
	}

	@Override
	public double maximoMoraPara(Cliente cliente, ModuloPagos moduloPagos) {
		return cliente.getCuotaMensual();
	}

	@Override
	public void validarRemolquePara(Cliente cliente) {
		// Un cliente con plan Platinum siempre puede pedir remolque
	}
		public void setEstado(EstadoPlatinum unEstado) {		estado = unEstado;	}		@Override	public Estrategia selectEstrategia(Collection<Estrategia> estrategias, Cliente unCliente) {		estado.verificarEstado(unCliente);		return estado.seleccionarEstrategia(estrategias);	}	@Override	public PrestadorServicios prestadorParaServicioEnTaller(TallerMecanico tallerMecanico, Cliente cliente) {		return AutoReemplazoServicio.getInstance().getPrestadorServicio(tallerMecanico);	}}
