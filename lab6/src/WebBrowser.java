import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WebBrowser extends JFrame {

    JFrame window;
    JTextField urlField;
    JScrollPane webPage;
    Webreader webPane;
    JScrollPane links;
    JTable table;
    String[][] urlMatrix;

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

        table = new JTable(50, 2);
        links = new JScrollPane(table);
        window.add(links, BorderLayout.EAST);


        urlField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUrl(e.getActionCommand());
                showUrls(e.getActionCommand());

            }
        });

        window.setSize(1000, 500);

    }

    private void setUrl(String s) {
        webPane.showPage(s);

    }

    void showUrls(String url) {
        UrlFinder urlFinder = new UrlFinder(url);
        urlMatrix = urlFinder.getUrlMatrix();
        if (urlMatrix != null) {
            String[] header = {"WEBADRESS", "LINK TEXT"};
            table.setModel(new DefaultTableModel(urlMatrix, header));
        }
    }


    public static void main(String[] args) {
        new WebBrowser();
    }
}
