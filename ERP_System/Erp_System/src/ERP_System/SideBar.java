package ERP_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SideBar extends JPanel implements MouseListener {

    public SideBar() {
        setBackground(Color.red);
        setSize(50, 441);
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
        int i = 0;
        while (i < 200) {
            setSize(i, 441);
            System.out.println(i);
            i++;
        }
        System.out.println("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exit");
        int i = 441;
        while (i > 50) {
            setSize(i, 441);
            i--;
        }
    }
}