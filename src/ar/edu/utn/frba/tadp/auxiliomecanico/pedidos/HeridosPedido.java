package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.NoHayAmbulanciasEnElTallerException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.NoSePuedeAtenderEspecialidad;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.PrestadorServicios;

public class HeridosPedido extends EspecialidadPedido {

	private static Tiempo tiempoEmpleadoEnReparacion;
	private static int cantidadAtendidos;

	private boolean grave;
	private boolean terminado;
	
	static {
		// Inicialización de variables del tiempo de reparación
		tiempoEmpleadoEnReparacion = new Tiempo().nuevoTiempo(0, 0);
		// Inicialización de cantidad de atendidos
		cantidadAtendidos = 0;
	}
	
	public HeridosPedido(Pedido sujeto, boolean grave) {
		super(sujeto);
		this.grave = grave;
		this.terminado = false;
	}

	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return this.grave ? false : unCamion.tieneEquipoPrimerosAuxilios(); 
	}

	@Override
	public Tiempo calcularTiempoDeAtencion() {
		return tiempoEmpleadoEnReparacion;
	}

	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		tiempoEmpleadoEnReparacion = Tiempo.sumarTiempos(tiempoEmpleadoEnReparacion, tiempo);
		cantidadAtendidos += 1;

		this.terminado = true;
	}

	@Override
	protected List<List<PrestadorServicios>> prestadoresParaAtenderPorEspecialidad(TallerMecanico tallerMecanico, Pedido pedidoOriginal) {
		List<List<PrestadorServicios>> camionesParaAtenderPorEspecialidad = this.sujeto.prestadoresParaAtenderPorEspecialidad(tallerMecanico, this);

		// Agrego a las ambulancias que pueden atender tanto heridos leves como graves
		final List<PrestadorServicios> ambulancias = tallerMecanico.getAmbulancias();
		
		if (this.grave && ambulancias.isEmpty())
			throw new NoHayAmbulanciasEnElTallerException(tallerMecanico);

		List<PrestadorServicios> prestadores = ambulancias;
			
		if (!this.grave)
			// Agrego además a los camiones que pueden atender heridos leves
			for (PrestadorServicios prestador : tallerMecanico.camionesParaAtenderEspecialidad(this))
				prestadores.add(prestador);
		
		if (prestadores.isEmpty())
			throw new NoSePuedeAtenderEspecialidad(this);
		
		camionesParaAtenderPorEspecialidad.add(prestadores);

		return camionesParaAtenderPorEspecialidad;
	}
}
