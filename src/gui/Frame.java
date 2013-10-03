package gui;

import handler.Key;
import handler.Menu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Michael
 */
public class Frame extends JFrame implements Runnable
{
    public Thread loop;
    
    public boolean run;
    
    public final Dimension SIZE = new Dimension(800, 600);
    
    private JPanel panel;
    private JMenuBar menuBar;
    private JMenu menu;
    public JMenuItem menuNew, menuOpen, menuSaveAs, menuExit;
    public JTextArea textArea;
    public JLabel page, words;
    private JScrollPane textAreaScroll;
    
    public int currentPage, maxPage, currentWords, maxWords;
    
    /**
     * Frame constructor
     */
    public Frame()
    {
        this.setSize(SIZE);
        this.setTitle("mText || Michael");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        init();
        
        this.setVisible(true);
    } //end of frame constructor
    
    /**
     * init method
     */
    private void init()
    {
        initVariables();
        addComponents();
        
        loop.start();
        run = true;
    } //end of init method
    
    /**
     * initVariables method
     */
    private void initVariables()
    {
        loop = new Thread(this);
        run = false;
        maxPage = 1;
        currentPage = 1;
        maxWords = 0;
        currentWords = 0;
    } //end of initVariables method
    
    /**
     * addComponents method
     */
    private void addComponents()
    {
        panel = new JPanel();
        JPanel leftPanel = new JPanel();
        JPanel statusPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        
        panel.setLayout(new BorderLayout());
        statusPanel.setLayout(new GridLayout(1, 2));
        centerPanel.setLayout(null);
        
        rightPanel.setPreferredSize(new Dimension(150, 560));
        leftPanel.setPreferredSize(new Dimension(150, 560));
        statusPanel.setPreferredSize(new Dimension(825, 25));
        centerPanel.setPreferredSize(new Dimension(825, 560));
        
        leftPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setBackground(Color.LIGHT_GRAY);
        statusPanel.setBackground(Color.WHITE);
        
        statusPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY));
        
        menuBar = new JMenuBar();
        
        menu = new JMenu("File");
        
        menuNew = new JMenuItem("New");
        menuOpen = new JMenuItem("Open");
        menuSaveAs = new JMenuItem("Save as..");
        menuExit = new JMenuItem("Exit");
        
        menuNew.addActionListener(new Menu(this));
        menuOpen.addActionListener(new Menu(this));
        menuSaveAs.addActionListener(new Menu(this));
        menuExit.addActionListener(new Menu(this));
        
        menu.add(menuNew);
        menu.add(menuOpen);
        menu.add(menuSaveAs);
        menu.add(menuExit);
        
        menuBar.add(menu);
        
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.addKeyListener(new Key(this));
        
        textAreaScroll = new JScrollPane(textArea);
        textAreaScroll.setBounds(2, 5, 490, 514);
        
        page = new JLabel("Page: " + currentPage + " of " + maxPage);
        words = new JLabel("Words: " + maxWords);
        
        statusPanel.add(page);
        statusPanel.add(words);
        centerPanel.add(textAreaScroll);
        
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(leftPanel, BorderLayout.WEST);
        panel.add(rightPanel, BorderLayout.EAST);
        panel.add(statusPanel, BorderLayout.SOUTH);
        panel.add(menuBar, BorderLayout.NORTH);
        
        add(panel);  
    } //end of addComponents method
    
    /**
     * setWordCount method
     */
    public void setWordCount()
    {
        maxWords = (textArea.getText().length() - textArea.getText().replaceAll(" ","").length());
        words.setText("Words: " + maxWords);
    } //end of setWordCount method
    
    /**
     * setPageCount method
     */
    private void setPageCount()
    {
        if(maxWords > 2310)
        {
            maxPage = maxWords / 2310;
            currentPage = maxPage;
        }
        else
        {
            maxPage = 1;
            currentPage = maxPage;
        }
        
        page.setText("Page: " + currentPage + " of " + maxPage);
    } //end of setPageCount method
    
    /**
     * run method
     */
    @Override
    public void run()
    {
        while(run)
        {
            setWordCount();
            setPageCount();
            
            try
            {
                Thread.sleep(20);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    } //end of run method
    
} //end of class