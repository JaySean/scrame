package scrame;

public class Exam extends Components{

	private static final long serialVersionUID = 1L;
	
	public Exam(int percentage) {
		super(percentage);
	}

	public String getType() {
		return "Exam";
	}
	
}
