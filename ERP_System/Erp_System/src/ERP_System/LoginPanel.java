package ERP_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginPanel extends JFrame implements ActionListener {

    JTextField name, pass;
    JButton submit;
    ResultSet rs;
    boolean flag;
    MainFrame mf;

    public LoginPanel() {
        setLayout(new FlowLayout());
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,500);
        name = new JTextField(10);
        pass = new JTextField(10);
        submit = new JButton("Submit");
        submit.addActionListener(this);
        add(name);
        add(pass);
        add(submit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String n = name.getText();
        String p = pass.getText();
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://src\\ERP_System\\Database\\ERPdb.accdb");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from Login where UName = '" + n + "' and Password = '" + p + "'");
            if (rs.next()) {
                flag = true;
                mf = new MainFrame("hello");
                setVisible(false);
            } else {
                flag = false;
                System.out.println("Login failed");
            }
        } catch (Exception ec) {
            System.out.println(ec);
        }

    }
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginPanel();
            }
        });
    }
}
