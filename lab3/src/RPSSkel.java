import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

import static javax.sound.sampled.BooleanControl.Type.MUTE;

/*
Given class
 */

class RPSSkel extends JFrame implements ActionListener {
    private Gameboard myboard, computersboard;
    private int counter; // To count ONE ... TWO  and on THREE you play
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private JButton closebutton;
    private JToggleButton soundbutton;
    private boolean soundState = false;
    private AudioInputStream as;



    RPSSkel () {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        closebutton = new JButton("Close");

        closebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                out.println("\u0000"); out.flush();
                System.exit(0);
            }
        });

        soundbutton = new JToggleButton("Sound OFF");
        soundbutton.setSelected(soundState);

        soundbutton.addItemListener(new ItemListener() {
            // https://stackoverflow.com/questions/28382432/java-swing-making-on-off-button

            @Override
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                if (state == 1) {
                    soundbutton.setText("Sound ON");
                    soundState = true;
                }
                else {
                    soundbutton.setText("Sound OFF");
                    soundState = false;

                }
                soundbutton.setSelected(soundState);
            }
        });

        myboard = new Gameboard("Myself", this); // Must be changed

        computersboard = new Gameboard("Computer");
        JPanel boards = new JPanel();
        boards.setLayout(new GridLayout(1,2));
        boards.add(myboard);
        boards.add(computersboard);
        add(boards, BorderLayout.CENTER);
        add(closebutton, BorderLayout.SOUTH);
        add(soundbutton, BorderLayout.NORTH);
        setSize(300, 550);
        setVisible(true);

        setupConnection();

    }

    public static void main (String[] u) {
        new RPSSkel();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        myboard.resetColor();
        computersboard.resetColor();

        switch(counter) {
            case 1:
                myboard.setUpper("ETT");
                computersboard.setUpper("ETT");
                break;
            case 2:
                myboard.setUpper("TVÅ");
                computersboard.setUpper("TVÅ");
                break;
            case 3:
                myboard.setUpper("TRE");
                computersboard.setUpper("TRE");

                counter = 0;
                JButton playerButton = (JButton) e.getSource();
                String playerChoice = playerButton.getActionCommand();
                out.println(playerChoice); out.flush();
                try {
                    String compChoice = in.readLine();
                    computersboard.markPlayed(compChoice);
                    myboard.markPlayed(playerChoice);
                    checkMove(playerChoice, compChoice);
                } catch (IOException ioError) {
                    System.out.println(ioError);
                }
                break;
        }
     }


    private void checkMove(String playerChoice, String compChoice) {
        // Matrix of win/lose where 1 win, 0 tie and -1 lose
        Integer[][] winMatrix = {{0,-1,1},{1,0,-1},{-1,1,0}};
        int player = mapChoice(playerChoice);
        int computer = mapChoice(compChoice);
        URL soundfile = null;

        switch (winMatrix[computer][player]) {
            case 1:
                myboard.wins();
                myboard.setLower("WINS");
                computersboard.setLower("LOSE");
                soundfile = RPSSkel.class.getResource("/resources/win.wav");
                break;
            case 0:
                myboard.setLower("DRAW");
                computersboard.setLower("DRAW");
                soundfile = RPSSkel.class.getResource("/resources/draw.wav");
                break;
            case -1:
                computersboard.wins();
                myboard.setLower("LOSE");
                computersboard.setLower("WINS");
                soundfile = RPSSkel.class.getResource("/resources/lose.wav");
                break;
        }

        if (soundState) {
            playSound(soundfile);
        }
    }

    private int mapChoice(String choice) {
        int numChoice = -1;

        switch(choice) {
            case "STEN":
                numChoice = 0;
                break;
            case "SAX":
                numChoice = 1;
                break;
            case "PASE":
                numChoice = 2;
                break;
        }

        if (numChoice == -1) {
            throw new java.lang.Error("Something went wrong");
        }

        return numChoice;
    }

    public void playSound(URL soundfile) {
        // https://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
        try {
            if (soundState) {
                as = AudioSystem.getAudioInputStream(soundfile);
                Clip clip = AudioSystem.getClip();
                clip.open(as);
                clip.start();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void setupConnection() {
        try {
            socket=new Socket("share-02.csc.kth.se",4713);
            in=new BufferedReader
                    (new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream());
            out.println("Charlotta"); out.flush();
            System.out.println(in.readLine());
            //out.println("Charlotta"); out.flush();
            //System.out.println(in.readLine());
            //out.println("STEN"); out.flush();
            //System.out.println(in.readLine());
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}




