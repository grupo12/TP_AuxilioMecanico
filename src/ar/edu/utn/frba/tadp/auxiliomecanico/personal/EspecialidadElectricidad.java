package ar.edu.utn.frba.tadp.auxiliomecanico.personal;

public class EspecialidadElectricidad implements EspecialidadTecnico{

	@Override
	public boolean sosElectricista() {
		return true;
	}

	@Override
	public boolean sosMecanico() {
		return false;
	}

}
