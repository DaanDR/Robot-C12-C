package hardware;

import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;

public class Engineblock {

	UnregulatedMotor motorA; // motor voor linker(?) wiel
	UnregulatedMotor motorB; // motor voor rechter(?) wiel
	UnregulatedMotor motorC; // motor voor grijparmen
	ColorSensor color; // color sensor
	EV3IRSensor ir; // infrared sensor
	
	public Engineblock() {
		super();
	}

	public void startEngines() {
		motorA = new UnregulatedMotor(MotorPort.A);
		motorB = new UnregulatedMotor(MotorPort.B);
		motorC = new UnregulatedMotor(MotorPort.C);
		color = new ColorSensor(SensorPort.S4);
		ir = new EV3IRSensor(SensorPort.S3);
	}

	public UnregulatedMotor getMotorA() {
		return motorA;
	}

	public UnregulatedMotor getMotorB() {
		return motorB;
	}

	public UnregulatedMotor getMotorC() {
		return motorC;
	}

	public ColorSensor getColor() {
		return color;
	}

	public EV3IRSensor getIr() {
		return ir;
	}

	public void closeEngines() {
		motorA.close();
		motorB.close();
		motorC.close();
		color.close();
		ir.close();
	}
	
	
	
	

}
