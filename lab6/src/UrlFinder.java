import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlFinder {
    ;

    public static void main(String[] args) {
        String webpage="http://www.nada.kth.se/~henrik";
        InputStream in= null;
        try {
            in = new URL(webpage).openConnection().getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader reader= new InputStreamReader(in);
        HTMLDocument doc = new HTMLDocument();
        doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
        try {
            new HTMLEditorKit().read(reader,doc,0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        for (HTMLDocument.Iterator iter = doc.getIterator(HTML.Tag.A); iter.isValid(); iter.next()) {
            AttributeSet attr = iter.getAttributes();
            int start = iter.getStartOffset();
            int end = iter.getEndOffset();
            int length = end - start;

            try {
                System.out.println(doc.getText(start, length));
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
            System.out.println(attr.getAttribute(HTML.Attribute.HREF));

        }
    }
}
