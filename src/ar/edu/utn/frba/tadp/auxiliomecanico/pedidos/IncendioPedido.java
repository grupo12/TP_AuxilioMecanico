package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;

public class IncendioPedido extends DesastrePedido {

	boolean isPeligroso;

	public IncendioPedido(Pedido sujeto, boolean isPeligroso) {
		super(sujeto);
		this.isPeligroso = isPeligroso;
	}

	private static Tiempo tiempoEmpleadoEnReparacion;
	private static int cantidadAtendidos;

	static {
		// Inicialización de variables del tiempo de reparación
		tiempoEmpleadoEnReparacion = new Tiempo().nuevoTiempo(0, 0);
		// Inicialización de cantidad de atendidos
		cantidadAtendidos = 0;
	}

	public Tiempo calcularTiempoDeAtencion() {
		Tiempo tiempoARetornar = Tiempo.promediarTiempo(IncendioPedido.tiempoEmpleadoEnReparacion, IncendioPedido.cantidadAtendidos);
		return tiempoARetornar ;
	}

	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		IncendioPedido.cantidadAtendidos += 1;
		IncendioPedido.tiempoEmpleadoEnReparacion = Tiempo.sumarTiempos(
				IncendioPedido.tiempoEmpleadoEnReparacion, tiempo);
		sujeto.terminarServicioDelPedido(tiempo) ;
	}

	public void setPeligroso(boolean isPeligroso) {
		this.isPeligroso = isPeligroso;
	}

	public boolean isPeligroso() {
		return isPeligroso;
	}

	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion,
			Automovil automovil) {
		if (this.isPeligroso())
			return unCamion.hayEquipoEspecialContraIncendio();
		return true;
		// no es peligroso, puede manejarlo cualquier camion de
		// auxilio
	}
}
