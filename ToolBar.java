import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ToolBar {

    JToolBar toolbar;
    Container container;
    JFrame frame;

    public ToolBar(JFrame frame) {
        this.toolbar = new JToolBar();
        this.container = frame.getContentPane();
        this.frame = frame;
        this.init();
        this.userList();
    }

    public void reinit(){
        this.container.removeAll();
        this.init();
        this.container.repaint();
    }


    public void init() {

        JButton button;
        
        toolbar.removeAll();
        button = new JButton(getIcon("icons/user-plus.png", 20, 20));
        button.setToolTipText("Add a new file");
        button.addActionListener((e) -> this.addUser());
        this.toolbar.add(button);

        button = new JButton(getIcon("icons/users.png", 20, 20));
        button.setToolTipText("Add a new file");
        button.addActionListener((e) -> this.userList());
        this.toolbar.add(button);

        this.container.add(this.toolbar, BorderLayout.NORTH);
    }


    private ImageIcon getIcon(String src, int width, int height) {
        ImageIcon nextIcon = new ImageIcon(src);
        Image image = nextIcon.getImage();
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    public void addUser(){
        //System.out.println("Kliknięto dodaj klienta");
        this.reinit();
        ClientAdd ca = new ClientAdd(this.frame, new Client(), new Clients());
        ca.getForm();
        this.frame.validate();
    }

    public void userList() {
        //System.out.println("Kliknięto listę klientów");
        this.reinit();
        Table table = new Table(this.frame);
        table.table();
        this.frame.validate();
    }
}