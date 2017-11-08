import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class XFrame extends JFrame implements ActionListener {
    private JPanel panel;
    private ArrayList<XButton> MyButtonArray;

    XFrame() {
        MyButtonArray = new ArrayList<>();
        JFrame frame = new JFrame("Nils Ekenbäck & Ben Forsrup");
        frame.setVisible(true);
        frame.setSize(800,430);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.darkGray);

        frame.add(panel);

    }

    void addButton(XButton button) {
        button.addActionListener(this);
        MyButtonArray.add(button);
        panel.add(button);
        }



    public void actionPerformed(ActionEvent actionEvent) {
        int indexButton = MyButtonArray.indexOf(actionEvent.getSource());
        for (int i=0; i < MyButtonArray.size(); i++) {
            if (i != indexButton) {
                MyButtonArray.get(i).toggleState();
            }
        }
    }

}