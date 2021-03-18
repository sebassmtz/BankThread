package views;

import controllers.Command;
import views.models.JModelButton;
import views.models.JModelProgressBar;
import views.models.JModelTextField;

import javax.swing.*;
import javax.swing.text.DefaultFormatter;
import java.awt.*;
import java.awt.event.ActionListener;

public class JSouthPanel extends JPanel {

    private JModelProgressBar jProgressBar;

    public JSouthPanel(ActionListener actionListener) {
        this.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jProgressBar = new JModelProgressBar(0,675,50,Constant.C_MIDNIGHT_BLUE,Constant.COLOR_RED_LIGHT,actionListener);
        this.add(jProgressBar);
    }

    public void status(long time){
        jProgressBar.actionP(jProgressBar,time);
    }

}
