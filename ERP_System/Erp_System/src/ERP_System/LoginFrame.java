package ERP_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginFrame extends JFrame implements ActionListener {

    JTextField name, pass;
    JLabel lname, lpass;
    JButton submit, newcomp;
    ResultSet rs;
    boolean flag;
    MainFrame mf;

    public LoginFrame() {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        getContentPane().setLayout(gbl);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setSize(500, 500);
        lname = new JLabel("Name       ");
        lpass = new JLabel("Password");
        name = new JTextField(10);
        pass = new JTextField(10);
        submit = new JButton("Submit");
        newcomp = new JButton("Register a new Company");
        submit.addActionListener(this);
        // First Column

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lname, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lpass, gbc);

        //Second Column
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(name, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(pass, gbc);

        //Buttons
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(submit, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(newcomp, gbc);

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
        } catch (ClassNotFoundException | SQLException ec) {
            System.out.println(ec);
        }
    }

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame();
            }
        });
    }
}
