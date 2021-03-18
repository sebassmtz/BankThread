package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JMainPanel extends JPanel {

    private JCenterPanel jCenterPanel;
    private JNorthPanel jNorthPanel;
    private JSouthPanel jSouthPanel;

    public JMainPanel(ActionListener actionListener) {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jNorthPanel = new JNorthPanel(actionListener);
        this.add(jNorthPanel,BorderLayout.NORTH);

        jCenterPanel = new JCenterPanel(actionListener);
        this.add(jCenterPanel,BorderLayout.CENTER);

        jSouthPanel = new JSouthPanel(actionListener);
        this.add(jSouthPanel,BorderLayout.SOUTH);

    }

    public void status(long time){
        jSouthPanel.status(time);
    }

    public void setLabels(Object[] counts){
        jCenterPanel.setLabels(counts);
    }

    public Object[] getValues(){
        return jNorthPanel.getValues();
    }
}
