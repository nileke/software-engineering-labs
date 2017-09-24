import java.util.ArrayList;
import java.util.List;

/**
 * Created by nils on 2017-09-21.
 */
public class PrintStudent {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        for (int i=0; i < 5; i++) {
            personList.add(new Student());
            personList.add(new Person());
        }

        for (Person p : personList) {
            System.out.println(p);
        }
    }

}
