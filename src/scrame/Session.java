package scrame;

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
			if (studentList[i].isEmpty() == true) { // or isBlank?
				vacancy++;
			}
		}
		return vacancy;
	}

	public void addStudent(String studentName) {
//		boolean set = false;
//		for (int i = 0; i < getVacancy(); i++) {
//			if (studentList[i].isEmpty() == false) {
//				studentList[i] = studentName;
//				set = true;
//				System.out.println("Student successfully registered");
//			}
//		}
//		if (set == false) {
//			System.out.println("No vacancies, student not registerd");
//		}
		if (getVacancy() == 0) {
			System.out.println("No vacancies, student not registerd");
		} else {
			studentList[0] = studentName;
			System.out.println("Student successfully registered");
		}
	}
	
	public String[] getStudentList() {
		return studentList;
	}
	
	public void setStudentList(String[] studentList) {
		this.studentList = studentList;
	}
}
