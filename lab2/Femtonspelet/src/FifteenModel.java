import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Random;

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
        shuffleBoard();
    }


    @Override
    public boolean move(int i, int j) {
        if (!inbounds(i) || !inbounds(j)) {
            currentMessage = "Please choose a placement on the board...";
            return false;
        }
        ArrayList<Pair> availMoves = validMoves(iemp, jemp);
        if (availMoves.contains(new Pair<>(i, j))) {
            currentMessage = "Ok.";
            status[iemp][jemp] = status[i][j];
            status[i][j] = null;
            iemp = i;
            jemp = j;

        } else {
            currentMessage = "Please choose a tile next to the empty one...";
            return false;
        }
        return true;
    }

    private void shuffleBoard() {
        // TODO create shuffle of gameboard and call from constructor
        // Random a move from validMoves()

        ArrayList<Pair> availMoves;
        int ranIndex;
        Pair newMove;
        Pair oldMove = new Pair<Integer, Integer>(iemp, jemp);

        for (int i=0; i < 100; i++) {
            availMoves = validMoves(iemp, jemp);
            ranIndex = randInt(0, availMoves.size()-1);
            newMove = availMoves.get(ranIndex);

            if (newMove.getValue() == oldMove.getValue() && newMove.getKey() == oldMove.getKey()) {
                continue;
            }

            int left = (Integer) newMove.getKey();
            int right = (Integer) newMove.getValue();
            move(left, right);
            availMoves.clear();
            //oldMove = newMove;


        }
    }

    private ArrayList<Pair> validMoves(int i, int j) {
        // checks valid moves from the coordinates i and j
        // Pair<Integer, Integer> p;
        ArrayList<Pair> availableMoves = new ArrayList<>();

        if (inbounds(i+1)) {
            availableMoves.add(new Pair<>(i+1, j));
        }
        if (inbounds(i-1)) {
            availableMoves.add(new Pair<>(i-1, j));
        }
        if (inbounds(j+1)) {
            availableMoves.add(new Pair<>(i, j+1));
        }
        if (inbounds(j-1)){
            availableMoves.add(new Pair<>(i, j-1));
        }
        return availableMoves;
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

    //https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public void printBoard(){
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++)
                System.out.print("  " + getStatus(i,j)); // getStatus
            System.out.println();
        }
    }
}
