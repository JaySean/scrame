package scrame;

public class Grade {
	private int mark;

	Grade(int m) {
		mark = m;
	}

	public char getAlpha() {
		char alpha = 'F';
		if (mark >= 30) alpha = 'E';
		if (mark >= 40) alpha = 'D';
		if (mark >= 50) alpha = 'C';
		if (mark >= 60) alpha = 'B';
		if (mark >= 70) alpha = 'A';
		return alpha;
	}

	public int getMarks() {
		return mark;
	}
}
