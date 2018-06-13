package models;

import hardware.ColorSensor;
import hardware.Engineblock;
import hardware.Lcd;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.Color;

public abstract class Trick {

	UnregulatedMotor motorA; // motor voor linker(?) wiel
	UnregulatedMotor motorB; // motor voor rechter(?) wiel
	UnregulatedMotor motorC; // motor voor grijparmen
	ColorSensor color; // color sensor
	EV3IRSensor ir;

	protected final static int FLASH_GREEN = 4;
	protected final static int STANDARD_MOTOR_SPEED = -30;
	protected final static int STANDARD_ARM_STRENGTH = -60;

	// Constructor
	public Trick(Engineblock engineBlock) {
		super();
		this.motorA = engineBlock.getMotorA();
		this.motorB = engineBlock.getMotorB();
		this.motorC = engineBlock.getMotorC();
		this.color = engineBlock.getColor();
		this.ir = engineBlock.getIr();
	}

	/**
	 * Start or stop a program with standard set of actions. Starting a program
	 * waits for any button press to continue.
	 */

	// Start program
	public void startProgram() {
		Lcd.clear();
		Button.LEDPattern(FLASH_GREEN); // flash green led and
		Sound.beepSequenceUp(); // make sound when ready.
		Lcd.print(1, "Press any key to start");
		Button.waitForAnyPress(); // wait for any key press to continue
		Lcd.clear();
	}

	// Stop program
	public void stopProgram() {
		Lcd.clear();
		Lcd.print(2, "- The End -");
		Sound.beepSequence();
	}

	/**
	 * Color Sensor methods
	 */

	// Set color sensor to RED sensor function and sets floodlight to red.
	protected void setColorSensorRed() {
		color.setRedMode();
		color.setFloodLight(Color.RED);
		color.setFloodLight(true);
	}

	// Set color sensor to colorID mode and set floodlight off.
	protected void setColorSensorID() {
		color.setColorIdMode();
		color.setFloodLight(false);
	}

	/**
	 * Driving methods using two motors (A & B) attached to the wheels
	 */

	// Start driving with given speed
	protected void startDriving(int speed) {
		motorA.setPower(speed);
		motorB.setPower(speed);
	}

	// Start driving with standard speed, negative ints for driving forward
	protected void startDriving() {
		motorA.setPower(STANDARD_MOTOR_SPEED);
		motorB.setPower(STANDARD_MOTOR_SPEED);
	}

	// Stop driving
	protected void stopDriving() {
		motorA.setPower(0);
		motorB.setPower(0);
	}

	/**
	 * Move arms methods using one motor (C) attached to the arms
	 * Pos/neg irrelevant, arms move relative to current position
	 */

	// Move arms
	protected void moveArms(int strength) {
		motorC.setPower(strength);
	}

}
