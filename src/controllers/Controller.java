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
            long time = Long.parseLong(t);
            int number = (Integer.parseInt(String.valueOf(objects[1])))*1000;
            bank = new Bank(number,time);
        }else {
            JOptionPane.showMessageDialog(null,"No hay tiempo");
        }
    }
}
