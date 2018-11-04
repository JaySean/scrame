package scrame;

public class Assignment extends Components {

	private static final long serialVersionUID = 1L;
	
	public Assignment(int percentage) {
		super(percentage);
	}
	
	public String getType() {
		return "Assignment";
	}
}
