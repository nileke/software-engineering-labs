package Extra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nils on 2017-09-22.
 */
public class XButton extends JButton {

    private String s1;
    private String s2;

    XButton(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;

        this.setText(s1);
    }

    public void toggleState() {
        String toggleText = super.getText() == this.s1 ? this.s2 : this.s1;
        this.setText(toggleText);
    }



}


