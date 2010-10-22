package ar.edu.utn.frba.tadp.auxiliomecanico.pedidos;

import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.Camion;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Automovil;
import ar.edu.utn.frba.tadp.auxiliomecanico.clientes.Cliente;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Tiempo;
import ar.edu.utn.frba.tadp.auxiliomecanico.modulopagos.ModuloPagos;

/** SSSSSSSSSSSSSSSSSSSSSSs
 * Representa un pedido dado, realizado por un cliente al sistema de auxilio
 * mecánico.
 * 
 */
public abstract class Pedido {

	private static ModuloPagos ModuloDePagos;
	

	/**
	 * Realiza todas las operaciones correspondientes a la validación del mismo
	 * en el sistema.
	 */
	public void validar() {

		this.validarExistenciaModuloPagos();
		this.validarCliente();
	}

	/**
	 * Realiza todas las validaciones del pedido en relación al cliente que lo
	 * solicita.
	 */
	private void validarCliente() {
		Cliente cliente = this.getCliente();
		cliente.validarCuotaAlDia(ModuloDePagos);
		this.validarEspecialidadPara(cliente);
	}
	
	/**
	 * Valida que haya efectivamente un módulo de pagos establecido.
	 */
	private void validarExistenciaModuloPagos() {
		if (ModuloDePagos == null)
			throw new ModuloPagosFaltanteException("No se inicializó el módulo de pagos del taller");
	}

	/**
	 * Realiza las validaciones específicas de cada especialidad de pedido sobre
	 * el cliente.
	 * 
	 * @param cliente
	 *            Cliente que solicita el pedido
	 */
	protected abstract void validarEspecialidadPara(Cliente cliente);

	/**
	 * Determina si el mismo es posible ser atendido por un camión dado.
	 * 
	 * @param unCamion
	 *            Camión candidato a atender el pedido
	 * @param automovil
	 *            Automóvil para el cual se solicitó el pedido
	 * @return Puede o no puede
	 */
	public abstract boolean puedeSerAtendidoPorCamion(Camion unCamion, Automovil automovil);

	/**
	 * Responde si el pedido es simple.
	 * 
	 * @return <b>true</b> - Es simple<br>
	 *         <b>false</b> - No es simple
	 */
	public abstract boolean isReparacionSimple();

	/**
	 * Responde si el pedido es de remolque.
	 * 
	 * @return <b>true</b> - Es de remolque<br>
	 *         <b>false</b> - No es de remolque
	 */
	public abstract boolean isRemolque();

	public abstract Cliente getCliente();

	public abstract Automovil getAutomovil();

	public static void setModuloPagos(ModuloPagos moduloDePagos) {
		ModuloDePagos = moduloDePagos;
	}
	
	/**
	 * FALTA IMPLEMENTAR TAMBIEN
	 * Determina el tiempo que tarda un tipo de pedido en ser atendido
	 * 
	 * @param pedido
	 *            Pedido a calcular tiempo
	 * @return Tiempo 
	 */
	public abstract Tiempo calcularTiempoDeAtencion(Pedido pedido);
	
	/**
	 * FALTA IMPLEMENTAR TAMBIEN
	 *finaliza el pedido siempre y cuando sea posible hacerlo, es decir que el mismo sea 
	 *previamente terminado  
	 */
	public boolean finalizarElPedido(){
		return false;};
	
	/**
	 *A diferencia de finalizar pedido , terminar se ocupa de trabajo necesario que hay que 
	 *llevar a cabo para que la instancia de pedido este terminada, dando la posibilidad de
	 *luego finalizarla 
	 * @param tiempo 
	 */
	public abstract void terminarPedido(Tiempo tiempo);
}
