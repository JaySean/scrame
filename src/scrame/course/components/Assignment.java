package scrame.course.components;

import scrame.course.components.Components;

public class Assignment extends Components {

	private static final long serialVersionUID = 1L;
	
	public Assignment(int percentage) {
		super(percentage);
	}
	
	public String getType() {
		return "Assignment";
	}
}
