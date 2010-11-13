package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;

public abstract class DesastrePedido extends EspecialidadPedido {

	public DesastrePedido(Pedido sujeto) {
		super(sujeto);
	}

	@Override
	public abstract boolean puedoAtenderte(Camion camion);

	public abstract void terminarServicioDelPedido(Tiempo tiempo);

	public abstract Tiempo calcularTiempoDeAtencion();

	@Override
	protected List<List<Camion>> camionesParaAtenderPorEspecialidad(TallerMecanico tallerMecanico, Pedido pedidoOriginal) {
		List<List<Camion>> camionesParaAtenderPorEspecialidad = super.camionesParaAtenderPorEspecialidad(
				tallerMecanico, pedidoOriginal);

		// TODO Acá necesito saber si yo (este pedido) tiene heridos graves o
		// leves
		// cosa de agregar ambulancia si es necesario

		return camionesParaAtenderPorEspecialidad;
	}

}
