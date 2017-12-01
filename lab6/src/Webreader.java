import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class Webreader extends JEditorPane {

    public Webreader() {
       this.setEditable(false);
    }

    void showPage(URL webUrl) {
        try {
            this.setPage(webUrl);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
