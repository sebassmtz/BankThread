package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JMainWindows extends JFrame {

    private JMainPanel jMainPanel;

    public JMainWindows(ActionListener actionListener) {
        this.setTitle(Constant.TITTLE_APP);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(700,600));
        this.setIconImage(new ImageIcon(getClass().getResource(Constant.IMG_APP)).getImage());
        initComponents(actionListener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener actionListener) {
        jMainPanel = new JMainPanel(actionListener);
        this.getContentPane().add(jMainPanel);
    }

    public Object[] getValues(){
        return jMainPanel.getValues();
    }

}
