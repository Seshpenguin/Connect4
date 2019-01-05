import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame implements ActionListener {

    // Swing Objects
    JButton button = new JButton("Todo");
    ImageIcon red = new ImageIcon();

    public GameGUI() {
        FlowLayout flow = new FlowLayout();

        setLayout(flow);
        add(button);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
    }
}
// th