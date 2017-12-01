import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DirThree extends TreeFrame {

    private static String directory = "data/";
    private static  Document document;

    void initTree() {
        Element rootElement = document.getDocumentElement();

        String rootAttrConc = rootElement.getTextContent();
        String rootLevel = rootElement.getAttribute("namn");

        String rootAttr[] = rootAttrConc.split("\n");

        MyNode root = new MyNode(rootLevel, rootAttr[0]);
        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);
        buildTree(rootElement, root);
    }

    private void buildTree(Element root, MyNode parent) {
        NodeList children = root.getChildNodes();
        for (int i=0; i < children.getLength(); i++) {
            Node n = children.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) n;
                String attr = e.getTextContent();
                String level = e.getAttribute("namn");

                MyNode child = new MyNode(level, attr);
                parent.add(child);

                if (e.getChildNodes() != null) {
                    buildTree(e, child);
                }
            }
        }
    }

    void showDetails(TreePath p) {
        if (p == null) { return; }

        MyNode node = (MyNode) p.getLastPathComponent();
        String attr[] = node.getAttrInfo().split("\n");
        String info = node.getLevelInfo() + " " + attr[0];

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
        try {
            File inputFile = new File(directory + "Life.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(inputFile);
            document.getDocumentElement().normalize();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        new DirThree();
    }
}
