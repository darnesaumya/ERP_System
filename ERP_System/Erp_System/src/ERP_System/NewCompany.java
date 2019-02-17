package ERP_System;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewCompany extends JFrame implements ActionListener {
    
    int cid;
    JLabel l1,l2,l3,l4,l5,l6;
    String CName,owner,address,gst,email,contact;
    public NewCompany()
    {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setSize(400, 650);
        setVisible(true);
        setLayout(gbl);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBackground(Color.WHITE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
