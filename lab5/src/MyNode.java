import javax.swing.tree.DefaultMutableTreeNode;

public class MyNode extends DefaultMutableTreeNode{

    String level;
    String value;

    public MyNode(String level, String value) {
        super();
        this.level = level;
        this.value = value;
    }

}
