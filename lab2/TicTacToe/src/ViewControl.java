import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewControl extends JFrame implements ActionListener {

    private Boardgame game;
    private int size;
    private Square[][] board;
    private JLabel mess = new JLabel();

    ViewControl(Boardgame gm, int n) {
        // Create a new board by creating a new FifteenModel object
        // read from getStatus in new object to populate Square[][]
        // Create new JFrame and set set an matrix 4x4
        // add JLabel with message

        this.game = gm;
        this.size = n;
        board = new Square[size][size];
        mess.setText(game.getMessage());

        // TODO Tidy up the layout
        // TODO review constructor
        JFrame frame = new JFrame("FifteenModel");


        frame.setVisible(true);
        // Create panels
        JPanel mainPanel = new JPanel();
        JPanel panelGame = new JPanel();
        JPanel panelMessage = new JPanel();

        // Setup panels
        mainPanel.setLayout(new BorderLayout());

        panelGame.setLayout(new GridLayout(size,size));
        panelMessage.add(mess);


        mainPanel.add(panelGame, BorderLayout.CENTER);
        mainPanel.add(panelMessage, BorderLayout.PAGE_END);
        frame.add(mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        populateBoard(panelGame);
        frame.setSize(500,500);
        // frame.pack();

    }

    private void populateBoard(JPanel panel) {
        for (int i=0; i < size; i++) {
            for (int j=0; j < size; j++) {
                String squareText = game.getStatus(i,j);
                Square sq = new Square(i,j);
                sq.setText(squareText);
                sq.addActionListener(this);
                board[i][j] = sq;
                panel.add(sq);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Click button to receive coordinates and call move
        // call getMessage from FifteenModel class and update JLabel mess
        // if move returns true ->
        // Call updateBoard()
        Square button = (Square) e.getSource();
        Pair coord = button.getCoordinates();

        // Make move and update JLabel variable
        boolean moveRes = game.move((Integer) coord.getKey(), (Integer) coord.getValue());
        mess.setText(game.getMessage());

        if (moveRes) {
            updateBoard();
        }
    }

    private void updateBoard() {
        // Update the whole board by calling getStatus() from FifteenModel class
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String squareText = game.getStatus(i, j);
                board[i][j].setText(squareText);
            }
        }
    }

}
