import javax.swing.*;
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

        game = new FifteenModel();
        for (int i=0; i < 4; i++) {
            for (int j=0; j < 4; j++) {
                String squareText = game.getStatus(i,j);
                Square sq = new Square(i,j);
                sq.setText(squareText);
                board[i][j] = sq;
           }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Click button to call move
        // if true ->
        // Call updateBoard()
    }

    public void updateBoard() {
        // Update the whole board by calling getStatus() from FifteenModel class
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String squareText = game.getStatus(i, j);
                board[i][j].setText(squareText);

            }
        }
    }

}
