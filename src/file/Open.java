package file;

import gui.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class Open
{

    private File file;
    private Frame frame;
    
    public Open(Frame frame, File file)
    {
        this.frame = frame;
        this.file = file;
        init();
    }
    
    private void init()
    {
        openFile();
    }
    
    private void openFile()
    {
        try(Scanner scanner = new Scanner(file))
        {
            frame.textArea.setText(scanner.);
            
            scanner.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    
    
}
