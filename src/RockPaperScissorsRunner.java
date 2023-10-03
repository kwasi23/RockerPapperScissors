// Importing all classes and interfaces from the javax.swing package.
import javax.swing.*;

// Declaring a public class named RockPaperScissorsRunner.
public class RockPaperScissorsRunner {

    // Declaring the main method which is the entry point of our Java application.
    public static void main(String[] args) {

        // Invoking the invokeLater method of the SwingUtilities class.
        // This method is used to ensure that all UI updates are concurrency-safe.
        javax.swing.SwingUtilities.invokeLater(() -> {

            // Creating a new instance of the RockPaperScissorsFrame class.
            RockPaperScissorsFrame frame = new RockPaperScissorsFrame();

            // Setting the default operation to be performed when the JFrame is closed.
            // In this case, the application will be terminated when the JFrame is closed.
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Setting the size of the JFrame to be 800x800 pixels.
            frame.setSize(800, 800);

            // Making the JFrame visible. Until this method is called, the JFrame will not be displayed.
            frame.setVisible(true);
        });
    }
}
