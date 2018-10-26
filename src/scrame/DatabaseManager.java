package scrame;

import java.io.*;
import java.util.*;

public class DatabaseManager {

	public static void write(Object o, String fileName) {

		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList read(String fileName) {
		ArrayList o = new ArrayList();
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			o = (ArrayList<?>) ois.readObject();
			ois.close();
		} catch (IOException ex) {
		} catch (ClassNotFoundException ex) {
		}
		return o;
	}
	
//	public static void saveStudent(ArrayList<Student> studentList) {
//
//		try {
//			FileOutputStream fos = new FileOutputStream("data/Students.txt");
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			oos.writeObject(studentList);
//			oos.close();
//			fos.close();
////	        System.out.printf("Serialized data is saved in /tmp/employee.ser");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static ArrayList<Student> readStudent() {
//		ArrayList<Student> studentList = new ArrayList<Student>();
//		try {
//			FileInputStream fis = new FileInputStream("data/Students.txt");
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			studentList = (ArrayList<Student>) ois.readObject();
//			ois.close();
//		} catch (IOException ex) {
//		} catch (ClassNotFoundException ex) {
//		}
//		// print out the size
//		// System.out.println(" Details Size: " + pDetails.size());
//		// System.out.println();
//		return studentList;
//	}

}
