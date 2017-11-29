import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DirTree extends TreeFrame {

    private static String directory = "data/";
    private static org.jdom2.Document document;

    void initTree() {
        org.jdom2.Element rootElement = document.getRootElement();

        String rootAttr = rootElement.getName();
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
            System.out.println(child + "\n");
            parent.add(child);

            if (e.getChildren() != null) {
                buildTree(e, child);
            }
        }
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File(directory + "Life.xml");
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
