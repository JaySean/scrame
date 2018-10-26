package scrame;

public class Lecture extends Session{

	private int vacancy;
	
	public Lecture(int vacancy) {
		this.vacancy = vacancy;
	}
	
	@Override
	public int getVacancy() {
		return vacancy;
	}

}
