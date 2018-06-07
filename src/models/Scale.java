package models;

import java.util.Arrays;

public class Scale {

	private String selectedScale;
	private final static int SCALE_LENGTH = 5;
	private int[] selectedScaleNotes;

	private final static int A = 440;
	private final static int A_SHARP = 466;
	private final static int B = 493;
	private final static int C = 523;
	private final static int C_SHARP = 554;
	private final static int D = 587;
	private final static int D_SHARP = 622;
	private final static int E = 659;
	private final static int F = 698;
	private final static int F_SHARP = 739;
	private final static int G = 783;
	private final static int G_SHARP = 830;
	
	//Pentatonische toonladders

	private final static int[] A_SCALE = { A, C, D, E, G};
	private final static int[] B_SCALE = { B, D, E, F_SHARP, A };
	private final static int[] C_SCALE = { C, D_SHARP, F, G, A_SHARP };
	private final static int[] D_SCALE = { D, F, G, A, C };
	private final static int[] E_SCALE = { E, G, A, B, D };
	private final static int[] F_SCALE = { F, G_SHARP, A_SHARP, C, D_SHARP };
	private final static int[] G_SCALE = { G, A_SHARP, C, D, F };

	// Constructor: vul selectedScaleNotes met de noten van gegeven toonladder
	public Scale(String selectedScale) {
		super();
		this.selectedScale = selectedScale;
		this.selectScale();
	}
	
	// get selectedScaleNotes
	public int[] getSelectedScaleNotes() {
		return selectedScaleNotes;
	}

	// Methode: kopieert de juiste scale naar de selectedScaleNotes
	private void selectScale() {

		switch (this.selectedScale) {
		case "a":
			selectedScaleNotes = Arrays.copyOf(A_SCALE, SCALE_LENGTH);
			break;
		case "b":
			selectedScaleNotes = Arrays.copyOf(B_SCALE, SCALE_LENGTH);
			break;
		case "c":
			selectedScaleNotes = Arrays.copyOf(C_SCALE, SCALE_LENGTH);
			break;
		case "d":
			selectedScaleNotes = Arrays.copyOf(D_SCALE, SCALE_LENGTH);
			break;
		case "e":
			selectedScaleNotes = Arrays.copyOf(E_SCALE, SCALE_LENGTH);
			break;
		case "f":
			selectedScaleNotes = Arrays.copyOf(F_SCALE, SCALE_LENGTH);
			break;
		case "g":
			selectedScaleNotes = Arrays.copyOf(G_SCALE, SCALE_LENGTH);
			break;
		default:
			selectedScaleNotes = Arrays.copyOf(C_SCALE, SCALE_LENGTH);
		}
	}
}
