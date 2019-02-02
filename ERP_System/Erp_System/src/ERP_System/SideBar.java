package ERP_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SideBar extends JPanel implements MouseListener {

    private JLabel l1;

    public SideBar(int id) {
        setBackground(Color.decode("#008db9"));
        setLayout(new FlowLayout());
        System.out.println(id);
        l1 = new JLabel();
        l1.setText("Hello his");
        add(l1);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setSize(200, 657);
        System.out.println("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exit");
        setSize(50, 657);
    }
}
