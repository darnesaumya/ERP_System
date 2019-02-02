package ERP_System;

import javax.swing.*;
import java.awt.*;

public class StatusBar extends JPanel {
    JLabel l1;
    public StatusBar() {
        l1 = new JLabel("Hello");
        l1.setFont(Font.getFont("Times New Roman"));
        setBackground(Color.decode("#00546f"));
        add(l1);
    }
}
