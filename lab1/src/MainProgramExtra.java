import java.util.Scanner;

/**
 * Created by nils on 2017-09-22.
 */

public class MainProgramExtra {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of buttons: ");
        int n = sc.nextInt();

        String[] buttonTextArray = new String[n*2];

        int counter;
        for (int i=0; i < n*2; i++) {
            counter = n*2-i;
            System.out.print("Enter button text (" + counter + " left): ");
            buttonTextArray[i] = sc.next();
        }

        Frame frame = new Frame();

        for (int i=0; i < buttonTextArray.length;) {
            frame.addButton(new XButton(buttonTextArray[i], buttonTextArray[i+1]));
            i += 2;
        }
    }
}
