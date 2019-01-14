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


    // States
    public boolean pressedPlay = false;


    public ResultGUI(int winner, boolean isAI) {
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
        setSize(480,240);

        FlowLayout flow = new FlowLayout();
        GridLayout buttonGrid = new GridLayout(1,3);
        GridLayout mainGrid = new GridLayout(3, 1);


        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        titlePanel.setLayout(flow);

        add(titlePanel);
        add(winnerLabel);
        add(button);

        button.addActionListener(this);

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
