<<<<<<< HEAD
package ar.edu.utn.frba.tadp.auxiliomecanico.gps;

public enum TallerAuxiliar {
	tallerPM(Lugar.urquiza),/*zona urquiza*/
	sanchezSolucionesMecánicas(Lugar.moreno),/*zona moreno*/
	levelCars(Lugar.lujan),/*zona lujan*/
	autoproSA(Lugar.tigre),
	bonattiTeamRacing(Lugar.lugano), /*zona lugano*/
	gabrielFalzone(Lugar.palermo), /*zona palermo*/
	noTaller(Lugar.noLugar);
	
	private final Lugar dondeEsta;   // in kilograms
	TallerAuxiliar(Lugar unLugar) {
        this.dondeEsta = unLugar;
	}
	public Lugar getDondeEsta() {
		return dondeEsta;
	}
	
=======
package ar.edu.utn.frba.tadp.auxiliomecanico.gps;

public enum TallerAuxiliar {
	tallerPM(Lugar.urquiza), /* zona urquiza */
	sanchezSolucionesMecánicas(Lugar.moreno), /* zona moreno */
	levelCars(Lugar.lujan), /* zona lujan */
	autoproSA(Lugar.tigre), bonattiTeamRacing(Lugar.lugano), /* zona lugano */
	gabrielFalzone(Lugar.palermo); /* zona palermo */

	private final Lugar dondeEsta; // in kilograms

	TallerAuxiliar(Lugar unLugar) {
		this.dondeEsta = unLugar;
	}

	public Lugar getDondeEsta() {
		return dondeEsta;
	}

>>>>>>> bf330ad7b26555cb77cb1517bf4c74e6c3598171
}