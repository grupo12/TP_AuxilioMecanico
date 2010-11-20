package ar.edu.utn.frba.tadp.auxiliomecanico.estrategias;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.Pedido;
import ar.edu.utn.frba.tadp.auxiliomecanico.prestadores.PrestadorServicios;

public class Estrategia implements Cloneable {
	/**
	 * Una estrategia es un conjunto de camiones que pueden resolver todos los
	 * requisitos de un pedido
	 */
	private Set<PrestadorServicios> prestadores = new HashSet<PrestadorServicios>();
	private Pedido pedido;

	/**
	 * Inicializa la estrategia con el pedido correspondiente y un primer camion
	 * que resuelva alguno de los requisitos del pedido
	 * 
	 * @param unPedido
	 *            El pedido al que pertenece la estrategia
	 * @param prestador
	 *            El primer camion de la estrategia
	 */
	public Estrategia(Pedido unPedido, PrestadorServicios prestador) {
		pedido = unPedido;
		prestadores.add(prestador);
	}

	public Estrategia(PrestadorServicios... prestadores) {
		this.prestadores = new HashSet<PrestadorServicios>(Arrays.asList(prestadores));
	}

	public Estrategia(Pedido pedido) {
		this.pedido = pedido;
	}

	public Estrategia clone() {
		Estrategia estrategia = new Estrategia(this.pedido);
		
		for (PrestadorServicios prestador : this.prestadores)
			estrategia.agregarPrestador(prestador);
		
		return estrategia;
	}

	public void atender(Pedido pedido) {
		for (PrestadorServicios prestador : prestadores) {
			prestador.atender(pedido);
		}
	}

	/**
	 * Chequea que el camion a agregar haga un aporte a la solucion del pedido y
	 * en caso de ser afirmativo lo suma a la estrategia
	 * 
	 * @param prestador
	 *            Un camion a agregar a la estrategia
	 */
	public void agregarPrestador(PrestadorServicios prestador) {
		prestadores.add(prestador);
	}

	public Tiempo getTiempoEstimado() {
		return Tiempo.sumarTiempos(this.tiempoDePedidosPendientes(), pedido.calcularTiempoDeAtencion());
	}

	public Tiempo tiempoDePedidosPendientes() {
		Tiempo max = new Tiempo().nuevoTiempo(0, 0);
		Tiempo aux = new Tiempo().nuevoTiempo(0, 0);
		for (PrestadorServicios prestador : prestadores) {
			aux = prestador.tiempoDePedidosPendientes();
			if (Tiempo.esMayor(aux, max))
				max = aux;
		}
		return max;
	}

	public int getCosto() {
		final Tiempo tiempoAtencion = pedido.calcularTiempoDeAtencion();
		int costo = 0;

		for (PrestadorServicios prestador : prestadores) {
			costo += prestador.getCosto(tiempoAtencion);
		}

		return costo;
	}

	public void atender() {
		for (PrestadorServicios camion : prestadores) {
			camion.atender(pedido);
		}
	}

	public void atenderUrgencia(Pedido pedido) {
		for (PrestadorServicios prestador : prestadores) {
			prestador.atenderUrgencia(pedido);
		}
	}

}
