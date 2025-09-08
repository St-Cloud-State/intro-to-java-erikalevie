import java.io.*;           // for InputStream, OutputStream, FileInputStream
import java.util.*;         // for LinkedList and Scanner

public class MyMain {

    // store: reads from input file and puts people into the linked list
    public static void store(InputStream in, LinkedList<Person> list) {
        Scanner sc = new Scanner(in);
        while (sc.hasNext()) {
            String id = sc.next();
            String first = sc.next();
            String last = sc.next();
            Person p = new Person(first, last, id);
            list.add(p);
        }
    }

    // display: prints out each person to the given output stream
    public static void display(OutputStream out, LinkedList<Person> list) throws IOException {
        for (Person p : list) {
            String line = p.toString() + "\n";
            out.write(line.getBytes());
        }
    }

    // find: looks for a person with the same id, returns index or -1 if not found
    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }

    // main method to test everything
    public static void main(String[] args) throws Exception {
        LinkedList<Person> people = new LinkedList<>();

        Scanner kb = new Scanner(System.in);
        System.out.print("Enter input filename: ");
        String file = kb.nextLine();

        // read data from the file into the list
        try (InputStream in = new FileInputStream(file)) {
            store(in, people);