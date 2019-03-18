package Esylect;
// Imports necesarios para el codigo
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class todo {

	public static void main(String[] args) {
		String par="";
		String impar="";
		try {
			// Variables de escritura y lectura
			BufferedReader br_par=new BufferedReader(new FileReader("C:\\temp\\parell.dat"));
			BufferedReader br_impar=new BufferedReader(new FileReader("C:\\temp\\senars.dat"));
			BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\temp\\tot.dat"));
			// salto de linea
			String nl=System.getProperty("line.separator");
				// Bucle que va a leer y escribir
				for(int i=0; i<=500;i=i+2) {
					par=br_par.readLine();
					impar=br_impar.readLine();
					
					bw.write(par + nl);
					// Si i vale 500 se saltara esta linea
					if (impar!=null) {
						bw.write(impar + nl);
					}
					
				}
			// Cerramos las variables 
			bw.close();
			br_par.close();
			br_impar.close();
			
			// Indicamos que todo ha salido correctamente
			System.out.println("Operacion realizada con exito.");
		}
		// Si algo falla lanzamos una de las Exception
		catch (FileNotFoundException e) {
			System.out.println("No trobat");
		}
		catch (IOException e) {
			System.out.println("No es pot obrir");
		}

	}

}
