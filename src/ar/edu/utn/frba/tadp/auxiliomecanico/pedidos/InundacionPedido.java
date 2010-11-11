package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
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
	protected void validarEspecialidadPara(Cliente cliente) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
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

	@Override
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Automovil getAutomovil() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	
	public Tiempo calcularTiempoDeAtencion() {
		return InundacionPedido.tiempoEmpleadoEnReparacion;
	}

	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		InundacionPedido.cantidadAtendidos +=1;
		InundacionPedido.tiempoEmpleadoEnReparacion = Tiempo.sumarTiempos(InundacionPedido.tiempoEmpleadoEnReparacion,tiempo); 
	}
	
	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return unCamion.puedeAtenderInundacion();
	}

	// BEGIN SANTI
	@Override
	public boolean puedoAtenderte(Camion camion) {
		return camion.puedeAtenderRemolque(super.getAutomovil())
				&& camion.hayTecnicoExpertoInundaciones();

	}
	// END SANTI
}
