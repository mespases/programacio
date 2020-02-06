import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class PRU04E05ParkingTest_Miki_Espases {
	public static void main(String[] args) {
			// Realizamos las instancias de las clases a utilizar
			PRU04E05Parking_Miki_Espases park=new PRU04E05Parking_Miki_Espases(100, 5);
			Scanner sc=new Scanner(System.in);
			String nl=System.getProperty("line.separator");
			String matricula;
			int opcion;
			
			System.out.println("Menu:" + nl + "1=Leer matricula de un fichero, 2=Entrar Coche, 3=Entra Coche Discapacitado, 4=Salir Coche" + nl 
					+ "5=Salir Coche Discapacitado, 6=Guardar lista de matriculas, 7=Salir del menu");
				opcion=sc.nextInt();	
				do {
					switch (opcion) {
					case 1:
						try {
							park.llegirMatricules(args[0]);
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 2:
						try {
							System.out.println(park.entraCotxe("AAA"));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						break;
					case 3:
						try {
							System.out.println(park.entraCotxeDiscapacitat("AAA"));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 4:
						try {
							park.surtCotxe("AAA");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 5:
						try {
							park.surtCotxeDiscapacitats("AAA");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 6:
						
						break;
					case 7:
						System.out.println("Saliendo del menu");
						break;
					default:
						System.out.println("Opcion del menu introducida, erronea");
						break;			
					}
					// Pide otra vez la opcion del menu
					opcion=sc.nextInt();
				} while(opcion!=7);
				
			
	}
}