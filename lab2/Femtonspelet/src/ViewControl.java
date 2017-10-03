import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewControl extends JFrame implements ActionListener {

    private Boardgame game;
    private int size; //
    private Square[][] board;
    private JLabel mess = new JLabel();

    ViewControl(Boardgame gm, int n) {
        // Create a new board by creating a new FifteenModel object
        // read from getStatus in new object to populate Square[][]
        // Create new JFrame and set set an matrix 4x4
        // add JLabel with message

        // COMPLETE create JFrame
        // COMPLETE add buttons to JFrame
        // COMPLETE add JLabel to JFrame
        this.game = gm;
        board = new Square[4][4];

        // TODO set frame dimensions
        // TODO add JLabel
        JFrame frame = new JFrame("FifteenModel");
        frame.setVisible(true);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new GridLayout(4,4));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        populateBoard(panel);

    }

    private void populateBoard(JPanel panel) {
        for (int i=0; i < 4; i++) {
            for (int j=0; j < 4; j++) {
                String squareText = game.getStatus(i,j);
                Square sq = new Square(i,j);
                sq.setText(squareText);
                sq.addActionListener(this);
                board[i][j] = sq;
                panel.add(sq); // Enough?
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
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String squareText = game.getStatus(i, j);
                board[i][j].setText(squareText);
            }
        }
    }

}
