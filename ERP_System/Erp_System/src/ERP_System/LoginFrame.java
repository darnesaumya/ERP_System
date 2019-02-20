package ERP_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginFrame extends JFrame implements ActionListener {

    JTextField cname, ename, pass;
    JLabel name, lname, lpass;
    JButton submit, newcomp;
    ResultSet rs;
    MainFrame mf;

    public LoginFrame() {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        getContentPane().setLayout(gbl);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500, 500);
        name = new JLabel("Company Name");
        lname = new JLabel("Employee Name");
        lpass = new JLabel("Password");
        ename = new JTextField(10);
        pass = new JTextField(10);
        cname = new JTextField(10);
        submit = new JButton("Submit");
        newcomp = new JButton("Register a new Company");
        submit.addActionListener(this);
        newcomp.addActionListener(this);
        // First Column

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(name, gbc);
        gbc.gridy = 1;
        add(lname, gbc);
        gbc.gridy = 2;
        add(lpass, gbc);

        //Second Column
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(cname, gbc);
        gbc.gridy = 1;
        add(ename, gbc);
        gbc.gridy = 2;
        add(pass, gbc);

        //Buttons
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(submit, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(newcomp, gbc);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {
            int id;
            String query;
            String c = cname.getText();
            String n = ename.getText();
            String p = pass.getText();
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection con = DriverManager.getConnection("jdbc:ucanaccess://src\\ERP_System\\Database\\ERPdb.accdb");
                Statement stmt = con.createStatement();
                PreparedStatement pst;
                rs = stmt.executeQuery("Select C_ID from Company where CName = '" + c + "'");
                if (rs.next()) {
                    id = rs.getInt("C_ID");
                    query = "Select E_ID from Employee where C_ID = ? and EName = ? and Password = ? ";
                    pst = con.prepareStatement(query);
                    pst.setInt(1, id);
                    pst.setString(2, n);
                    pst.setString(3, p);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        mf = new MainFrame(n, id);
                        setVisible(false);
                    } else {
                        System.out.println("Login failed");
                    }
                }
            } catch (ClassNotFoundException | SQLException ec) {
                System.out.println(ec);
            }
        }else if(e.getSource() == newcomp)
        {
            NewCompany obj = new NewCompany();
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
