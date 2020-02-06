package pru03.E02;

public class PRU03E02Cotxe_CamviMarcha_Miki_Espases extends PRU03E02Cotxe_Miki_Espases implements InterfaceCotxe  {

	public PRU03E02Cotxe_CamviMarcha_Miki_Espases(String marca, String model, TipusCanvi tipuscanvi) {
		super(marca, model, tipuscanvi);
		this.marca=marca;
		this.model=model;
		this.tipuscanvi=tipuscanvi;
	}
	public enum MarxaAutomatic {
		F,N,R;
	}
	public MarxaAutomatic CanviarMarxaAutomatic(int cambiar) throws Exception{
		MarxaAutomatic marxa=MarxaAutomatic.N;
		if (motor.equals(EstatsMotorCotxe.EnMarxa)) {
			if (marxa.equals(MarxaAutomatic.N)) {
				if (cambiar==1) {
					marxa=MarxaAutomatic.F;
				} 
				else if (cambiar==2) {
					marxa=MarxaAutomatic.R;
				}	
			}
			if (marxa.equals(MarxaAutomatic.R)) {
				if (cambiar==0) {
					marxa=MarxaAutomatic.N;
				}
			}
			if (marxa.equals(MarxaAutomatic.F)) {
				if (cambiar==0) {
					marxa=MarxaAutomatic.N;
				}
				
			}
			return marxa;
		}
		else {
			throw new Exception ("No sirve de nada cambiar de marcha si el cohe esta apagado");
		}	
	}
	
	
	public enum MarxaManual {
		primera,segona,tercera,quarta,cinquena,sisena, R;
	}
	
	public MarxaManual CanviarMarxaManual(int cambiar) throws Exception {
		MarxaManual marxa=MarxaManual.primera;
		if (motor.equals(EstatsMotorCotxe.EnMarxa)) {
			if (marxa.equals(MarxaManual.primera)) {
			
				if (cambiar==1) {
					marxa=MarxaManual.segona;
				}
				else if (cambiar==0) {
					marxa=MarxaManual.R;
				}
			}
				
			}		
		else {
			throw new Exception ("No sirve de nada cambiar de marcha si el cohe esta apagado");
		}
		return marxa;
	}



public static void main(String[] args) throws Exception {
	PRU03E02Cotxe_CamviMarcha_Miki_Espases a=new PRU03E02Cotxe_CamviMarcha_Miki_Espases("BMW", "Serie 1", TipusCanvi.CanviAutomatic);
	a.arrancarMotor();
	System.out.println(a.CanviarMarxaAutomatic(1));

}}
