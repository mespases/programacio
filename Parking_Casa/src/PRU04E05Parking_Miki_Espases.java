import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PRU04E05Parking_Miki_Espases {
	private BufferedReader br;
	private BufferedWriter bw;
	private int places_no_discapacitats;
	private int places_no_discapacitats_ocupades=0;
	private int places_discapacitats;
	private int places_discapacitats_ocupades=0;
	private String matricula;
	public TipusPlacesParking tupus=TipusPlacesParking.normals;
	
	/**
	 * Constructor de la clase, al cual le vamos a insertar los siguientes variables, 
	 * estas variables las usaremos para saber las plazas de parking, tanto de discapacitados como de no discapacitados
	 * @param places_no_discapacitats 
	 * @param places_discapacitats
	 * 
	 */
	public PRU04E05Parking_Miki_Espases(int places_no_discapacitats, int places_discapacitats) {
		this.places_no_discapacitats=places_no_discapacitats;
		this.places_discapacitats=places_discapacitats;
	}
	
	/**
	 *  Inicializa la variable de lectura con el Buffered 
	 */
	public void InicializarVariablesLectura(String path) {
		try {
			br=new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			System.out.println("No trobat");
		}
		catch (IOException e) {
		System.out.println("No es pot obrir");
		}
		
	}
	
	/**
	 *  Inicializa la variable de escritura con el Buffered 
	 */
	public void InizializarVariableEscritura(String path) {
		try {
			bw=new BufferedWriter(new FileWriter(path));
		} catch (FileNotFoundException e) {
			System.out.println("No trobat");
		}
		catch (IOException e) {
		System.out.println("No es pot obrir");
		}
	}
	
	/**
	 * Lee las matriculas de el fichero introducido
	 * @param Se introduce path
	 * @throws Exception
	 */
	public void llegirMatricules(String path) throws Exception {
		this.InicializarVariablesLectura(path);
		matricula=br.readLine();
	}
	
	/**
	 * Entra un coche de una persona no discapacitada, puede ser un garrulo o no.
	 * @param matricula
	 * @return numero de plazas ocupadas
	 * @throws Exception
	 */
	public int entraCotxe(String matricula) throws Exception {
		// Numero aleatorio para el garrulo
		int garrulo=(int)(Math.random()*49)+1;
		// Comprobamos que haya sitio libre
		if (this.ComprobarSiHayLibres_nodisc()==true) {
			// Si el numero del garrulo es 15, el garrulo intentara buscar una plaza de minusvalido
			if (garrulo==15) {
				// Comporbamos que haya plazas en el lugar de munusvalidos, si la hay, el garrulo aparcara en ella
				if (this.ComprobarSiHayLibres_disc()==true) {
					places_discapacitats_ocupades=places_discapacitats_ocupades+1;
					return places_discapacitats_ocupades;
				// Si las plazas de munusvalidos, estan todas ocupadas, se ira a aparcar a una plaza normal
				} else {
					places_no_discapacitats_ocupades=places_no_discapacitats_ocupades+1;
					return places_no_discapacitats_ocupades;
				}
			} else {
				places_no_discapacitats_ocupades=places_no_discapacitats_ocupades+1;
				return places_no_discapacitats_ocupades;
			}
		// Si no hay sitio libre devolvemos el valor de las plazas ocupadas, sin sumarle nada.
		} else {
			return places_no_discapacitats_ocupades;
		}
	}
	
	/**
	 * Entra un coche de una persona minusvalida
	 * @param matricula
	 * @return numero de plazas de minusvalidos ocupadas
	 * @throws Exception
	 */
	public int entraCotxeDiscapacitat(String matricula) throws Exception {
		// Compruba si hay plazas libres de minusvalidos, si las hay, deja entrar a la persona.
		if (this.ComprobarSiHayLibres_disc()==true) {
			places_discapacitats_ocupades=places_discapacitats_ocupades+1;
			return places_discapacitats_ocupades;
		// En caso de que no haya plazas libres, nos devuelve el total de las plazas ocupadas
		} else {
			return places_discapacitats_ocupades;
		}		
	}
	
	/**
	 * Mira el total de las plazas normales ocupadas y le resta 1, del coche que acaba de salr
	 * @param matircula
	 * @throws Exception
	 */
	public void surtCotxe(String matircula) throws Exception {
		places_no_discapacitats_ocupades=places_no_discapacitats_ocupades-1;
	}
	
	/**
	 * Mira el total de las plazas de minusvalidos ocupadas y le resta 1, del coche que acaba de salir
	 * @param matircula
	 * @throws Exception
	 */
	public void surtCotxeDiscapacitats(String matircula) throws Exception {
		places_discapacitats_ocupades=places_discapacitats_ocupades-1;
	}
	
	public int getPlacesOcupades(TipusPlacesParking tipus) {
		if (tipus.equals(tipus.normals)) {
			return places_no_discapacitats_ocupades;
		} else {
			return places_discapacitats_ocupades;
		}
	}
	
	public int getPlacesLliures(TipusPlacesParking tipus) {
		if (tipus.equals(tipus.normals)) {		
			return places_no_discapacitats-places_no_discapacitats_ocupades;
		} else {
			return places_discapacitats-places_discapacitats_ocupades;
		}
	}
	
	public void guardarMatricules(String path) throws Exception {
		this.InizializarVariableEscritura(path);
	}
	
	/**
	 * Comprueba que las plazas de no discapacitados del parking no esten llenas
	 */
	private boolean ComprobarSiHayLibres_nodisc() {
		if (places_no_discapacitats_ocupades<places_no_discapacitats) {
			return true;
		} else if (places_no_discapacitats_ocupades>places_no_discapacitats) {
			return false;
		} else {
			return false;
		}
	}
	
	/**
	 * Comprobar plazas de discapacitados del parking no esten llenas.
	 * @return
	 */
	private boolean ComprobarSiHayLibres_disc() {
		if (places_discapacitats_ocupades<places_discapacitats) {
			return true;
		} else if(places_discapacitats_ocupades>places_discapacitats) {
			return false;
		} else {
		return false;
		}
	}
	
	// Nos da la matricula leida anterior mente
	public String getMatricula() {
		return matricula;
	}
	
	public enum TipusPlacesParking {
		normals,minusvalids;
	}
}