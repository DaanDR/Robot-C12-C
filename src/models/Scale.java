package models;

import java.util.Arrays;
import java.util.HashMap;

public class Scale {

	private String selectedScale;
	private int[] selectedScaleNotes;
	private final static HashMap<String, int[]> SCALES = new HashMap<String, int[]>();
	

	// Tones
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

	// Scales
	private final static int[] C_SCALE = { C, D, E, F, G, A_HOOG, B_HOOG };
	private final static int[] D_SCALE = { D, E, F_SHARP, G, A, B, C_SHARP };
	private final static int[] E_SCALE = { E, F_SHARP, G_SHARP, A, B, C_SHARP, D_SHARP };
	private final static int[] F_SCALE = { F, G, A, A_SHARP, C, D, E };
	private final static int[] G_SCALE = { G, A, B, C, D, E, F_SHARP };
	private final static int[] A_SCALE = { A, B, C_SHARP, D, E, F_SHARP, G_SHARP };
	private final static int[] B_SCALE = { B, C_SHARP, D_SHARP, E, F_SHARP, G_SHARP, A_SHARP };
	

	// Pentatonic scales
	private final static int[] A_PENTASCALE = { A, C, D, E, G };
	private final static int[] B_PENTASCALE = { B, D, E, F_SHARP, A };
	private final static int[] C_PENTASCALE = { C, D_SHARP, F, G, A_SHARP };
	private final static int[] D_PENTASCALE = { D, F, G, A, C };
	private final static int[] E_PENTASCALE = { E, G, A, B, D };
	private final static int[] F_PENTASCALE = { F, G_SHARP, A_SHARP, C, D_SHARP };
	private final static int[] G_PENTASCALE = { G, A_SHARP, C, D, F };

	// Custom scales
	// SevenNation scale FKEY _ B-C-D-E-G
	private final static int[] SEVENNATIONSCALE = { B, C, D, E, G };

	// Constructor: fill 'selectedScaleNotes' with tones of given scale
	public Scale(String selectedScale) {
		super();
		this.scaleIntoHashMap();
		this.selectedScale = selectedScale;
		this.selectScale();
	}

	// Constructor default c
	public Scale() {
		this("c");

	}
	
	private void scaleIntoHashMap() {
		SCALES.put("c", C_SCALE);
		SCALES.put("d", D_SCALE);
		SCALES.put("e", E_SCALE);
		SCALES.put("f", F_SCALE);
		SCALES.put("g", G_SCALE);
		SCALES.put("a", A_SCALE);
		SCALES.put("b", B_SCALE);
		
		SCALES.put("pc", C_PENTASCALE);
		SCALES.put("pd", D_PENTASCALE);
		SCALES.put("pe", E_PENTASCALE);
		SCALES.put("pf", F_PENTASCALE);
		SCALES.put("pg", G_PENTASCALE);
		SCALES.put("pa", A_PENTASCALE);
		SCALES.put("pb", B_PENTASCALE);
		
		SCALES.put("sevennation", SEVENNATIONSCALE);
	}

	// get selectedScaleNotes
	public int getSelectedScaleNote(int note) {
		return selectedScaleNotes[note % selectedScaleNotes.length];
	}

	// Methode: copy chosen scale to 'selectedScaleNotes'
	private void selectScale() {
		selectedScaleNotes = SCALES.get(selectedScale);	
	}
}
