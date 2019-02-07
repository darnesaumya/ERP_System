package ERP_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.MatteBorder;

public class InfoPanel extends JPanel implements ActionListener {

    JLabel label;
    JPanel panel;
    String head;

    public InfoPanel(String head) {
        this.head = head;
        setVisible(true);
        setBackground(Color.decode("#b2cbd3"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        panel = new JPanel();
        label = new JLabel(this.head);
        label.setBorder(new MatteBorder(8, 8, 8, 8, Color.decode("#b2cbd3")));
        panel.setBackground(Color.white);
        panel.setBorder(new MatteBorder(8, 8, 8, 8, Color.decode("#b2cbd3")));
        add(label, CENTER_ALIGNMENT);
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
