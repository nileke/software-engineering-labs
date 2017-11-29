import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DirTree extends TreeFrame {

    private static String directory = "data/";
    private static org.jdom2.Document document;

    private LinkedList<String> children;


    void initTree() {
        org.jdom2.Element rootElement = document.getRootElement();

        String rootLevel = rootElement.getName();
        String rootAttr = rootElement.getAttributeValue("namn");

        System.out.println(rootAttr);


        MyNode root = new MyNode(rootAttr, rootLevel);

        buildTree(rootElement, root);
    }

    private void buildTree(Element root, MyNode parent) {
        List<Element> children = root.getChildren();
        for (Element e : children) {
            String level = root.getText();
            String attr = root.getAttributeValue("namn");
            MyNode child = new MyNode(attr, level);

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
