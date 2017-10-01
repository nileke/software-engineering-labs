import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nils on 2017-09-24.
 */

public class XMainProgram  {
    private XButton[] MyButtonArray;

    public static void main(String[] args) {
        int n = 0;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input: Integer required. Try again");
            System.exit(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No buttons added");
            System.exit(0);
        }

        if ((args.length - 1) != n*2) {
            System.out.println("Incorrect input: Incorrect number of strings");
            System.exit(0);
        }

        XFrame frame = new XFrame();

        for (int i = 1; i < n * 2; i += 2) {
            frame.addButton(new XButton(args[i], args[i + 1]));
        }
    }

}


