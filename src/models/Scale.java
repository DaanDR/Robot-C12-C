package models;

import java.util.Arrays;

public class Scale {

	private String selectedScale;
	private final static int SCALE_LENGTH = 7;
	private final static int PENTASCALE_LENGTH = 5;	
	private final static int SEVENNATIONSCALE_LENGTH = 5;
	private int[] selectedScaleNotes;

	private final static int A = 440;
	private final static int A_SHARP = 466;
	private final static int B = 494;
	private final static int C = 523;
	private final static int C_SHARP = 554;
	private final static int D = 587;
	private final static int D_SHARP = 622;
	private final static int E = 659;
	private final static int F = 698;
	private final static int F_SHARP = 740;
	private final static int G = 784;
	private final static int G_SHARP = 831;
	private final static int A_HOOG = 880;
	private final static int B_HOOG = 988;
	
	// Toonladders
	private final static int[] C_SCALE = { C, D, E, F, G, A_HOOG, B_HOOG };
	private final static int[] D_SCALE = { D, E, F_SHARP, G, A, B, C_SHARP };
	private final static int[] E_SCALE = { E, F_SHARP, G_SHARP, A, B, C_SHARP, D_SHARP };
	private final static int[] F_SCALE = { F, G, A, A_SHARP, C, D, E};
	private final static int[] G_SCALE = { G, A, B, C, D, E, F_SHARP };
	private final static int[] A_SCALE = { A, B, C_SHARP, D, E, F_SHARP, G_SHARP};
	private final static int[] B_SCALE = { B, C_SHARP, D_SHARP, E, F_SHARP, G_SHARP, A_SHARP };
	
	//Pentatonische toonladders

	private final static int[] A_PENTASCALE = { A, C, D, E, G};
	private final static int[] B_PENTASCALE = { B, D, E, F_SHARP, A };
	private final static int[] C_PENTASCALE = { C, D_SHARP, F, G, A_SHARP };
	private final static int[] D_PENTASCALE = { D, F, G, A, C };
	private final static int[] E_PENTASCALE = { E, G, A, B, D };
	private final static int[] F_PENTASCALE = { F, G_SHARP, A_SHARP, C, D_SHARP };
	private final static int[] G_PENTASCALE = { G, A_SHARP, C, D, F };
	
	// Custom
	// SevenNation scale FKEY _ B-C-D-E-G
	private final static int[] SEVENNATIONSCALE = { B, C, D, E, G };
	

	// Constructor: vul selectedScaleNotes met de noten van gegeven toonladder
	public Scale(String selectedScale) {
		super();
		this.selectedScale = selectedScale;
		this.selectScale();
	}
	
	// Constructor default c
	public Scale () {
		this("c");
		
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
		case "ap":
			selectedScaleNotes = Arrays.copyOf(A_PENTASCALE, PENTASCALE_LENGTH);
			break;
		case "bp":
			selectedScaleNotes = Arrays.copyOf(B_PENTASCALE, PENTASCALE_LENGTH);
			break;
		case "cp":
			selectedScaleNotes = Arrays.copyOf(C_PENTASCALE, PENTASCALE_LENGTH);
			break;
		case "dp":
			selectedScaleNotes = Arrays.copyOf(D_PENTASCALE, PENTASCALE_LENGTH);
			break;
		case "ep":
			selectedScaleNotes = Arrays.copyOf(E_PENTASCALE, PENTASCALE_LENGTH);
			break;
		case "fp":
			selectedScaleNotes = Arrays.copyOf(F_PENTASCALE, PENTASCALE_LENGTH);
			break;
		case "gp":
			selectedScaleNotes = Arrays.copyOf(G_PENTASCALE, PENTASCALE_LENGTH);
			break;
		case "sevennation":
			selectedScaleNotes = Arrays.copyOf(SEVENNATIONSCALE, SEVENNATIONSCALE_LENGTH);
			break;
		default:
			selectedScaleNotes = Arrays.copyOf(C_SCALE, SCALE_LENGTH);
		}
	}
}
