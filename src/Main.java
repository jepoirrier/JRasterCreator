/*
 * Main.java
 *
 * Created on 20 décembre 2006, 23:02
 *
 */

package rastercreator;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Jean-Etienne
 */
public class Main {
    
    private static rasterCollection rcol = new rasterCollection();
    
    /** Constructor */
    public Main() {}
    
    /* main function */
    public static void main(String[] args) {
//        ArrayList rpList = new ArrayList();
        JFrame frame = new JFrame("JRasterCreator - v.0.1");
        // The following 2 lines do'nt work when outside a JAR file !!!
        URL imgURL = ClassLoader.getSystemResource("rastercreator/jr.png");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(imgURL));
        
        // Menu bar
        JMenu rcMenuFile = new JMenu("File");
        rcMenuFile.setMnemonic(KeyEvent.VK_F);
        JMenuItem rcMenuSave = new JMenuItem("Save", KeyEvent.VK_S);
        rcMenuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        rcMenuSave.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { save(); } });
        rcMenuFile.add(rcMenuSave);
        JMenuItem rcMenuQuit = new JMenuItem("Quit", KeyEvent.VK_Q);
        rcMenuQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
        rcMenuQuit.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { System.exit(0); } });
        rcMenuFile.add(rcMenuQuit);
        
        JMenu rcMenuHelp = new JMenu("Help");
        rcMenuHelp.setMnemonic(KeyEvent.VK_H);
        JMenuItem rcMenuAbout = new JMenuItem("About", KeyEvent.VK_A);
        rcMenuAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
        rcMenuAbout.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { about(); } });
        rcMenuHelp.add(rcMenuAbout);
        
        JMenuBar rcMenuBar = new JMenuBar();
        rcMenuBar.add(rcMenuFile);
        rcMenuBar.add(rcMenuHelp);
        frame.setJMenuBar(rcMenuBar);
        
        // Left panel = collection of rasterPoints
        JPanel leftPanel = new JPanel();
        leftPanel.setSize(530, 530);
        leftPanel.setBackground(Color.WHITE);
        // go through the list of rasterPoints and display them in leftPanel
        ArrayList tmpList = rcol.getList();
        Iterator itr = tmpList.iterator();
        while(itr.hasNext()) {
            rasterPoint rp = (rasterPoint)itr.next();
            leftPanel.add(rp);
        }
        
        // Right panel = options
//        JPanel rightPanel = new JPanel();
//        JButton clearBtn = new JButton("Clear All");
//        clearBtn.setToolTipText("Revert all positions to blank");
//        clearBtn.setMnemonic('C');
//        clearBtn.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent e) {
//                        clearAction();
//                }
//            }
//        );
//        rightPanel.setSize(200, 530);
//        rightPanel.add(clearBtn);
//        frame.add(rightPanel);
        
        frame.add(leftPanel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        frame.setSize(550, 600); // frame.pack(); // let the system define the best window size
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    private static void clearAction() {
        rcol.clear();
    }
    
    private static void save() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setDialogTitle("Save raster file ...");
        rasterFilter filter = new rasterFilter();
        chooser.setFileFilter(filter);
        chooser.addChoosableFileFilter(filter);
        int returnVal = chooser.showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                rcol.save(chooser.getSelectedFile().getAbsolutePath());//getName());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private static void about() {
        JOptionPane.showMessageDialog(null,
                "<html>JRasterCreator creates raster files for MS equipments<p>Written by Jean-Etienne Poirrier (jepoirrier@gmail.com)<p>http://www.poirrier.be/~jean-etienne/",
                "About JRasterCreator ...",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void testCodeCommandLine() {
        // Test code
        Random generator = new Random(); // http://www.cs.geneseo.edu/~baldwin/reference/random.html
        ArrayList testlist = new ArrayList();
        for(double x = -1; x <= 1; x = x + 0.1){
            for(double y = 1; y >= -1; y = y - 0.1) {
                int randomIndex = generator.nextInt(2);
                if(randomIndex==0)
                    testlist.add(new rasterPoint(x, y, false));
                else
                    testlist.add(new rasterPoint(x, y, true));
            }
        }
        // display them
        Iterator itr = testlist.iterator();
        while(itr.hasNext()) {
            rasterPoint rp = (rasterPoint)itr.next();
            System.out.println(rp.toString());
        }
    }
    
}
