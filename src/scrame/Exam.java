package scrame;

public class Exam extends Components{

	private static final long serialVersionUID = 1L;
	
	private String type = "Exam";
	
	public Exam(int percentage) {
		super(percentage);
	}

	public String getType() {
		return type;
	}
	
}
