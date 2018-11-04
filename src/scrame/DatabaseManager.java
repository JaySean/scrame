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
}
