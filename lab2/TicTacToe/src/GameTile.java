import javax.swing.*;

/**
 * Created by Nils on 2017-09-30.
 */

public class GameTile extends JButton {
    private int x;
    private int y;

    GameTile(int x, int y) {
        this.x = x;
        this.y = y;
}

    public Pair<Integer, Integer> getCoordinates() {
        return new Pair<>(this.x, this.y);
    }
}
