import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nils on 2017-09-30.
 */
class FifteenModel implements Boardgame {
    // Implementera Boardgame-metoderna
    // Deklarera variabler och övriga metoder som ni
    // tycker behövs för ett femtonspel
    private String currentMessage = "No message yet";
    private String[][] status = new String[4][4];  // spelplanen
    private int iemp, jemp;                        // index till den tomma rutan


    FifteenModel() {
        int n = 1;
        for (int x=0; x < 4; x++) {
            for (int y=0; y < 4; y++) {
                if (n < 10) {
                    status[x][y] = " " + Integer.toString(n);
                }
                else if (n > 9 && n < 16) {
                    status[x][y] = Integer.toString(n);
                } else {
                    iemp = x;
                    jemp = y;
                } n++;
            }
        }
        // shuffleBoard();
    }

    @Override
    public boolean move(int i, int j) {
        // TODO Split move into different methods. One who checks if move is valid validMove(), one who makes the move move()
        if (!inbounds(i) || !inbounds(j)) {
            currentMessage = "Please choose a placement on the board...";
            return false;
        }
        try {
            if (inbounds(i + 1) && status[i + 1][j] == null) {
                currentMessage = "Ok";
                status[i + 1][j] = status[i][j];
                status[i][j] = null;
                iemp = i;
                jemp = j;
                return true;
            } else if (inbounds(i - 1) && status[i - 1][j] == null) {
                currentMessage = "Ok";
                status[i - 1][j] = status[i][j];
                status[i][j] = null;
                iemp = i;
                jemp = j;
                return true;
            } else if (inbounds(j + 1) && status[i][j + 1] == null) {
                currentMessage = "Ok";
                status[i][j + 1] = status[i][j];
                status[i][j] = null;
                iemp = i;
                jemp = j;
                return true;
            } else if (inbounds(j - 1) && status[i][j - 1] == null) {
                currentMessage = "Ok";
                status[i][j - 1] = status[i][j];
                status[i][j] = null;
                iemp = i;
                jemp = j;
                return true;
            } else {
                currentMessage = "Please choose a tile next to the empty one...";
                return false;
            }
        } catch (IndexOutOfBoundsException e) {
            currentMessage = "You broke something";
            return false;
        }

        //return false;
    }

    private void shuffleBoard() {
        // TODO create shuffle of gameboard and call from constructor
        // Create a mirror array with true/false for valid moves?
    }

    private void validMoves(int i, int j) {
        // checks valid moves from the coordinates i and j


    }

    private boolean inbounds(int pos) {
        return (pos >= 0) && (pos < 4);
    }

    public String getStatus(int i, int j) {
        if (status[i][j] == null) {
            return " ";
        }
        return status[i][j];
    }


    public void setMessage(String message) {
        this.currentMessage = message;
    }

    public String getMessage() {
        return currentMessage;
    }


}
