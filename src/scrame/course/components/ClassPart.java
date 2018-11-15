package scrame.course.components;

import scrame.course.components.Components;

public class ClassPart extends Components {

	private static final long serialVersionUID = 1L;
	public ClassPart(int percentage) {
		super(percentage);
	}
	
	public String getType() {
		return "Class Part";
	}
}
