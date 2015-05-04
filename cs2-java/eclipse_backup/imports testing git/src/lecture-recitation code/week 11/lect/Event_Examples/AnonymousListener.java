import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnonymousListener extends JFrame
{
  private JButton run=new JButton("Run the Utility");
  private JButton exit=new JButton("Exit After Save");
  private JPanel buttons=new JPanel();
  
  public AnonymousListener() // the constructor
  {
    super("Event Listener Demo");
    
    buttons.setLayout(new GridLayout(4,1,2,2));
    buttons.add(run);
    buttons.add(exit);
    this.getContentPane().add("Center",buttons);
    
    // add an anonymous listener
    exit.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    });    
    
    // set frame appearance
    setVisible(true);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setBounds(100,100,250,150);

  }
  
  public static void main(String[] args) {
      new AnonymousListener();
  }
}
