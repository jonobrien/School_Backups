package command;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import main.Display;

public class ImageLoadCommand implements ActionListener, CommandInterface {

    private String filePath;
    
    public ImageLoadCommand(String filePath){
        this.filePath = filePath;
    }
    
    @Override
    public void execute() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"That source location could not be found/opened");
        }
        if(image != null){
            JLabel picLabel = new JLabel(new ImageIcon(image));
            JFrame newWindow = new JFrame();
            newWindow.add( new JScrollPane( picLabel ) );
            newWindow.setSize(image.getWidth() + 50,image.getHeight() + 50);
            newWindow.setTitle( filePath );
            newWindow.setVisible( true );
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        execute();
    }

}
