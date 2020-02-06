package pru03.PRU03EX01;
import java.util.Scanner;
import pru03.PRU03EX01.AlumneReal.Modul_Matricula;

public class PRU03EX01_miki_espases {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		// Creacion de las dos instancias
		AlumneReal alumne1=new AlumneReal("Pere");
		AlumneReal alumne2=new AlumneReal("Joan");
			// Matriculamos a los alumnos en las asignaturas
				// Matriculamos al alumno 1
				try {
					alumne1.matricularModul("Programacio");
					alumne1.matricularModul("Llenguatge de marques");
				} catch (Exception e) {
					e.printStackTrace();
				}
				// Matriculamos al alumno 2
				try {
					alumne2.matricularModul("Programacio");
					alumne2.matricularModul("Llenguatge de marques");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			// Aqui haremos los examenes de los alumnos
				// Examens alumne1
				try {
					System.out.println(alumne1.nom + " ha sacado un " + alumne1.ferExamen("Programacio") + ", de programacion");
					System.out.println(alumne1.nom + " ha sacado un " + alumne1.ferExamen("Llenguatge de marques") + ", de Llenguatge de marques");
				} catch (Exception e) {
					e.printStackTrace();
				}
				// Examens alumne2
				try {
					System.out.println(alumne2.nom + " ha sacado un " + alumne2.ferExamen("Programacio") + ", de programacion");
					System.out.println(alumne2.nom + " ha sacado un " + alumne2.ferExamen("Llenguatge de marques") + ", de Llenguatge de marques");
				} catch (Exception e) {
					e.printStackTrace();
				}
					
	}

}
