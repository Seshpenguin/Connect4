/*
 * ICS4U Connect 4 - Result GUI
 * This is when a player wins. GUI to show
 * by Seshan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResultGUI extends JFrame implements ActionListener {
    // GUI Components
    JButton button = new JButton("Exit");
    JLabel titleLabel = new JLabel("Thanks for playing Connect 4!", JLabel.CENTER);
    JButton displayButton = new JButton("View the results (board)");


    // States
    public boolean pressedPlay = false;

    // gameGrid (for results viewing)
    int[][] gameGrid;

    public ResultGUI(int winner, boolean isAI, int[][] gameGridFinal) {
        gameGrid = gameGridFinal; // This is so you can view the finished game.

        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Could not set GUI look and feel: " + e);
        }

        JLabel winnerLabel = new JLabel("Congrats!!!", JLabel.CENTER);
        if(winner == 1) { // Player 1
            winnerLabel = new JLabel("Good Job Player 1! You win!", JLabel.CENTER);
        } else if (winner == 2) {
            if(isAI) {
                winnerLabel = new JLabel("Oh no! The AI beat you! Good Job to the AI!", JLabel.CENTER);
            } else {
                winnerLabel = new JLabel("Good Job Player 2! You win!", JLabel.CENTER);
            }
        }

        // Setup Label size
        titleLabel.setFont(new Font(titleLabel.getName(), Font.PLAIN, 24));

        setTitle("ICS4U Connect 4 - Congrats!");
        setSize(960,240);

        FlowLayout flow = new FlowLayout();
        GridLayout buttonGrid = new GridLayout(1,3);
        GridLayout mainGrid = new GridLayout(3, 1);


        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        titlePanel.setLayout(flow);

        add(titlePanel);
        add(winnerLabel);
        add(displayButton);
        add(button);

        button.addActionListener(this);
        displayButton.addActionListener(this);

        setLayout(mainGrid);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if (command.equals("Exit")) {
            HelperMethods.debugPrintln("Exit button was pressed.");
            this.pressedPlay = true;
            setVisible(false);
            System.exit(0); // Exit the program
        } else if(command.equals("View the results (board)")) {
            try {
                GameGUI game = new GameGUI(3, gameGrid, 1);
            } catch (Exception e) {
                // Do nothing
            }

        }
    }

    // Setter and Getter methods:
    public boolean isWatingForUserInput() {
        if(pressedPlay == true){
            HelperMethods.debugPrintln("It's false now.");
            return false;

        } else {
            return true;
        }
    }


}
