package scrame;

import java.io.*;
import java.util.*;

/**
 * Stores and retrieves data from the database
 * @author CZ2002 SS3 Group 1
 * @version 1.0
 */

public class DatabaseManager {
	
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

	/**
	 * method to serialize whatever's in object o and to place it into a .txt file
	 * @param o array lists with stored information
	 * @param fileName .txt file where all the data is stored
	 */
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
}
