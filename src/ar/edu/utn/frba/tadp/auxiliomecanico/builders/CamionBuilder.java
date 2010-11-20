package ar.edu.utn.frba.tadp.auxiliomecanico.builders;

import ar.edu.utn.frba.tadp.auxiliomecanico.pedidos.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.personal.Personal;
import ar.edu.utn.frba.tadp.auxiliomecanico.camiones.*;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.AsignaCamionBaseAUnoExistenteException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.GruaNoVerificaPersonalException;
import ar.edu.utn.frba.tadp.auxiliomecanico.excepciones.MinitallerNoVerificaPersonalException;

public class CamionBuilder {

	/**
	 * Construye los 3 tipos de camion: quieroMinigrua, quieroMinitaller,
	 * quierGranGrua. Verifica las reglas de negocio del punto 2.2 (acerca del
	 * personal). Agrega las especialidades de pedido que son obligatorias para
	 * cada camion (ej.: todos atienden incendios normales)
	 */
	protected Camion camion;

	public CamionBuilder quieroMiniTaller(Personal p) {
		if (camion == null) {
			camion = new Minitaller();
			if (p.cantPersonas() == 1 && p.hayUnExperto())
				camion.asignarPersonal(p);
			else
				throw new MinitallerNoVerificaPersonalException(
						"O hay mas de una persona o el que hay no es experto",
						camion);

		} else
			throw new AsignaCamionBaseAUnoExistenteException(
					"Ya hay un camion asignado.", camion);
		return this;
	}

	public CamionBuilder quieroMinigrua(Personal p) {
		if (camion == null) {
			camion = new Minigrua();
			if (this.verificarPersonalParaGrua(p))
				camion.asignarPersonal(p);
			else
				throw new GruaNoVerificaPersonalException(
						"O hay mas de 3 personas o falta un experto", camion);
		} else
			throw new AsignaCamionBaseAUnoExistenteException(
					"Ya hay un camion asignado.", camion);
		return this;
	}

	private boolean verificarPersonalParaGrua(Personal p) {
		return p.cantPersonas() <= 3 && p.hayUnExperto();
	}

	/**
	 * 
	 * @param p
	 * @param withTallerAltaComplejidad
	 *            : solamente la gran grua puede ofrecer este tipo de servicio
	 * @return
	 */
	public CamionBuilder quieroGranGrua(Personal p,
			boolean withTallerAltaComplejidad) {
		if (camion == null) {
			camion = new Grangrua(withTallerAltaComplejidad);
			camion.addEspecialidad(new ReparacionCompleja());
			camion.asignarPersonal(p);
		} else
			throw new AsignaCamionBaseAUnoExistenteException(
					"Ya hay un camion asignado.", camion);
		return this;
	}

	public CamionBuilder addEquipoEspecialContraIncendios() {
		camion.addEspecialidad(new IncendioPedido());
		return this;
	}

	public Camion buildCamion() {
		return camion;
	}

}