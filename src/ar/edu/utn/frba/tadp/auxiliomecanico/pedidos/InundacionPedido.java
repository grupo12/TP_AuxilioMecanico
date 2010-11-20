package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;

public class InundacionPedido extends DesastrePedido {


	public InundacionPedido(Pedido sujeto) {
		super(sujeto);
		// TODO Auto-generated constructor stub
	}

	private static Tiempo tiempoEmpleadoEnReparacion;
	private static int cantidadAtendidos;

	static {
		// Inicialización de variables del tiempo de reparación
		tiempoEmpleadoEnReparacion = new Tiempo().nuevoTiempo(0, 0);
		// Inicialización de cantidad de atendidos
		cantidadAtendidos = 0;
	}

	@Override
	public boolean puedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isReparacionSimple() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isRemolque() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	
	public Tiempo calcularTiempoDeAtencion() {
		Tiempo tiempoARetornar = Tiempo.promediarTiempo(InundacionPedido.tiempoEmpleadoEnReparacion, InundacionPedido.cantidadAtendidos);
		return tiempoARetornar;
	}

	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		InundacionPedido.cantidadAtendidos +=1;
		InundacionPedido.tiempoEmpleadoEnReparacion = Tiempo.sumarTiempos(InundacionPedido.tiempoEmpleadoEnReparacion,tiempo); 
		sujeto.terminarServicioDelPedido(tiempo);
	}
	
	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return unCamion.hayRemolque(super.getAutomovil())
		&& unCamion.hayTecnicoExpertoInundaciones();
	}
	
	@Override
	public boolean tieneUrgencias(){
		return true;
	}
}
