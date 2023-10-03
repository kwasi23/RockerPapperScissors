import javax.swing.*;
import java.awt.*;
import java.util.Random;
// Class definition: This class extends JFrame, meaning it provides a window where UI elements can be added.
public class RockPaperScissorsFrame extends JFrame {
    // These are UI components which include buttons for each move, a text area to display results, and text fields to display the score.
    private JButton rockButton, paperButton, scissorsButton, quitButton;
    private JTextArea resultsArea;
    private JTextField playerWinsField, computerWinsField, tiesField;
    // These integer variables keep track of the scores.
    private int playerWins = 0, computerWins = 0, ties = 0;
    // A Random object to allow the computer to make random moves.
    private Random rand = new Random();
    // Array to store counts of each move made by the player: Rock, Paper, Scissors respectively.
    private int[] moveCounts = {0, 0, 0};  // To store counts of player's moves: Rock, Paper, Scissors

    public RockPaperScissorsFrame() {
        // Constructor of the class, where UI components are initialized and GUI is set up.
        this.setTitle("Rock Paper Scissors Game");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Initializing buttons with respective move names and a quit button.
        // Initializing the text area to display results, specifying the number of rows and columns.
        // Initializing text fields to display scores, specifying the width.
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");
        quitButton = new JButton("Quit");
        resultsArea = new JTextArea(10, 30);
        playerWinsField = new JTextField(5);
        computerWinsField = new JTextField(5);
        tiesField = new JTextField(5);

        // Creating a panel to add and group the buttons.
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(rockButton);
        buttonsPanel.add(paperButton);
        buttonsPanel.add(scissorsButton);
        buttonsPanel.add(quitButton);

        // Adding the buttonsPanel to the top (NORTH) of the frame.
        // Adding a scrollable resultsArea in the center of the frame.
        this.add(buttonsPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(resultsArea), BorderLayout.CENTER);

        // Creating a panel to display the score fields and labels.
        JPanel statsPanel = new JPanel();
        statsPanel.add(new JLabel("Player Wins:"));
        statsPanel.add(playerWinsField);
        statsPanel.add(new JLabel("Computer Wins:"));
        statsPanel.add(computerWinsField);
        statsPanel.add(new JLabel("Ties:"));
        statsPanel.add(tiesField);

        // Adding statsPanel to the bottom (SOUTH) of the frame.
        this.add(statsPanel, BorderLayout.SOUTH);
        // Adjusting the window size to accommodate all components and making it visible.
        this.pack();
        this.setVisible(true);

        // Assigning action listeners to buttons which call respective methods when buttons are pressed.
        rockButton.addActionListener(e -> playGame(0));
        paperButton.addActionListener(e -> playGame(1));
        scissorsButton.addActionListener(e -> playGame(2));
        quitButton.addActionListener(e -> System.exit(0));
    }

    // Method that executes when a move is made by the player. Parameter playerMove takes values: 0 for Rock, 1 for Paper, 2 for Scissors.

    // Display computer’s move in the resultsArea.

    private void playGame(int playerMove) {
        // Increment the count for the selected player's move
        moveCounts[playerMove]++;
        resultsArea.append("You play: " + moveToString(playerMove) + "\n");
        computerLogic(playerMove);
    }
    // Compare moves, update and display results and scores in resultsArea and respective text
    private void computerLogic(int playerMove) {
        int computerMove = chooseComputerMove(playerMove);

        resultsArea.append("Computer plays: " + moveToString(computerMove) + "\n");

        if (playerMove == computerMove) {
            resultsArea.append("It's a tie!\n");
            ties++;
        } else if ((playerMove == 0 && computerMove == 2) ||
                (playerMove == 1 && computerMove == 0) ||
                (playerMove == 2 && computerMove == 1)) {
            resultsArea.append("You win!\n");
            playerWins++;
        } else {
            resultsArea.append("You lose!\n");
            computerWins++;
        }

        playerWinsField.setText(String.valueOf(playerWins));
        computerWinsField.setText(String.valueOf(computerWins));
        tiesField.setText(String.valueOf(ties));
    }

    // Implementing a method that encapsulates the strategy for choosing the computer’s move
    private int chooseComputerMove(int playerMove) {
        int computerMove = rand.nextInt(3);
        return computerMove;
    }

    private String moveToString(int move) {
        switch(move) {
            case 0: return "Rock";
            case 1: return "Paper";
            case 2: return "Scissors";
            default: throw new IllegalArgumentException("Invalid move");
        }
    }


}
