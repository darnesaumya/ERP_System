package ERP_System;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final TopBar tb;
    private final SideBar sb;
    private final CenterPanel cp;
    private final StatusBar stb;
    int cid;
    String sql,Ename;
  

    public MainFrame(String Ename,int cid) {
        this.Ename = Ename;
        this.cid = cid;
        BorderLayout bl = new BorderLayout();
        setLayout(bl);
        setSize(1280,720);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        sb = new SideBar(this.cid);
        tb = new TopBar(this.Ename);
        cp = new CenterPanel(this.cid);
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
//                new MainFrame("ABC",3);
//            }
//        });
//    }
}
