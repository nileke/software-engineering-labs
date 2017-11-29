import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Demo {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File("data/Life.xml"));
        NodeList nodeList = document.getElementsByTagName("Item");
        for(int x=0,size= nodeList.getLength(); x<size; x++) {
            System.out.println(nodeList.item(x).getAttributes().getNamedItem("name").getNodeValue());
        }
    }
}