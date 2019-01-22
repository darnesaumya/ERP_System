package ERP_System;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final TopBar tb;
    private final SideBar sb;
    private final CenterPanel cp;
    private final StatusBar stb;

    public MainFrame(String str) {

        setTitle(str);
        setSize(500, 500);
        setLayout(new BorderLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);

        sb = new SideBar();
        tb = new TopBar();
        cp = new CenterPanel();
        stb = new StatusBar();
        add(sb, BorderLayout.WEST);
        add(tb, BorderLayout.NORTH);
        add(cp, BorderLayout.CENTER);
        add(stb, BorderLayout.SOUTH);
    }
}
