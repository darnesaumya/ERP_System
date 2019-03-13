package ERP_System;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PlaceOrder extends JFrame implements ActionListener {

    JTextField tf1, tf2, tf3;
    JLabel l1, l2, l3;
    JButton btn;
    String crName, iName;
    int quantity, c_id, cr_id;
    Connection con;
    ResultSet rs;
    Statement stmt;
    PreparedStatement pst;

    public PlaceOrder(int c_id) {
        this.c_id = c_id;
        setSize(400, 650);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        setBackground(Color.white);
        setVisible(true);
        l1 = new JLabel("Creditor Name");
        l2 = new JLabel("Item Name");
        l3 = new JLabel("Quantity");
        tf1 = new JTextField(10);
        tf2 = new JTextField(10);
        tf3 = new JTextField(10);
        btn = new JButton("Place Order");
        btn.addActionListener(this);

        gbc.weighty = 0.01;

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
        add(tf1, gbc);
        gbc.gridy = 1;
        add(tf2, gbc);
        gbc.gridy = 2;
        add(tf3, gbc);

        //Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(btn, gbc);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        crName = tf1.getText();
        iName = tf2.getText();
        quantity = Integer.parseInt(tf3.getText());
        String query = "Select Cr_ID from Creditor where Cr_name = '" + crName + "'";
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://src\\ERP_System\\Database\\ERPdb.accdb");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                cr_id = rs.getInt("Cr_ID");
                query = "Insert into Order(C_ID, Cr_ID, Item, Quantity) values(?,?,?,?)";
                pst = con.prepareStatement(query);
                pst.setInt(1, c_id);
                pst.setInt(2, cr_id);
                pst.setString(3, crName);
                pst.setInt(4, quantity);
                if (pst.execute()) {
                    System.out.println("Error in executing query");
                } else {
                    System.out.println("Success");
                }
            } else {
                System.out.println("Invalid Creditor Name");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
}
