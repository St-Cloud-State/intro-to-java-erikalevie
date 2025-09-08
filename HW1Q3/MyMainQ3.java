import java.io.*;           // for InputStream, OutputStream, FileInputStream
import java.util.Scanner;   // for user input

public class MyMainQ3 {
    public static void main(String[] args) throws Exception {
        // make a new PersonList object
        PersonList pl = new PersonList();

        Scanner kb = new Scanner(System.in);
        System.out.print("Enter input filename: ");
        String file = kb.nextLine();

        // read from the file into the PersonList
        try (InputStream in = new FileInputStream(file)) {
            pl.store(in);
        }

        // show all people
        System.out.println("\nAll people:");
        pl.display(System.out);

        // test the find method a few times with ids that are in the file
        System.out.println("\nTesting find:");
        System.out.println("find A101 -> " + pl.find("A101"));  // index 0
        System.out.println("find A103 -> " + pl.find("A103"));  // index 2
        System.out.println("find A105 -> " + pl.find("A105"));  // index 4
    }
}