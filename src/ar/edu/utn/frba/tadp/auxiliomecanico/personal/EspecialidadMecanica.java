package ar.edu.utn.frba.tadp.auxiliomecanico.personal;

public class EspecialidadMecanica implements EspecialidadTecnico{

	@Override
	public boolean sosElectricista() {
		return false;
	}

	@Override
	public boolean sosMecanico() {
		return true;
	}

}
