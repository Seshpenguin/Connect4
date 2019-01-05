import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuGUI  extends JFrame implements ActionListener {

    // GUI Components
    JButton button = new JButton("Play!");
    JLabel titleLabel = new JLabel("Welcome to Connect 4!", JLabel.CENTER);

    JRadioButton selector1 = new JRadioButton("Player vs Player");
    JRadioButton selector2 = new JRadioButton("Player vs Easy AI");
    JRadioButton selector3 = new JRadioButton("Player vs Hard AI");

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

        ButtonGroup group = new ButtonGroup();
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
}
