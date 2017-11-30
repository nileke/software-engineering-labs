import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DirTree extends TreeFrame {

    private static String directory = "data/";
    private static org.jdom2.Document document;

    void initTree() {
        org.jdom2.Element rootElement = document.getRootElement();

        String rootAttr = rootElement.getText();
        String rootLevel = rootElement.getAttributeValue("namn");

        MyNode root = new MyNode(rootLevel, rootAttr);
        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);
        buildTree(rootElement, root);
    }

    private void buildTree(Element root, MyNode parent) {
        List<Element> children = root.getChildren();
        for (Element e : children) {
            String attr = e.getText();
            String level = e.getAttributeValue("namn");

            MyNode child = new MyNode(level, attr);
            parent.add(child);

            if (e.getChildren() != null) {
                buildTree(e, child);
            }
        }
    }

    void showDetails(TreePath p) {
        if (p == null) { return; }

        MyNode node = (MyNode) p.getLastPathComponent();
        String info = node.getLevelInfo() + " " + node.getAttrInfo();

        if (p.getParentPath() != null) {
            info += "\nMen allt som";
            String parentPath = p.getParentPath().toString();
            String[] arr = parentPath.split(",");
            for (int i = arr.length; i > 0; i--) {
                MyNode n = (MyNode) p.getPathComponent(i);
                info += " ar " + n.getLevelInfo();
            }
            info += " ar Liv";
        }

        JOptionPane.showMessageDialog(this, info);


    }

    public static void main(String[] args) {
        String filepath = directory + "Life.xml";
        if (args.length > 0) {
            filepath = args[0];
        }

        try {
            File inputFile = new File(filepath);
            SAXBuilder saxBuilder = new SAXBuilder();
            document = saxBuilder.build(inputFile);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        }
        new DirTree();
    }
}
