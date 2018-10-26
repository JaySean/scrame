package scrame;

public abstract class Session {

	private int vacancy;
	public String[] studentList = new String[vacancy];
	
	public int getVacancy() {
		return vacancy;
	}
	
	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}
	
	public int countVacancy() {
		int vacancy = 0;
		for (int i=0; i<studentList.length; i++) {
			if (studentList[i].isEmpty() == true) { //or isBlank?
				vacancy++;
			}
		}
		return vacancy;
	}
	
	public void addStudent(String student) {
		boolean set = false;
		for (int i = 0; i < getVacancy(); i++) {
			if (studentList[i].isEmpty() == false) {
				studentList[i] = student;
				set = true;
				System.out.println("Student successfully registered");
			}
		}
		if (set == false) {
			System.out.println("No vacancies, student not registerd");
		}
	}
}
