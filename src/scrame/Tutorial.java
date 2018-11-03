package scrame;

public class Tutorial extends Session{

	private static final long serialVersionUID = 1L;

	public Tutorial(int capacity) {
		this.capacity = capacity;
		this.vacancy = capacity;
		studentList = new String[vacancy];
	}
}
