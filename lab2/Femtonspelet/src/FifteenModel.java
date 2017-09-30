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

    public boolean move(int x, int y) {
        return true; // Placeholder
    }

    public String getStatus(int x, int y) {
        return status[x][y];
    }


    public void setMessage(String message) {
        this.currentMessage = message;
    }

    public String getMessage() {
        return currentMessage;
    }

    FifteenModel() {
        int n = 1;
        for (int x=0; x < 4; x++) {
            for (int y=0; y < 4; y++) {
                status[x][y] = Integer.toString(n);
                if (n < 16) {
                    n++;
                }
            }
        }
    }
}
