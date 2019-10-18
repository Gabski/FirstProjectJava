import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuBar {

    public MenuBar(JFrame frame) {
        this.init(frame);
    }

    public void init(JFrame frame){
        JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        //menuBar.setBackground(new Color(154, 165, 127));
        menuBar.setPreferredSize(new Dimension(200, 20));
        JMenu fileMenu = new JMenu("Program"); 
        menuBar.add(fileMenu); 
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        //fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        frame.setJMenuBar(menuBar);
    }
}