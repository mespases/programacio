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
	private int places_discapacitats;
	private String matricula;
	
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
	
	public void llegirMatricules(String path) throws Exception {
		this.InicializarVariablesLectura(path);
		matricula=br.readLine();
	}
	
	public int entraCotxe(String matricula) throws Exception {
		return places_no_discapacitats;
	}
	
	public int entraCotxeDiscapacitat(String matricula) throws Exception {
		return places_discapacitats;
	}
	
	public void surtCotxe(String matircula) throws Exception {
		
	}
	
	public void surtCotxeDiscapacitats(String matircula) throws Exception {
		
	}
	
	public int getPlacesOcupades(TipusPlacesParking tipus) {
		return (Integer) null;
	}
	
	public int getPlacesLliures(TipusPlacesParking tupus) {
		return (Integer) null;
	}
	
	public void guardarMatricules(String path) throws Exception {
		this.InizializarVariableEscritura(path);
	}
}