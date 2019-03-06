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

public class AddEmployee extends JFrame implements ActionListener {

    String Ename, pass, desig, contact;
    int eid, age, salary;
    int cid;
    JTextField E_id, E_name, Password, Age, Desig, Salary, Contact;
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JButton btn;
    Connection con;
    PreparedStatement pst;

    public AddEmployee(String Ename, int cid) {
        this.Ename = Ename;
        this.cid = cid;
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setSize(400, 650);
        setVisible(true);
        setLayout(gbl);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBackground(Color.WHITE);
        l1 = new JLabel("Employee ID");
        l2 = new JLabel("Employee Name");
        l3 = new JLabel("Password");
        l4 = new JLabel("Age");
        l5 = new JLabel("Designation");
        l6 = new JLabel("Salary");
        l7 = new JLabel("Contact");

        E_id = new JTextField(10);
        E_name = new JTextField(10);
        E_name.setText(Ename);
        Password = new JTextField(10);
        Age = new JTextField(10);
        Desig = new JTextField(10);
        Salary = new JTextField(10);
        Contact = new JTextField(10);
        
        btn = new JButton("Add");

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
        gbc.gridy = 3;
        add(l4, gbc);
        gbc.gridy = 4;
        add(l5, gbc);
        gbc.gridy = 5;
        add(l6, gbc);
        gbc.gridy = 6;
        add(l7, gbc);

        //Second Column
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(E_id, gbc);
        gbc.gridy = 1;
        add(E_name, gbc);
        gbc.gridy = 2;
        add(Password, gbc);
        gbc.gridy = 3;
        add(Age, gbc);
        gbc.gridy = 4;
        add(Desig, gbc);
        gbc.gridy = 5;
        add(Salary, gbc);
        gbc.gridy = 6;
        add(Contact, gbc);

        //Button
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(btn, gbc);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        eid = Integer.parseInt(E_id.getText());
        Ename = E_name.getText();
        pass = Password.getText();
        age = Integer.parseInt(Age.getText());
        desig = Desig.getText();
        salary = Integer.parseInt(Salary.getText());
        contact = Contact.getText();
        String query = "Insert into Employee (E_ID, C_ID, EName, Password, Age, Designation, Salary, Contact_no) values (?, ?, ?, ?, ?, ?, ? ,?)";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://src\\ERP_System\\Database\\ERPdb.accdb");
            pst = con.prepareStatement(query);
            pst.setInt(1, eid);
            pst.setInt(2, cid);
            pst.setString(3, Ename);
            pst.setString(4, pass);
            pst.setInt(5, age);
            pst.setString(6, desig);
            pst.setInt(7, salary);
            pst.setString(8, contact);
            if (!pst.execute()) {
                System.out.println("Success");
            } else {
                System.out.println("Error in executing query");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
