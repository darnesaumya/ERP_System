package ERP_System;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    
    InfoPanel ip1;
    InfoPanel ip2;
    public CenterPanel() {
        setBackground(Color.decode("#e9e9e9"));
        setVisible(true);
        setLayout(new FlowLayout());
        ip1 = new InfoPanel("Red");
        ip2 = new InfoPanel("Blue");
        add(ip1, FlowLayout.LEFT);
        add(ip2, FlowLayout.LEFT);
    }
}
