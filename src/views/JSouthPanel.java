package views;

import controllers.Command;
import views.models.JModelButton;
import views.models.JModelTextField;

import javax.swing.*;
import javax.swing.text.DefaultFormatter;
import java.awt.*;
import java.awt.event.ActionListener;

public class JSouthPanel extends JPanel {

    private JModelButton jButtonInitial;
    private JModelTextField jTFTime;
    private JSpinner jsValue;

    public JSouthPanel(ActionListener actionListener) {
        this.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Constant.COLOR_BLUE_LIGHT_G);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {

        jTFTime = new JModelTextField("Time","Login Time",Constant.FONT_ARIAL_ROUNDER_15,Constant.COLOR_WHITE);
        jTFTime.validateNum(jTFTime);
        this.add(jTFTime);



        jsValue = new JSpinner(new SpinnerNumberModel(2, 1,8, 1));
        ((DefaultFormatter) ((JSpinner.NumberEditor)jsValue.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        jsValue.setBorder(BorderFactory.createTitledBorder("Windows"));
        jsValue.setPreferredSize(new Dimension(80,40));
        jsValue.setBackground(Constant.COLOR_WHITE);
        this.add(jsValue);

        jButtonInitial = new JModelButton("Iniciar ",Constant.IMG_REFRESH,25,25,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        jButtonInitial.setActionCommand(Command.INIT_SIMULATION.toString());
        jButtonInitial.addActionListener(actionListener);
        this.add(jButtonInitial);
    }


    public Object[] getValues(){
        return new Object[]{jTFTime.getText(),jsValue.getValue()};
    }
}
