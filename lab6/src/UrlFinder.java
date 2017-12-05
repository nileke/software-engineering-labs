import javafx.util.Pair;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class UrlFinder {
    HTMLDocument doc;

    public UrlFinder() { }

    public UrlFinder(String url) {
        String webpage=url;
        InputStream in= null;
        InputStreamReader reader = null;
        try {
            in = new URL(webpage).openConnection().getInputStream();
            reader= new InputStreamReader(in, "ISO-8859-1");
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            System.out.println("Catched error: Reader/in");
            // doc = null;
            // getUrlMatrix();
        }

        doc = new HTMLDocument();

        doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);

        try {
            new HTMLEditorKit().read(reader,doc,0);
        } catch (IOException | BadLocationException | NullPointerException e) {
            e.printStackTrace();
        }
    }

        String[][] getUrlMatrix() {
            String[][] urlMatrix = new String[50][2];
            int count = 0;

            if (doc == null) {
                return null;
            }

            for (HTMLDocument.Iterator iter = doc.getIterator(HTML.Tag.A); iter.isValid(); iter.next()) {
                String value = "";
                if (count > 49) {
                    return urlMatrix;
                }
                AttributeSet attr = iter.getAttributes();
                int start = iter.getStartOffset();
                int length = iter.getEndOffset() - iter.getStartOffset();
                String link = (String) attr.getAttribute(HTML.Attribute.HREF);
                try {
                    value = doc.getText(start, length);
                    System.out.println(value);
                    urlMatrix[count][0] = link;
                    urlMatrix[count][1] = value;
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
                count++;
            }

            return urlMatrix;
        }
}
