package ERP_System;

import javax.swing.*;
import java.awt.*;

public class TopBar extends JPanel {

    JLabel l1;

    public TopBar() {
        l1 = new JLabel("Hello");
        l1.setForeground(Color.WHITE);
        setBackground(Color.decode("#23282a"));
        add(l1);
    }
}
