package Esylect;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Senar {

	public static void main(String[] args) {
		String numero="";
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\temp\\senars.dat"));
			String nl=System.getProperty("line.separator");
				for (int i=1; i<500;i=i+2) {
					numero=String.valueOf(i);
					bw.write(numero + nl);
					System.out.println();
				}
			bw.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("No trobat");
		}
		catch (IOException e) {
			System.out.println("No es pot obrir");
		}

	}

}
