package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JMainPanel extends JPanel {

    private JCenterPanel jCenterPanel;
    private JSouthPanel jSouthPanel;

    public JMainPanel(ActionListener actionListener) {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jCenterPanel = new JCenterPanel(actionListener);
        this.add(jCenterPanel,BorderLayout.CENTER);

        jSouthPanel = new JSouthPanel(actionListener);
        this.add(jSouthPanel,BorderLayout.SOUTH);
    }

    public Object[] getValues(){
        return jSouthPanel.getValues();
    }
}
