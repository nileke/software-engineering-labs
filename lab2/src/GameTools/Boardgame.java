package GameTools;

/**
 * Created by Nils on 2017-09-30.
 */

public interface Boardgame {
    public boolean move(int x, int y); //ger true om draget gick bra, annars false
    public String getStatus(int x, int y); // returnera innehåll på ruta (i,j)
    public String getMessage(); // returnera OK (eller liknande) eller felmeddelande avseende senaste drag


}


