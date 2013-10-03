package handler;

import gui.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Michael
 */
public class Menu implements ActionListener
{
    private Frame frame;
    
    public Menu(Frame frame)
    {
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == frame.menuNew)
        {
            frame.textArea.setText("");
        }
        if(e.getSource() == frame.menuOpen)
        {
            
        }
        if(e.getSource() == frame.menuSave)
        {
            
        }
        if(e.getSource() == frame.menuSaveAs)
        {
            
        }
        if(e.getSource() == frame.menuExit)
        {
            System.exit(0);
        }
    }

}
