package handler;

import gui.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Michael
 */
public class Key extends KeyAdapter
{
    Frame frame;
    
    public Key(Frame frame)
    {
        this.frame = frame;
    }
    @Override
    public void keyPressed(KeyEvent e)
    {
        
    }
    
}
