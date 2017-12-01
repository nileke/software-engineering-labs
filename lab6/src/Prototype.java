import javax.swing.*;
import java.awt.*;

public class Prototype extends JFrame {

    JFrame window;
    JTextField urlField;
    JEditorPane webPane;
    JScrollPane links;

    Prototype() {
        window = new JFrame();
        window.setSize(500, 500);
        window.setVisible(true);

        urlField = new JTextField();
        window.add(urlField, BorderLayout.PAGE_START);

        webPane = new JEditorPane();
        window.add(webPane, BorderLayout.CENTER);

        JTable table = new JTable(50,2);
        links = new JScrollPane(table);
        window.add(links, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        new Prototype();
    }
}
