public class TicTacToeModel implements Boardgame {

    private String currentMessage = "Player X starts the game";
    private String[][] status = new String[3][3];
    private int xtemp;
    private int ytemp;
    private int count = 1;
    private boolean mark = false;
    private String currentPlayer = "X";

    TicTacToeModel() {
        setupBoard();
    }

    private void setupBoard() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                status[i][j] = null;
            }
        }
    }

    private void setCurrentPlayer() {
        currentPlayer = currentPlayer == "X" ? "O" : "X";
    }


    public boolean move(int i, int j) {
        if (count>6) {
            return phaseTwo(i, j);
        } else {
            return phaseOne(i, j);

        }
    }

    private boolean phaseOne(int i, int j) {
        if (status[i][j] != null) {
            currentMessage = "Choose an empty tile";
            return false;
        }

        setCurrentPlayer();
        currentMessage = currentPlayer + "'s turn";

        if (count%2 != 0) {
            status[i][j] = "X";
        } else {
            status[i][j] = "O";
        }

        count++;
        return true;
    }

    private boolean phaseTwo(int i, int j) {
        if (status[i][j] == null && !mark) {
            currentMessage = "Choose an " +  currentPlayer + " marker";
            return false;
        }

        if (!mark && getStatus(i, j) == currentPlayer) {
            xtemp = i;
            ytemp = j;
            mark = true;
            currentMessage = "Tile: " + i + ", " + j + " was marked";
        } else {
            if (status[i][j] == null) {
                status[i][j] = status[xtemp][ytemp];
                status[xtemp][ytemp] = null;
                setCurrentPlayer();
                mark = false;
                count++;
            } else {
                currentMessage = "Choose an " +  currentPlayer + " marker";;
            }
        }
        return true;
    }


    @Override
    public String getStatus(int i, int j) {
        return status[i][j];
    }

    @Override
    public String getMessage() {
        return currentMessage;
    }
}
