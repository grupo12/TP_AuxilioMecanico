package ar.edu.utn.frba.tadp.auxiliomecanico.prestadores;

import java.util.LinkedList;
import java.util.List;

import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;

public class AutoReemplazo implements PrestadorServicios {

	private static int costoHora = 0;

	private List<Pedido> pedidosAsignados;
	private int costo;

	public AutoReemplazo(int costo) {
		this.pedidosAsignados = new LinkedList<Pedido>();
		this.costo = costo;
	}

	@Override
	public void atenderUrgencia(Pedido unPedido) {
		this.pedidosAsignados.add(0, unPedido);
	}

	@Override
	public void atender(Pedido unPedido) {
		this.pedidosAsignados.add(unPedido);
	}

	@Override
	public int getCosto(Tiempo tiempoAtencion) {
		return costo + tiempoAtencion.calcularCosto(costoHora);
	}

	public static void setCostoHora(int costoHora) {
		AutoReemplazo.costoHora  = costoHora;
	}
	
	public Tiempo tiempoDePedidosPendientes() {
		Tiempo tiempoEstimado = new Tiempo().nuevoTiempo(0, 0);
		for (Pedido pedido : pedidosAsignados) {
			tiempoEstimado = Tiempo.sumarTiempos(tiempoEstimado,
					pedido.calcularTiempoDeAtencion());
		}
		return tiempoEstimado;
	}
	
}
