package scrame;

import java.io.*;
import java.util.*;

/**
 * Retrieves and stores data from a serialised text file
 *
 * @author CZ2002 SS3 Group 1
 * @version 1.0
 */

public class DatabaseManager {

    /**
     * Retrieves data from the file and stores it in an array list
     *
     * @param fileName .txt file where the data is stored
     * @return An array list of data from the file
     */
    public static ArrayList read(String fileName) {
        ArrayList o = new ArrayList();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            o = (ArrayList<?>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return o;
    }

    /**
     * Stores the content of the array list object into the file
     *
     * @param o        Array lists to be stored
     * @param fileName .txt file where the data is stored
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
