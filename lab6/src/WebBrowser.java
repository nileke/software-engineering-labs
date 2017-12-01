import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class WebBrowser extends JFrame {

    JFrame window;
    JTextField urlField;
    JScrollPane webPage;
    JScrollPane links;

    WebBrowser() {
        super();
        frameInit();

        window = new JFrame();
        window.setSize(500, 500);
        window.setVisible(true);

        urlField = new JTextField();
        window.add(urlField, BorderLayout.PAGE_START);

        Webreader webPane = new Webreader();
        webPage = new JScrollPane(webPane);
        window.add(webPage, BorderLayout.CENTER);

        JTable table = new JTable(50,2);
        links = new JScrollPane(table);
        window.add(links, BorderLayout.EAST);

        URL url = null;
        // Just testing showPage
        try {
            url = new URL("http://www.nada.kth.se/~snilsson");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        webPane.showPage(url);
    }

    public static void main(String[] args) {
        new WebBrowser();
    }
}
