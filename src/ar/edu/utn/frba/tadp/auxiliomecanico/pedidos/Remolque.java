package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import java.util.LinkedList;
import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.PrestadorServicios;

public class Remolque extends EspecialidadPedido {

	private static int cantidadAtendidos;
	private boolean terminado;

	static {
		cantidadAtendidos = 0;
	}

	public Remolque(Pedido sujeto) {
		super(sujeto);
		terminado = false;
	}

	public boolean isRemolque() {
		return true;
	}

	@Override
	protected boolean doPuedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil) {
		Automovil a = super.getAutomovil();
		return unCamion.hayRemolque(a);
	}

	@Override
	protected void doValidarEspecialidadPara(Cliente cliente) {
		cliente.validarRemolque();
	}

	@Override
	public void terminarServicioDelPedido(Tiempo tiempo) {
		cantidadAtendidos += 1;
		terminado = true;
		sujeto.terminarServicioDelPedido(tiempo);
	}

	@Override
	public Tiempo calcularTiempoDeAtencion() {
		throw new UnsupportedOperationException();
	}

	@Override
	protected List<List<PrestadorServicios>> prestadoresParaAtenderPorEspecialidad(TallerMecanico tallerMecanico,
			Pedido pedidoOriginal) {
		List<List<PrestadorServicios>> camionesParaAtenderPorEspecialidad = super.prestadoresParaAtenderPorEspecialidad(
				tallerMecanico, this);

		PrestadorServicios autoRemis = this.getCliente().prestadorParaServicioEnTaller(tallerMecanico);

		// Si el auto reemplazo o remis no es nulo, entonces hay que agregarlo como exigencia
		if (autoRemis != null) {
			List<PrestadorServicios> autosRemises = new LinkedList<PrestadorServicios>();
			autosRemises.add(autoRemis);

			camionesParaAtenderPorEspecialidad.add(autosRemises);
		}

		return camionesParaAtenderPorEspecialidad;
	}

}
