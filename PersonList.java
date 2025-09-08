import java.io.*;
import java.util.*;

public class PersonList {
    private LinkedList<Person> list;

    // constructor makes an empty list
    public PersonList() {
        list = new LinkedList<>();
    }

    // store: reads people from input and adds them to the list
    public void store(InputStream in) {
        Scanner sc = new Scanner(in);
        while (sc.hasNext()) {
            String id = sc.next();
            String first = sc.next();
            String last = sc.next();
            list.add(new Person(first, last, id));
        }
    }

    // display: writes all people to output stream
    public void display(OutputStream out) throws IOException {
        for (Person p : list) {
            String line = p.toString() + "\n";
            out.write(line.getBytes());
        }
    }

    // find: returns index of the person with matching id, or -1
    public int find(String sid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }

    // getter for size (not required but useful sometimes)
    public int size() {
        return list.size();
    }
}