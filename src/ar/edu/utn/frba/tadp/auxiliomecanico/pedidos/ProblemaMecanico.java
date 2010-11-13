package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.complejidades.Complejidad;

public class ProblemaMecanico extends EspecialidadPedido {

	private static Tiempo tiempoEmpleadoEnReparacion;
	private static int cantidadAtendidos;

	private Complejidad complejidad;
	private boolean terminado;

	static {
		// Inicialización de variables del tiempo de reparación
		tiempoEmpleadoEnReparacion = new Tiempo().nuevoTiempo(0, 0);
		// Inicialización de cantidad de atendidos
		cantidadAtendidos = 0;
	}

	public ProblemaMecanico(Pedido sujeto, Complejidad complejidad) {
		super(sujeto);
		this.complejidad = complejidad;
		this.terminado = false;
	}

	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		return complejidad.puedeAtenderte(unCamion)
		&& unCamion.hayUnMecanico();
	}

	@Override
	protected void doValidarEspecialidadPara(Cliente cliente) {
		this.complejidad.validarEspecialidadPara(cliente, this);
	}

	@Override
	public Tiempo calcularTiempoDeAtencion() {		return ProblemaMecanico.tiempoEmpleadoEnReparacion;	}	@Override	public void terminarServicioDelPedido(Tiempo tiempo) {
		tiempoEmpleadoEnReparacion = Tiempo.sumarTiempos(ProblemaMecanico.tiempoEmpleadoEnReparacion, tiempo);
		cantidadAtendidos += 1;
		terminado = true;
		sujeto.terminarServicioDelPedido(tiempo);
	}

	@Override
	public Tiempo calcularTiempoDeAtencion() {
		Tiempo tiempoRetorno = Tiempo.promediarTiempo(Reparacion.tiempoEmpleadoEnReparacion,
				Reparacion.cantidadAtendidos);
		return tiempoRetorno;
	}

	@Override
	protected List<List<Camion>> camionesParaAtenderPorEspecialidad(TallerMecanico tallerMecanico, Pedido pedidoOriginal) {
		// Si requiere remolque, entonces no se agregan camiones que puedan
		// atender reparaciones
		if (pedidoOriginal.isRemolque())
			return this.sujeto.camionesParaAtenderPorEspecialidad(tallerMecanico, pedidoOriginal);

		return super.camionesParaAtenderPorEspecialidad(tallerMecanico, pedidoOriginal);
	}

}
