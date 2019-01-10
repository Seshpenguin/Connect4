import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame implements ActionListener {

    // Tracking Boolean
    boolean selectedCol = false;

    // Swing Objects
    JButton[] inButtons = new JButton[7];
    JLabel status = new JLabel("It is Player 1's turn...");

    // Game Grid
    ImageIcon redCircle = new ImageIcon(new ImageIcon("/home/seshpenguin/IdeaProjects/connect4/src/assets/Red Circle.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
    ImageIcon yellowCircle = new ImageIcon(new ImageIcon("/home/seshpenguin/IdeaProjects/connect4/src/assets/red-circle.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
    ImageIcon neutralCircle = new ImageIcon(new ImageIcon("/home/seshpenguin/IdeaProjects/connect4/src/assets/red-circle.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
    JLabel[][] gameGridIcons = new JLabel[6][7];

    public GameGUI() {
        FlowLayout flow = new FlowLayout();

        // Game Grid Layout
        GridLayout gameGridLayout = new GridLayout(6,7);

        // Setup Label size
        setTitle("ICS4U Connect 4 - Game");
        setSize(480,480);

        // Panels
        JPanel colInput = new JPanel();
        JPanel gameGrid = new JPanel();
        JPanel statArea = new JPanel();

        // Initialize the column input buttons
        for (int i = 0; i < inButtons.length; i++) {
            inButtons[i] = new JButton(" " + i + " ");
            inButtons[i].addActionListener(this);
            colInput.add(inButtons[i]);
        }
        colInput.setLayout(flow);

        // Fill the gameGrid
        gameGrid.setLayout(gameGridLayout);
        for(int i = 0; i < gameGridIcons.length; i++) {
            for(int x = 0; x < gameGridIcons[i].length; x++) {
                gameGridIcons[i][x] = new JLabel("", redCircle, JLabel.CENTER);
                gameGrid.add(gameGridIcons[i][x]);
            }
        }

        statArea.add(status);

        // Add the 3 Panels to the frame
        add(colInput);
        add(gameGrid);
        add(statArea);

        setLayout(flow);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        HelperMethods.debugPrintln("'" + command + "'");
        if (command.equals(" 1 ")) {
            HelperMethods.debugPrintln("1 button was pressed.");
            selectedCol = true;
            setVisible(false);
        } else if (command.equals(" 2 ")) {
            HelperMethods.debugPrintln("2 button was pressed.");
            selectedCol = true;
            setVisible(false);
        } else if (command.equals(" 3 ")) {
            HelperMethods.debugPrintln("3 button was pressed.");
            selectedCol = true;
            setVisible(false);
        } else if (command.equals(" 4 ")) {
            HelperMethods.debugPrintln("4 button was pressed.");
            selectedCol = true;
            setVisible(false);
        } else if (command.equals(" 5 ")) {
            HelperMethods.debugPrintln("5 button was pressed.");
            selectedCol = true;
            setVisible(false);
        } else if (command.equals(" 6 ")) {
            HelperMethods.debugPrintln("6 button was pressed.");
            selectedCol = true;
            setVisible(false);
        } else if (command.equals(" 7 ")) {
            HelperMethods.debugPrintln("7 button was pressed.");
            selectedCol = true;
            setVisible(false);
        }
    }

    public boolean isWatingForUserInput() {
        if(selectedCol == true){
            HelperMethods.debugPrintln("It's false now.");
            return false;
        } else {
            return true;
        }
    }
}
