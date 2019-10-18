import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Layout {

    JFrame frame;

    public Layout() {
        frame = new JFrame("Zarządzanie klientami");
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(750, 550);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
        new MenuBar(frame);
        new ToolBar(frame);

        frame.setVisible(true);
    }


    private void alert(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title,
            JOptionPane.INFORMATION_MESSAGE);
    }



}