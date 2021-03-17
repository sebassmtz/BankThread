package TestPackages;

import models.Bank;


public class Test {
    public static void main(String[] args) {
        Bank bank = new Bank(2,5000);
        System.out.println("Usuarios que se quedaron en la cola: " +bank.getCountQueu());
        System.out.println("Cuantos entraron: " + bank.getCount());
        System.out.println("Usuarios totales: "+ bank.totalUsers());
    }
}


