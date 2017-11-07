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
        if (counter == 3) {
            counter = 0;
            JButton playerButton = (JButton) e.getSource();
            String playerChoice = playerButton.getActionCommand();
            String compChoice = "";
            try {
                compChoice = in.readLine();
            } catch (IOException ioError) {
                System.println(ioError);
            }

            // Check the move
            checkMove(playerChoice, compChoice);

        }
    }

    private boolean checkMove(String playerChoice, String compChoice) {

    }

    private void setupConnection() {
        try {
            socket=new Socket("share-02.csc.kth.se",4713);
            in=new BufferedReader
                    (new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}




