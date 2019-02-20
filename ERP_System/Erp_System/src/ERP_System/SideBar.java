package ERP_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SideBar extends JPanel implements MouseListener {

    private JLabel l1, l2, l3;
    int cid;

    public SideBar(int cid) {
        this.cid = cid;
        setBackground(Color.decode("#008db9"));
        setLayout(new FlowLayout());
        l1 = new JLabel("Add Debtor");
        l1.addMouseListener(this);
        l2 = new JLabel("Add Product");
        l2.addMouseListener(this);
        l3 = new JLabel("Add Creditor");
        l3.addMouseListener(this);
        add(l1);
        add(l2);
        add(l3);
        l2.setVisible(false);
        l3.setVisible(false);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == l2)
        {
            AddProduct obj = new AddProduct(cid);
        }
        else if(e.getSource() == l3)
        {
            AddCreditor obj = new AddCreditor(cid);
        }
        else
        {
            AddDebtor obj = new AddDebtor(cid);
        }
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
        l2.setVisible(true);
        l3.setVisible(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exit");
        setSize(50, 657);
        l2.setVisible(false);
        l3.setVisible(false);
    }
}
