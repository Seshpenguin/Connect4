import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame implements ActionListener {

    // Swing Objects
    JButton button = new JButton("Todo");
    ImageIcon red = new ImageIcon();

    public GameGUI() {
        FlowLayout flow = new FlowLayout();
        // Setup Label size
        setTitle("ICS4U Connect 4 - Game");
        setSize(480,240);

        setLayout(flow);
        add(button);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
    }
}
// th/home/seshpenguin/IdeaProjects/connect4/out
///home/seshpenguin/IdeaProjects/connect4/src
///home/seshpenguin/IdeaProjects/connect4/connect4.iml