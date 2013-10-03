package handler;

import file.Open;
import file.SaveAs;
import gui.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key class handles key events
 * @author Michael
 */
public class Key extends KeyAdapter
{
    private Frame frame;
    
    public Key(Frame frame)
    {
        this.frame = frame;
    }
    
    /**
     * keyPressed method
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
        if((e.getKeyCode() == e.VK_CONTROL) && (e.getKeyCode() == e.VK_S))
        {
            new SaveAs(frame);
        }
        if((e.getKeyCode() == e.VK_CONTROL) && (e.getKeyCode() == e.VK_N))
        {
            new Open(frame);
        }
    }
    
}
