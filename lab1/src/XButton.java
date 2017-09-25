import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nils on 2017-09-22.
 */
public class XButton extends JButton implements ActionListener {

    private String s1;
    private String s2;

    XButton(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;

        this.setText(s1);
        this.addActionListener(this);
    }

    private void toggleState() {
//        if (this.getText().equals(s1)) {
//            this.setText(s2);
//        } else {
//            this.setText(s1);
//        }

        // Color toggleColor = super.getBackground() == this.c1 ? this.c2 : this.c1;
        String toggleText = super.getText() == this.s1 ? this.s2 : this.s1;
        // this.setBackground(toggleColor);
        this.setText(toggleText);
    }



    public void actionPerformed(ActionEvent a) {
        this.toggleState();
    }

}


