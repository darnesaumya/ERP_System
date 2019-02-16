package ERP_System;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddCreditor extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JButton btn;
    JTextField crid, crname, contact;
    String cr_name,cont;
    int cr_id, cid;

    public AddCreditor(int cid) {
        this.cid = cid;
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setSize(400, 650);
        setVisible(true);
        setLayout(gbl);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBackground(Color.WHITE);
        l1 = new JLabel("Creditor ID");
        l2 = new JLabel("Creditor Name");
        l3 = new JLabel("Contact Number");
        crid = new JTextField(10);
        crname = new JTextField(10);
        contact = new JTextField(10);
        btn = new JButton("Add Creditor");
        btn.addActionListener(this);

        gbc.weighty = 0.001;

        //First Column
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(l1, gbc);
        gbc.gridy = 1;
        add(l2, gbc);
        gbc.gridy = 2;
        add(l3, gbc);

        //Second Column
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(crid, gbc);
        gbc.gridy = 1;
        add(crname, gbc);
        gbc.gridy = 2;
        add(contact, gbc);

        //Button
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(btn, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cr_id = Integer.parseInt(crid.getText());
        cr_name = crname.getText();
        cont = contact.getText();
        String query = "Insert into Creditor (Cr_ID,C_ID,Cr_Name,Contact) values ( ? , ? , ? , ?)";
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://src\\ERP_System\\Database\\ERPdb.accdb");
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, cr_id);
            stmt.setInt(2, cid);
            stmt.setString(3, cr_name);
            stmt.setString(4, cont);
            stmt.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

}
