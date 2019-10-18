import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.table.TableModel;

public class Table {

    Container container;

    public Table(JFrame frame) {
    	this.container = frame.getContentPane();
    }

    public void table() {
        Clients t = new Clients();
        
        TableModel model = new ClientTable(t);
        JTable table = new JTable(model);

        table.addMouseListener(new java.awt.event.MouseAdapter()
            {
                public void mouseClicked(java.awt.event.MouseEvent e)
                {
                    int row = table.rowAtPoint(e.getPoint());
                 //   System.out.println(row );

                    JFrame frame = new JFrame();
                    frame.setTitle("Edytuj kilenta");
                    frame.setSize(750,514);
                    Clients clients = new Clients();
                            
                    ClientAdd ca = new ClientAdd(frame, clients.getFromList(row), clients);
                    ca.getForm();
                    frame.setVisible(true);
                    frame.validate();
                }
            }
        );

        JScrollPane sp = new JScrollPane(table);
        this.container.add(sp, BorderLayout.CENTER);
    }
}