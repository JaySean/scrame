package scrame.course.sessions;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Session implements Serializable {

	private static final long serialVersionUID = 1L;
	protected int capacity;
	protected int vacancy;
	public String[] studentList = new String[capacity];

	public int getVacancy() {
		return vacancy;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	public int countVacancy() {
		int vacancy = 0;
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i].isEmpty()) { // or isBlank?
				vacancy++;
			}
		}
		return vacancy;
	}
	
	public String[] getStudentList() {
		return studentList;
	}
	
	public void setStudentList(String[] studentList) {
		this.studentList = studentList;
	}

	public void addStudent(String studentMatric) {
		studentList[capacity - vacancy] = studentMatric;
		vacancy--;
	}

	public boolean hasStudent(String studentMatric) {
		for (String student : studentList) {
			if (student.equals(studentMatric)) return true;
		}
		return false;
	}
}
