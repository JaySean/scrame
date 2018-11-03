package scrame;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Components implements Serializable{

	private static final long serialVersionUID = 1L;
	private int percentage;
	private ArrayList<MarksRecord> record = new ArrayList<MarksRecord>();
	protected String type;
	
	public Components(int percentage) {
		this.percentage = percentage;
	}
	
	public abstract String getType();
	
	public int getPercentage() {
		return percentage;
	}

	public ArrayList<MarksRecord> getRecord() {
		return record;
	}

	public void setRecord(ArrayList<MarksRecord> record) {
		this.record = record;
	}
	
}
