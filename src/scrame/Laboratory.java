package scrame;

public class Laboratory extends Session{

	private int vacancy;
	
	public Laboratory(int vacancy) {
		this.vacancy = vacancy;
	}

	@Override
	public int getVacancy() {
		return vacancy;
	}

	
}
