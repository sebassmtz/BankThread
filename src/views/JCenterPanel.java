package views;

import views.models.JModelLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JCenterPanel extends JPanel {

    private JModelLabel totalUsers,stayQueue,passQueue,totalTime,enabledPoints;

    public JCenterPanel(ActionListener actionListener) {
        this.setLayout(new GridLayout(4,1));
        this.setBorder(BorderFactory.createEmptyBorder(10,40,10,40));
        this.setBackground(Constant.COLOR_WHITE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {

        enabledPoints = new JModelLabel("Enabled Number: ",Constant.IMG_EXIT,Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_BLACK,Constant.COLOR_BLUE_DARK,25,25);
        this.add(enabledPoints);

        totalUsers = new JModelLabel("Total Users: ",Constant.IMG_EXIT,Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_BLACK,Constant.COLOR_BLUE_DARK,25,25);
        this.add(totalUsers);

        stayQueue = new JModelLabel("Stay Queue: ",Constant.IMG_EXIT,Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_BLACK,Constant.COLOR_BLUE_DARK,25,25);
        this.add(stayQueue);

        passQueue = new JModelLabel("Enter the bank: ",Constant.IMG_EXIT,Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_BLACK,Constant.COLOR_BLUE_DARK,25,25);
        this.add(passQueue);

        totalTime = new JModelLabel("Total time: ",Constant.IMG_EXIT,Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_BLACK,Constant.COLOR_BLUE_DARK,25,25);
        this.add(totalTime);

        JModelLabel ok = new JModelLabel("Statistics",Constant.IMG_EXIT,Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_BLACK,Constant.COLOR_BLUE_DARK,25,25);
        this.add(ok);
    }

    public void setLabels(Object[] counts){
        enabledPoints.setText("Enabled Number: "+ counts[0]);

        totalUsers.setText("Total Users: "+ counts[1]);

        stayQueue.setText("Stay Queue: "+ counts[2]);

        passQueue.setText("Enter the bank: "+ counts[3]);

        totalTime.setText("Total time: "+ counts[4]);

    }
}
