package Grunduppgift;

import javax.swing.*;
import java.awt.*;


/**
 * Created by nils on 2017-09-22.
 */

class Frame extends JFrame {
    private JPanel panel;
    Frame() {
        JFrame frame = new JFrame("Nils Ekenbäck & Ben Forsrup");
        frame.setVisible(true);
        frame.setSize(800,430);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        // JButton button1 = new Grunduppgift.MyButton(Color.lightGray, Color.darkGray, "On", "Off");
        // JButton button2 = new Grunduppgift.MyButton(Color.darkGray, Color.lightGray, "Run", "Stop");
        panel.setBackground(Color.darkGray);

        frame.add(panel);
        // panel.add(button1);
        // panel.add(button2);

    }

    void addButton(JButton button) {
        panel.add(button);
    }
}
