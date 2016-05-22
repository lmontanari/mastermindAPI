package com.vanhackathon.mastermind.domain;

/**
 * All colors possible.
 * 
 * @author lmontanari (lucas_montanari@hotmail.com)
 */
public enum Colors {

	RED("R"), BLUE("B"), GREEN("G"), YELLOW("Y"), PURPLE("P"), ORANGE("O"), CYAN("C"), MAGENTA("M");

	private String color;

	Colors(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public static String getColorValues() {
		Colors[] values = values();
		String v = "";
		for (int i = 0; i < values.length; i++) {
			Colors colors = values[i];
			v += colors.getColor();
		}
		return v;
	}

	/**
	 * Get color using its first letter.
	 * 
	 * @param c
	 *            Char as First letter.
	 * @return Colors. Null when not found.
	 */
	public static Colors getColorByChar(char c) {
		Colors[] values = values();
		for (int i = 0; i < values.length; i++) {
			Colors currentColor = values[i];
			if (String.valueOf(c).equals(currentColor.getColor())) {
				return currentColor;
			}
		}
		return null;
	}
}
