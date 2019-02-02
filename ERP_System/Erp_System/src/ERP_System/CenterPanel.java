package ERP_System;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class CenterPanel extends JPanel {

    InfoPanel ip1;
    InfoPanel ip2;
    InfoPanel ip3;
    InfoPanel ip4;
    InfoPanel ip5;
    InfoPanel ip6;

    public CenterPanel() {
        setBackground(Color.decode("#e9e9e9"));
        setVisible(true);
        setLayout(new GridLayout(2, 3));
        ip1 = new InfoPanel();
        ip1.setBorder(new MatteBorder(10, 10, 5, 5, Color.decode("#e9e9e9")));
        ip2 = new InfoPanel();
        ip2.setBorder(new MatteBorder(10, 5, 5, 5, Color.decode("#e9e9e9")));
        ip3 = new InfoPanel();
        ip3.setBorder(new MatteBorder(10, 5, 5, 10, Color.decode("#e9e9e9")));
        ip4 = new InfoPanel();
        ip4.setBorder(new MatteBorder(5, 10, 10, 5, Color.decode("#e9e9e9")));
        ip5 = new InfoPanel();
        ip5.setBorder(new MatteBorder(5, 5, 10, 5, Color.decode("#e9e9e9")));
        ip6 = new InfoPanel();
        ip6.setBorder(new MatteBorder(5, 5, 10, 10, Color.decode("#e9e9e9")));
        add(ip1);
        add(ip2);
        add(ip3);
        add(ip4);
        add(ip5);
        add(ip6);
        //  repaint();
    }
}
