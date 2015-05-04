package command;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.Display;
import main.StaticUtilities;

public class ImageViewCommand implements ActionListener, CommandInterface {

    private String filepathRegex = "[A-Z]:\\\\([a-zA-Z0-9\\!\\@\\#\\$\\%\\^\\&\\(\\)\\-\\_\\+\\=\\`\\~\\,\\.\\'\\;\\[\\]\\{\\} ]*\\\\)*[a-zA-Z0-9\\!\\@\\#\\$\\%\\^\\&\\(\\)\\-\\_\\+\\=\\`\\~\\,\\.\\'\\;\\[\\]\\{\\} ]*\\.(?:jpeg|png|jpg)";
        
    private ArrayList<String> imageSources;
    
    @Override
    public void execute() {
        fillImageSources();
        if(imageSources.size() == 0){
            JOptionPane.showMessageDialog(Display.getDisplay(),"No valid filepath sources found");
        }else{
            JFrame imageWindow = new JFrame("Image Viewing");
            JPanel mainContainer = new JPanel(new BorderLayout());
            mainContainer.add( new JLabel("Select a source below to view", JLabel.CENTER), BorderLayout.NORTH );
            JPanel sources = new JPanel();
            sources.setLayout( new BoxLayout(sources, BoxLayout.Y_AXIS) );
            JButton newSrc;
            for(String src : imageSources){
                newSrc = new JButton(src);
                newSrc.setMaximumSize( new Dimension(4096,40) );
                newSrc.addActionListener( new ImageLoadCommand( src ) );
                sources.add( newSrc );
            }
            JScrollPane sourcesScroller = new JScrollPane(sources, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            mainContainer.add( sourcesScroller, BorderLayout.CENTER );
            imageWindow.add( mainContainer );
            imageWindow.setSize( 400 , 400 );
            imageWindow.setVisible( true );
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        execute();
    }
    
    private void fillImageSources(){
        imageSources = new ArrayList<String>();
        String text = StaticUtilities.getCurrentTab().getContent().getBuffer().getText();
        /*Modify the following code to look for image sources and not a links*/
        int index = text.indexOf('<');
        String filepath = "";
        while(index > -1){
            while(text.charAt(index + 1) == ' '){index++;}
            if(text.substring( index + 1 , index + 1 + 3 ).contains("img")){
                while(text.charAt(index + 1) != '>' && text.charAt(index + 1) != '"'){index++;}
                if(text.charAt(index + 1) == '"'){
                    filepath = text.substring(index + 2, text.indexOf('"', index + 2)).trim();
                    if(filepath.matches( filepathRegex )){
                        if(!imageSources.contains( filepath )){imageSources.add( filepath );}
                    }
                }
            }
            index = text.indexOf('<', index + 1);
        }
    }

}
