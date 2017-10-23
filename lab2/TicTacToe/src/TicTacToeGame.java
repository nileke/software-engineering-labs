public class TicTacToeGame {

    public static void main(String[] args) {
        Boardgame game = new TicTacToeModel();
        ViewControl gameView = new ViewControl(game, 3);
    }
}
