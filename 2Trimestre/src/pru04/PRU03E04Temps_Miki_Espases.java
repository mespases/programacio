package pru04;

public class PRU03E04Temps_Miki_Espases {
	int hora;
	int minutos;
	int segundos;
	
	// Constructor de la clase 
	public PRU03E04Temps_Miki_Espases (int hora, int minutos, int segundos) {
		this.hora=hora;
		this.minutos=minutos;
		this.segundos=segundos;
		
	}

	public int suma(int tiempo) {
		segundos=segundos+tiempo;
		
		return segundos;
	}

	
	public void resta() {
		
	}

}
