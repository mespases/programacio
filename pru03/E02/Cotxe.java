package pru03.E02;

public class Cotxe {

	public static void main(String[] args) throws Exception {
		PRU03E02Cotxe_Miki_Espases a=new PRU03E02Cotxe_Miki_Espases("BMW", "Serie 1", TipusCanvi.CanviManual);
		
		a.arrancarMotor();
		System.out.println("El motor esta " + a.comprovaMotor());
		System.out.println("Las revoluciones del motor son " + a.getRevolucions());
		a.aturarMotor();
		System.out.println(a.comprovaMotor());
		System.out.println("Las revoluciones del motor son " + a.getRevolucions());
		
		
	}
}