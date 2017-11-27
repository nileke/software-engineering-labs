package FifteenGame;

import GameTools.ViewControl;

public class RunFifteenGame {

    public static void main(String[] args) {
        FifteenModel game = new FifteenModel();
        ViewControl playGame = new ViewControl(game, 4);
    }
}
