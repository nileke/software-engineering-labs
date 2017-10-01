/**
 * Created by nils on 2017-09-21.
 */

public class Student extends Person {
    private int year;

    Student(String nameIn, int ageIn, int yearIn) {
        super(nameIn, ageIn);
        this.year = yearIn;
    }

    Student() {
        super();
        this.year = (int) (Math.random() * (2016-1934) + 1934);
    }

    @Override
    public String toString() {
        return super.toString() + "," +
                "började på CMETE: " + this.getYear();
    }

    int getYear() {
        return year;
    }
}
