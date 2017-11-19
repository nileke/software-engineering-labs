package Composite;

public class Leaf extends Component {

    private String name;
    private double weight;

    Leaf(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    Leaf(String name) {
        this.name = name;
    }

    @Override
    protected double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.name;    }


}
