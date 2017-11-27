package TicTacToe;

import GameTools.ViewControl;

public class RunTicTacToe {

    public static void main(String[] args) {
        TicTacToeModel game = new TicTacToeModel();
        ViewControl gameView = new ViewControl(game, 3);
    }
}
