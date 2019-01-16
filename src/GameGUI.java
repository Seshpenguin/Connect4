/*
 * ICS4U Connect 4 - Main Game GUI
 * This is the main Game GUI, written using swing. It is called by GUIHelpers.
 * by Seshan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame implements ActionListener {

    // Tracking Boolean
    boolean selectedCol = false;

    // Selected Column
    int selectedColValue = 0;

    // Swing Objects
    JButton[] inButtons = new JButton[7];
    JLabel status;

    // Game Grid
    ClassLoader cldr = this.getClass().getClassLoader();
    java.net.URL redURL   = cldr.getResource("assets/red.png");
    java.net.URL yellowURL   = cldr.getResource("assets/yellow.png");
    java.net.URL blankURL   = cldr.getResource("assets/blank.png");

    ImageIcon redCircle = new ImageIcon(new ImageIcon(redURL).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
    ImageIcon yellowCircle = new ImageIcon(new ImageIcon(yellowURL).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
    ImageIcon neutralCircle = new ImageIcon(new ImageIcon(blankURL).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
    JLabel[][] gameGridIcons = new JLabel[6][7];

    public GameGUI(int type, int[][] gameGridArray, int turn) {
        FlowLayout flow = new FlowLayout();
        FlowLayout flowButtons = new FlowLayout(FlowLayout.CENTER, 10, 5);


        // Game Grid Layout
        GridLayout gameGridLayout = new GridLayout(6,7);

        // Setup Label size
        setTitle("ICS4U Connect 4 - Game");
        setSize(480,480);

        // Panels
        JPanel colInput = new JPanel();
        JPanel gameGrid = new JPanel();
        JPanel statArea = new JPanel();

        // Label:
        if(type == 3) {
            status = new JLabel("This is the game results!");
        } else {
            status = new JLabel("It is Player " + turn + "'s turn...");
        }

        // Initialize the column input buttons
        if(type != 3) {
            for (int i = 0; i < inButtons.length; i++) {
                int labelNum = i + 1;
                inButtons[i] = new JButton(" " + labelNum + " ");
                inButtons[i].addActionListener(this);
                colInput.add(inButtons[i]);
            }
        }

        // Set the Layout for the buttons
        colInput.setLayout(flowButtons);

        // Fill the gameGrid
        gameGrid.setLayout(gameGridLayout);
        for(int x = 0; x < gameGridIcons.length; x++) {
            for(int y = 0; y < gameGridIcons[x].length; y++) {
                if(gameGridArray[x][y] == 0) { // No piece
                    gameGridIcons[x][y] = new JLabel("", neutralCircle, JLabel.CENTER);
                    gameGrid.add(gameGridIcons[x][y]);
                } else if(gameGridArray [x][y] == 1) { // Player 1
                    gameGridIcons[x][y] = new JLabel("", redCircle, JLabel.CENTER);
                    gameGrid.add(gameGridIcons[x][y]);
                } else { // Player 2
                    gameGridIcons[x][y] = new JLabel("", yellowCircle, JLabel.CENTER);
                    gameGrid.add(gameGridIcons[x][y]);
                }

            }
        }

        statArea.add(status);

        // Draw the 3 Panels to the frame
        add(colInput);
        add(gameGrid);
        add(statArea);

        setLayout(flow);
        setLocationRelativeTo(null); // Draw window in center of screen.
        setVisible(true);
    }
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        HelperMethods.debugPrintln("'" + command + "'");
        if (command.equals(" 1 ")) {
            HelperMethods.debugPrintln("1 button was pressed.");
            selectedCol = true;
            selectedColValue = 0;
            setVisible(false);
        } else if (command.equals(" 2 ")) {
            HelperMethods.debugPrintln("2 button was pressed.");
            selectedCol = true;
            selectedColValue = 1;
            setVisible(false);
        } else if (command.equals(" 3 ")) {
            HelperMethods.debugPrintln("3 button was pressed.");
            selectedCol = true;
            selectedColValue = 2;
            setVisible(false);
        } else if (command.equals(" 4 ")) {
            HelperMethods.debugPrintln("4 button was pressed.");
            selectedCol = true;
            selectedColValue = 3;
            setVisible(false);
        } else if (command.equals(" 5 ")) {
            HelperMethods.debugPrintln("5 button was pressed.");
            selectedCol = true;
            selectedColValue = 4;
            setVisible(false);
        } else if (command.equals(" 6 ")) {
            HelperMethods.debugPrintln("6 button was pressed.");
            selectedCol = true;
            selectedColValue = 5;
            setVisible(false);
        } else if (command.equals(" 7 ")) {
            HelperMethods.debugPrintln("7 button was pressed.");
            selectedCol = true;
            selectedColValue = 6;
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
    public int getCol() {
        return selectedColValue;
    }
}
