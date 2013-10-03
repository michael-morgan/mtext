package file;

import gui.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 * Open class object opens a file.
 * @author Michael
 */
public class Open
{
    private Frame frame;
    
    /**
     * Open constructor
     * @param frame 
     */
    public Open(Frame frame)
    {
        this.frame = frame;
        openFile();
    } //end of Open constructor
    
    /**
     * openFile method
     */
    private void openFile()
    {
        try
        {
            File file = new File("");
            JFileChooser fileChosen = new JFileChooser();

            if(fileChosen.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                file = fileChosen.getSelectedFile();
            }

            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            
            line = in.readLine();
            while(line != null)
            {
                frame.textArea.append(line + "\n");
                line = in.readLine();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    } //end of openFile method
    
} //end of Open class
