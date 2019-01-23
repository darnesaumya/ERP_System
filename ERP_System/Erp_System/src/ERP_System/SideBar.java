package ERP_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SideBar extends JPanel implements MouseListener {

    public SideBar() {
        setBackground(Color.red);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override   
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered");
        setSize(100,500);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exit");
        setSize(10,500);
    }
}
