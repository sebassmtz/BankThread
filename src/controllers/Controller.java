package controllers;

import models.Bank;
import views.JMainWindows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private JMainWindows jMainWindows;
    private Bank bank;

    public Controller() {
        jMainWindows = new JMainWindows(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())){
            case INIT_SIMULATION: initSimulation(); break;
            default: break;
        }
    }

    public void rePaintCenter(){

    }

    private void initSimulation() {

        Object[] objects = jMainWindows.getValues();
        if (!objects[0].equals("")){
            String t = String.valueOf(objects[0]);
            long time = Long.parseLong(t)*1000;
            jMainWindows.status(10);
            int number = Integer.parseInt(String.valueOf(objects[1]));
            bank = new Bank(number,time);

            Object[] counts ={
                number,bank.getConts()[2],bank.getConts()[1],bank.getConts()[0],
                    (int)bank.getTotalTime()
            };

            jMainWindows.setLabels(counts);
        }else {
            JOptionPane.showMessageDialog(null,"No hay tiempo");
        }
    }
}
