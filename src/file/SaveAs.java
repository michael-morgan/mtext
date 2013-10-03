package file;

import gui.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Michael
 */
public class SaveAs
{
    private Frame frame;
    
    /**
     * SaveAs constructor
     * @param frame 
     */
    public SaveAs(Frame frame)
    {
        this.frame = frame;
        saveFileAs();
    } //end of SaveAs constructor
    
    /**
     * saveFileAs method
     */
    private void saveFileAs()
    {
        String text = frame.textArea.getText();
        JFileChooser fileChosen = new JFileChooser();
        
        int actionId = fileChosen.showSaveDialog(null);
        if (actionId == JFileChooser.APPROVE_OPTION)
        {
            File file = new File(fileChosen.getSelectedFile() + ".mText");

            if(file.exists())
            {
                actionId = JOptionPane.showConfirmDialog(null, "Replace existing file?");
                
                if (actionId == JOptionPane.NO_OPTION)
                {
                    return;
                }
            }
            try
            {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));

                writer.write(text);
                writer.close();
            }
            catch(Exception e)
            {
                 e.printStackTrace();
            }
        }
    } //end of saveFileAs method
    
} //end of SaveAs class