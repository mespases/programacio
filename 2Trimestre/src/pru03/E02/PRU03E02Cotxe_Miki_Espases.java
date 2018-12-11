package pru03.E02;

public class PRU03E02Cotxe_Miki_Espases extends CotxeAbstracte implements InterfaceCotxe {

	EstatsMotorCotxe motor=EstatsMotorCotxe.Aturat;
	
	public PRU03E02Cotxe_Miki_Espases(String marca, String model, TipusCanvi tipuscanvi) {
		super(marca, model, tipuscanvi);
			this.marca=marca;
			this.model=model;
			this.tipuscanvi=tipuscanvi;
	}

	@Override
	public void arrancarMotor() throws Exception {
		
		if (motor.equals(EstatsMotorCotxe.Aturat)) {
			motor=EstatsMotorCotxe.EnMarxa;
		} 
		else {
			throw new Exception ("No me puedes encender, porque ya estoy encendido");
		}	
	}

	@Override
	public EstatsMotorCotxe comprovaMotor() {
		if (motor.equals(EstatsMotorCotxe.Aturat)) {
			return motor;
		} else {
			return motor;
		}
	}

	@Override
	public int getRevolucions() {
		if (motor.equals(EstatsMotorCotxe.Aturat)) {
			return 0;
		} else {
			return (int)(Math.random()*6500)+1;
		}
	}

	@Override
	public void aturarMotor() throws Exception {
		if (motor.equals(EstatsMotorCotxe.EnMarxa)) {
			motor=EstatsMotorCotxe.Aturat;
		} else {
			throw new Exception ("Ya estoy apagado, no me puedes apagar.");
		}
		
	}
}