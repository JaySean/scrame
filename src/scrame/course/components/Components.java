package scrame.course.components;

import java.io.Serializable;

public abstract class Components implements Serializable{

	private static final long serialVersionUID = 1L;
	private int percentage;
	
	public Components(int percentage) {
		this.percentage = percentage;
	}
	
	public int getPercentage() {
		return percentage;
	}
	
}
