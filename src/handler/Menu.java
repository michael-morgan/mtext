package handler;

import file.Open;
import file.SaveAs;
import gui.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Menu class handles menu events
 * @author Michael
 */
public class Menu implements ActionListener
{
    private Frame frame;
    
    /**
     * Menu constructor
     * @param frame 
     */
    public Menu(Frame frame)
    {
        this.frame = frame;
    } //end of Menu constructor
    
    /**
     * actionPerformed method
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == frame.menuNew)
        {
            frame.textArea.setText("");
        }
        if(e.getSource() == frame.menuOpen)
        {
            new Open(frame);
        }
        if(e.getSource() == frame.menuSaveAs)
        {
            new SaveAs(frame);
        }
        if(e.getSource() == frame.menuExit)
        {
            System.exit(0);
        }
    } //end of actionPerforme method
    
} //end of Menu class
