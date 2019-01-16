/*
 * ICS4U Connect 4 - Menu GUI
 * This is the first menu where a player can choose the mode, and press play. It is called from GUI Helpers.
 * by Seshan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

public class MenuGUI  extends JFrame implements ActionListener {

    // GUI Components
    JButton button = new JButton("Play!");
    JLabel titleLabel = new JLabel("Welcome to Connect 4!", JLabel.CENTER);

    JRadioButton selector1 = new JRadioButton("Player vs Player");
    JRadioButton selector2 = new JRadioButton("Player vs Easy AI");
    JRadioButton selector3 = new JRadioButton("Player vs Hard AI");

    ButtonGroup group = new ButtonGroup();

    // States
    public boolean pressedPlay = false;


    public MenuGUI() {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Could not set GUI look and feel: " + e);
        }

        // Setup Label size
        titleLabel.setFont(new Font(titleLabel.getName(), Font.PLAIN, 24));

        setTitle("ICS4U Connect 4");
        setSize(480,240);

        FlowLayout flow = new FlowLayout();
        GridLayout buttonGrid = new GridLayout(1,3);
        GridLayout mainGrid = new GridLayout(3, 1);


        group.add(selector1);
        group.add(selector2);
        group.add(selector3);

        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        titlePanel.setLayout(flow);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(selector1);
        buttonPanel.add(selector2);
        buttonPanel.add(selector3);
        buttonPanel.setLayout(buttonGrid);

        add(titlePanel);
        add(buttonPanel);
        add(button);

        button.addActionListener(this);

        setLayout(mainGrid);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if (command.equals("Play!")) {
                HelperMethods.debugPrintln("Play button was pressed.");
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

    public int gameType() {
        // Get the game type (1 for PvP, 2 for AI)

        // Loop through the button group and find the selected option.
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                if(button.getText().equals("Player vs Player")) {
                    return 1;
                } else if (button.getText().equals("Player vs Easy AI")) {
                    return 2;
                } else if (button.getText().equals("Player vs Hard AI")) {
                    return 3;
                } else {
                    return -1;
                }

            }
        }
        return 0;
    }
}
