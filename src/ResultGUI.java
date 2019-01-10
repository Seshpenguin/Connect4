import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResultGUI extends JFrame implements ActionListener {
    // GUI Components
    JButton button = new JButton("Exit");
    JLabel titleLabel = new JLabel("Thanks for playing Connect 4!", JLabel.CENTER);


    // States
    public boolean pressedPlay = false;


    public ResultGUI() {
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


        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        titlePanel.setLayout(flow);

        add(titlePanel);
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

    public int gameType() {
        // Get the game type (1 for PvP, 2 for AI)
        // TODO
        return 0;
    }

}
