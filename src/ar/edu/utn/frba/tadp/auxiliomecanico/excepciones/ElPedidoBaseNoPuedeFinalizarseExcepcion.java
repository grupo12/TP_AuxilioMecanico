package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

public class ElPedidoBaseNoPuedeFinalizarseExcepcion extends PedidoNoFinalizadoCorrectamente{

	/**
	 * Ocurre cuando trata de finalizarse un pedido que es basico y al cual no se le agrego nada
	 */
	private static final long serialVersionUID = 1L;

	public ElPedidoBaseNoPuedeFinalizarseExcepcion(String mensaje) {
		super(mensaje);
	}

}
