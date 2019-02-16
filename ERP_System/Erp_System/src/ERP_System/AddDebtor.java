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

public class AddDebtor extends JFrame implements ActionListener {
    
    JLabel l1, l2, l3;
    JButton btn;
    JTextField dbid, dbname, contact;
    String db_name,cont;
    int db_id, cid;

    public AddDebtor(int cid)
    {
        this.cid = cid;
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setSize(400, 650);
        setVisible(true);
        setLayout(gbl);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBackground(Color.WHITE);
        l1 = new JLabel("Debtor ID");
        l2 = new JLabel("Debtor Name");
        l3 = new JLabel("Contact Number");
        dbid = new JTextField(10);
        dbname = new JTextField(10);
        contact = new JTextField(10);
        btn = new JButton("Add Debtor");
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
        add(dbid, gbc);
        gbc.gridy = 1;
        add(dbname, gbc);
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
        db_id = Integer.parseInt(dbid.getText());
        db_name = dbname.getText();
        cont = contact.getText();
        String query = "Insert into Debtor (D_ID,C_ID,D_Name,Contact) values ( ? , ? , ? , ?)";
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://src\\ERP_System\\Database\\ERPdb.accdb");
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, db_id);
            stmt.setInt(2, cid);
            stmt.setString(3, db_name);
            stmt.setString(4, cont);
            stmt.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }

    }
}
