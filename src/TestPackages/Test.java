package TestPackages;

import models.Bank;


public class Test {
    public static void main(String[] args) {
        Bank bank = new Bank(1,3000);
        System.out.println("Usuarios que se quedaron en la cola: " +bank.getConts()[1]);
        System.out.println("Cuantos entraron: " + bank.getConts()[0]);
        System.out.println("Usuarios totales: "+ bank.getConts()[2]);
    }
}


