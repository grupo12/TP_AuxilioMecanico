package ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo;

import ar.edu.utn.frba.tadp.auxiliomecanico.manipulartiempo.Excepciones.*;
/**
 * La idea de la clase tiempo es poder manejar horas y minutos de manera independiente, y si el dia de
 * mañana se encuentra una solucion mejor para la manipulacion del tiempo se puede solo cambiar la clase
 * ademas se evita entrar en un "primitive obseccion"
 * 
 * @author Nico
 *
 */
public class Tiempo {

private int horas;
private int minutos;

public Tiempo nuevoTiempo ( int hora, int minuto){
	Tiempo tiempoCreado = new Tiempo();
	
		tiempoCreado.setMinutos(minuto);
		tiempoCreado.setHoras(hora);
			
return tiempoCreado;
}

public int getHoras() {
	return horas;
}

public void setHoras(int hora) {
	if ( (hora<0) ){
		this.horas = 0;
		this.minutos = 0;
		throw new HorasIncorrectasException("La cantidad de horas es incorrecta");
	}
	this.horas += hora;
}

public int getMinutos() {
	return minutos;
}

public void setMinutos(int minuto) {
	if (  (minuto<0) ){
		this.horas = 0;
		this.minutos = 0;
		throw new MinutosIncorrectosException("La cantidad de minutos es incorrecta"); 
	}
	if ( minuto>60 ){
		horas += (minuto / 60);
		minutos = (( minuto % 60));
	}else if (minuto==60){
		minutos=0;
		horas += 1;
	}else{
	this.minutos = minuto;
	}
}

public static Tiempo sumarTiempos(Tiempo primerTiempo, Tiempo sumando) {
	int minutos=0;
	int minutosInt=0;
	int horas=0;
	Tiempo tiempoDeRetorno= new Tiempo();
	//Primero sumamos los minutos teniendo en cuenta el overflow de los mismos
	minutos = primerTiempo.minutos + sumando.minutos;
	if ( minutos>60 ){
		minutosInt = ((minutos % 60));
		horas = (minutos / 60);
	}else if (minutos==60){
		minutos =0;
		horas = 1;
	}else{
		minutosInt= minutos;
	}
	//procedemos a sumar las horas
	horas += primerTiempo.horas + sumando.horas ; 
	
return tiempoDeRetorno.nuevoTiempo(horas, minutosInt);
}

public static Tiempo multiplicarTiempo(Tiempo primerTiempo,int scalar) {
	int minutos=0;
	int minutosInt=0;
	int horas=0;
	Tiempo tiempoDeRetorno= new Tiempo();
	//Primero sumamos los minutos teniendo en cuenta el overflow de los mismos
	minutos = primerTiempo.minutos * scalar ;
	if ( minutos>60 ){
		minutosInt = ((minutos % 60));
		horas = (minutos / 60);
	}else if (minutos==60){
		minutos =0;
		horas = 1;
	}else{
		minutosInt= minutos ;
	}
	//procedemos a sumar las horas
	horas += primerTiempo.horas * scalar ; 
	
return tiempoDeRetorno.nuevoTiempo(horas, minutosInt);
}

public int aMinutos(){
int minutosTotales=0;
	minutosTotales=(horas*60)+minutos;
return minutosTotales;
}

public double costoPara(double precioServicio) {
int minutos=this.aMinutos();

return (precioServicio*minutos);
}

public static boolean sonTiemposIguales(Tiempo t1, Tiempo t2){
	return ((t1.horas==t2.horas)&& (t1.minutos == t2.minutos)); 
}

}

