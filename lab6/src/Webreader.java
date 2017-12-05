import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Webreader extends JEditorPane {

    public Webreader() {
       this.setEditable(false);
    }

    void showPage(String url) {
        try {
            URL webUrl = new URL(url);
            this.setPage(webUrl);
        } catch (MalformedURLException e1) {
            e1.getStackTrace();
            this.setText("404 dude...");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }


}
