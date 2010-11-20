package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.TallerMecanico;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.PrestadorServicios;

public abstract class DesastrePedido extends EspecialidadPedido {

	public DesastrePedido(Pedido sujeto) {
		super(sujeto);
	}

	public abstract void terminarServicioDelPedido(Tiempo tiempo);

	public abstract Tiempo calcularTiempoDeAtencion();

	@Override
	protected List<List<PrestadorServicios>> prestadoresParaAtenderPorEspecialidad(TallerMecanico tallerMecanico, Pedido pedidoOriginal) {
		List<List<PrestadorServicios>> camionesParaAtenderPorEspecialidad = super.prestadoresParaAtenderPorEspecialidad(
				tallerMecanico, pedidoOriginal);

		// TODO Acá necesito saber si yo (este pedido) tiene heridos graves o
		// leves
		// cosa de agregar ambulancia si es necesario

		return camionesParaAtenderPorEspecialidad;
	}

}
