package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;

public class VuelcoPedido extends DesastrePedido {
	private static Tiempo tiempoEmpleadoEnReparacion;
	private static int cantidadAtendidos;

	static {
		// Inicialización de variables del tiempo de reparación
		tiempoEmpleadoEnReparacion = new Tiempo().nuevoTiempo(0, 0);
		// Inicialización de cantidad de atendidos
		cantidadAtendidos = 0;
	}

	public VuelcoPedido(Pedido sujeto) {
		super(sujeto);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void validarEspecialidadPara(Cliente cliente) {
		this.doValidarEspecialidadPara(cliente);
	}

	@Override
	public boolean puedeSerAtendidoPorCamion(Camion unCamion,
			Automovil automovil) {
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
		return super.getCliente();
	}

	@Override
	public Automovil getAutomovil() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Tiempo calcularTiempoDeAtencion() {
		return VuelcoPedido.tiempoEmpleadoEnReparacion;
	}

	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		VuelcoPedido.cantidadAtendidos += 1;
		VuelcoPedido.tiempoEmpleadoEnReparacion = Tiempo.sumarTiempos(
				VuelcoPedido.tiempoEmpleadoEnReparacion, tiempo);
	}

	// Queda vacío porque el enunciado no especifica nada.
	@Override
	protected void doValidarEspecialidadPara(Cliente cliente) {
	}

	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion,
			Automovil automovil) {
		return unCamion.hayRemolque(super.getAutomovil());
	}

	@Override
	public Tiempo calcularTiempoDeAtencion(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}
