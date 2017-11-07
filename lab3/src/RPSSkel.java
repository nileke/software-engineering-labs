import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

/*
Given class
 */

class RPSSkel extends JFrame implements ActionListener {
    Gameboard myboard, computersboard;
    int counter; // To count ONE ... TWO  and on THREE you play
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;

    RPSSkel () {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        closebutton = new JButton("Close");
        myboard = new Gameboard("Myself", this); // Must be changed
        computersboard = new Gameboard("Computer");
        JPanel boards = new JPanel();
        boards.setLayout(new GridLayout(1,2));
        boards.add(myboard);
        boards.add(computersboard);
        add(boards, BorderLayout.CENTER);
        add(closebutton, BorderLayout.SOUTH);
        setSize(300, 550);
        setVisible(true);
    }

    public static void main (String[] u) {
        new RPSSkel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String countdown = "";
        counter++;

        switch(counter) {
            case 1:
                countdown = "ETT";
                break;
            case 2:
                countdown = "TVÅ";
        }

        JButton playerChoice = (JButton) e.getSource();
        // JButton compChoice = (JButton)
    }


}




