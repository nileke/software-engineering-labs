package Composite;

import java.util.ArrayList;

public class Composite extends Component {

    private String name;
    private double weight;
    private ArrayList<Component> children = new ArrayList<Component>();
    private String content;

    Composite(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    Composite(String name) {
        this.name = name;
    }

    @Override
    protected double getWeight() {
        double totalWeight = weight;
        for (Component child : children) {
            totalWeight += child.getWeight();
        }
        return totalWeight;
    }

    @Override
    public String toString() {
         StringBuilder str = new StringBuilder(this.name + ":");
         for (Component child : children) {
             str.append(String.join("", " " + child.toString()));
        } return str.toString();
    }

    void addChild(Component child) {
        children.add(child);
    }

    void removeChild(Component child) {
        children.remove(child);
    }

}
