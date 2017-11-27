package Grunduppgift;

import java.awt.*;

/**
 * Created by nils on 2017-09-22.
 */

public class mainProgram {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.addButton(new MyButton(Color.lightGray, Color.darkGray, "On", "Off"));
    }

}
