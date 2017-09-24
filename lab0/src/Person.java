/**
 * Created by nils on 2017-09-21.
 */

public class Person {

    private String name;
    private int age;
    private static String[] nameArray = {  "Nils",
            "Ben",
            "Oscar",
            "Veronica",
            "Diba",
            "Gabriella",
            "Ted",
            "Maximillian",
            "Hedvig",
            "Evelina" };

    Person() {
        this.name = nameArray[(int) (Math.random() * nameArray.length)];
        this.age = (int) (Math.random() * (100 - 15)) + 15;

    }


    Person(String nameIn, int ageIn) {
        this.name = nameIn;
        this.age = ageIn;
    }


    @Override
    public String toString() {
        return "namn: " + this.getName() + ", " +
                "ålder: " + this.getAge() + " years";
    }


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

}
