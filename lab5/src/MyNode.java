import javax.swing.tree.DefaultMutableTreeNode;

public class MyNode extends DefaultMutableTreeNode{

    String level;
    String attr;

    public MyNode(String level, String attr) {
        super(level);
        this.level = level;
        this.attr = attr;
    }

}
