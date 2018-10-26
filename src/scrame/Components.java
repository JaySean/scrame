package scrame;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Components implements Serializable{

	private static final long serialVersionUID = 1L;
	private int percentage;
	private ArrayList<MarksRecord> record;
	
	public Components(int percentage) {
		this.percentage = percentage;
	}
	
}
