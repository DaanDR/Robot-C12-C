package hardware;

import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;

public class Engineblock {

	private UnregulatedMotor motorA; // motor for driving
	private UnregulatedMotor motorB; // motor for driving
	private UnregulatedMotor motorC; // motor for arms
	private ColorSensor color; // color sensor
	private EV3IRSensor ir; // infrared sensor
	
	public Engineblock() {
		super();
	}

	// Method start engines
	public void startEngines() {
		motorA = new UnregulatedMotor(MotorPort.A);
		motorB = new UnregulatedMotor(MotorPort.B);
		motorC = new UnregulatedMotor(MotorPort.C);
		color = new ColorSensor(SensorPort.S4);
		ir = new EV3IRSensor(SensorPort.S3);
	}

	// Getters
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

	// Method close engines
	public void closeEngines() {
		motorA.close();
		motorB.close();
		motorC.close();
		color.close();
		ir.close();
	}
	
}
