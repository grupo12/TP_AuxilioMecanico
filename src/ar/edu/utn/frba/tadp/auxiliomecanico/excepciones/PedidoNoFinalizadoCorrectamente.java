package ar.edu.utn.frba.tadp.auxiliomecanico.excepciones;

public class PedidoNoFinalizadoCorrectamente extends UserException{
	private static final long serialVersionUID = 1L;

	public PedidoNoFinalizadoCorrectamente(String mensaje){
		super(mensaje);
	}

}
