import java.util.ArrayList;
import java.util.List;

/**
 * Created by nils on 2017-09-21.
 */

public class PersonPrint {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        for (int i=0; i < 15; i++) {
            personList.add(new Person());
        }

        for (Person p : personList) {
            System.out.println(p);
        }
    }
}
