import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
public class TimerDisplay extends JFrame 
{ 
  static JLabel display = new JLabel("5.0"); 
  static double interval;
  static Timer timer;

  static TimerDisplay frame = new TimerDisplay();
  public static void main(String[] args) {
    
    int delay = 100;
    int period = 100;
    timer = new Timer();
    interval = 5.0;
    
    timer.scheduleAtFixedRate(new TimerTask() {
      public void run()
      {
        display.setText(setInterval() + "");
        if(interval == 0.0)
        {
        display.setText("Action"); 
        }
      }
    }, delay, period);
  }
  
  private static final double setInterval() {
    if (interval <= 0.1){
      timer.cancel();
    }
    interval = interval - 0.1;
    interval = Math.round((interval)*10)/10.0; 
    return interval;
  }
  public TimerDisplay()
  { 
    
    JPanel panel = new JPanel();
    setTitle("Timer");  
    setSize(100, 100);         
    FlowLayout fl1 = new FlowLayout(); //used to organize window
    panel.add(display);
    add(panel);
    setLayout(fl1);                    
    setVisible(true);       
    
  }
  
}
