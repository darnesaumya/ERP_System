package ERP_System;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainFrame extends JFrame {

    private final TopBar tb;
    private final SideBar sb;
    private final CenterPanel cp;
    private final StatusBar stb;
    int E_id, cid;
    String sql,Ename;
  

    public MainFrame(int E_id,int cid) {
        this.E_id = E_id;
        BorderLayout bl = new BorderLayout();
        setLayout(bl);
        setSize(1280,720);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://src\\ERP_System\\Database\\ERPdb.accdb");
            sql = "Select EName from Employee where E_ID = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs;
            pst.setInt(1, E_id);
            rs = pst.executeQuery();
            if(rs.next())
            {
                Ename = rs.getString("EName");
            }
        }catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e.getMessage());
        }
        sb = new SideBar(E_id);
        tb = new TopBar(Ename);
        cp = new CenterPanel(cid);
        stb = new StatusBar();
        add(sb, BorderLayout.LINE_START);
        add(tb, BorderLayout.NORTH);
        add(cp, BorderLayout.CENTER);
        add(stb, BorderLayout.SOUTH);
        
    }

//    public static void main(String[] args) {
//        try {
//            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//           } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new MainFrame(2,3);
//            }
//        });
//    }
}
