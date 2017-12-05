import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class WebBrowser extends JFrame {

    JFrame window;
    JTextField urlField;
    JScrollPane webPage;
    Webreader webPane;
    JScrollPane links;

    WebBrowser() {
        super();
        frameInit();

        window = new JFrame();
        window.setVisible(true);

        urlField = new JTextField();
        window.add(urlField, BorderLayout.PAGE_START);

        webPane = new Webreader();
        webPage = new JScrollPane(webPane);
        window.add(webPage, BorderLayout.CENTER);

        JTable table = new JTable(50, 2);
        links = new JScrollPane(table);
        window.add(links, BorderLayout.EAST);


        urlField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUrl(e.getActionCommand());
            }
        });

        window.setSize(500, 500);

    }

    private void setUrl(String s) {
        webPane.showPage(s);
    }


    public static void main(String[] args) {
        new WebBrowser();
    }
}
