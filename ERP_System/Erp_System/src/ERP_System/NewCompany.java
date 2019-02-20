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

public class NewCompany extends JFrame implements ActionListener {

    int cid;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField C_Name, Owner, Address, GST, Email, Contact;
    JButton submit;
    String CName, owner, address, gst, email, contact;
    Connection con;
    Statement stmt;
    ResultSet rs;
    Verification obj;

    public NewCompany() {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setSize(400, 650);
        setVisible(true);
        setLayout(gbl);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBackground(Color.WHITE);
        l1 = new JLabel("Company Name");
        l2 = new JLabel("Owner Name");
        l3 = new JLabel("Company Address");
        l4 = new JLabel("GST number");
        l5 = new JLabel("Email address");
        l6 = new JLabel("Contact Number");
        C_Name = new JTextField(10);
        Owner = new JTextField(10);
        Address = new JTextField(10);
        GST = new JTextField(10);
        Email = new JTextField(10);
        Contact = new JTextField(10);
        submit = new JButton("Register");
        submit.addActionListener(this);

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
        gbc.gridy = 3;
        add(l4, gbc);
        gbc.gridy = 4;
        add(l5, gbc);
        gbc.gridy = 5;
        add(l6, gbc);

        //Second Column
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(C_Name, gbc);
        gbc.gridy = 1;
        add(Owner, gbc);
        gbc.gridy = 2;
        add(Address, gbc);
        gbc.gridy = 3;
        add(GST, gbc);
        gbc.gridy = 4;
        add(Email, gbc);
        gbc.gridy = 5;
        add(Contact, gbc);

        //Button
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(submit, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CName = C_Name.getText();
        owner = Owner.getText();
        gst = GST.getText();
        address = Address.getText();
        email = Email.getText();
        contact = Contact.getText();
        obj = new Verification();
        if (obj.verifyGST(gst) && obj.verifyEmail(email) && obj.verifyNumber(contact)) {
            String query = "Select max (C_ID) from Company";
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                con = DriverManager.getConnection("jdbc:ucanaccess://src\\ERP_System\\Database\\ERPdb.accdb");
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    cid = rs.getInt(1);
                }
                cid++;
                System.out.println(cid);
                query = "Insert into Company (C_ID, CName, Owner, HQ_Address, GST_No, Email, Contact_No)  values (?,?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, cid);
                pst.setString(2, CName);
                pst.setString(3, owner);
                pst.setString(4, address);
                pst.setString(5, gst);
                pst.setString(6, email);
                System.out.println("Hello");
                pst.setString(7, contact);
                if(pst.execute())
                {
                    System.out.println("Error in executing query");
                }
                else
                {
                    MainFrame mainFrame = new MainFrame(owner, cid);
                    AddEmployee addEmployee = new AddEmployee(owner,cid);
                    setVisible(false);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex);
            }
        } else {
            if (obj.verifyEmail(email) == false) {
                System.out.println("Check the email address entered");
            } else if (obj.verifyGST(gst) == false) {
                System.out.println("Check the GST number entered");
            } else {
                System.out.println("Check the phone number entered");
            }
        }
    }
}
