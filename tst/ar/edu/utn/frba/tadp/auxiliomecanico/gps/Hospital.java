package ar.edu.utn.frba.tadp.auxiliomecanico.gps;

public enum Hospital {
	Hospitalpirovano(Lugar.urquiza),/*zona urquiza*/
	HospitalMarianoYLucianoDeLavega(Lugar.moreno),/*zona moreno*/
	HospitalGuemes(Lugar.lujan),/*zona lujan*/
	HospitalTigre(Lugar.tigre),
	HospitalCeciliaGrierson(Lugar.lugano), /*zona lugano*/
	HospitalFernadez(Lugar.palermo), /*zona palermo*/
	noHospital(Lugar.noLugar);
	
	final Lugar dondeEsta;   // in kilograms
	Hospital(Lugar unLugar) {
        this.dondeEsta = unLugar;
	}
	public Lugar getDondeEsta() {
		return dondeEsta;
	}
	
}
