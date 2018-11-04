package scrame;

import java.util.ArrayList;

public class AddSession {

	public static ArrayList<Session> add(int courseVacancy, int tutNumber, int labNumber) {
		// Create arraylist of lecture, tutorial and lab
		ArrayList<Session> session = new ArrayList<>(1 + tutNumber + labNumber);
		
		// Create new instance of lecture
		Session lecture = new Lecture(courseVacancy);
		session.add(lecture);

		// Create new instance of tutorial
		for (int i = 1; i < 1 + tutNumber; i++) {
			session.add(new Tutorial((int) (Math.ceil(courseVacancy / tutNumber))));
		}

		// Create new instance of lab
		for (int i = 1; i < 1 + labNumber; i++) {
			session.add(new Laboratory((int) (Math.ceil(courseVacancy / labNumber))));
		}
		
		return session;
	}
}
