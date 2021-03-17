package TestPackages;

import models.Bank;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Bank bank = new Bank(4,60000);
        bank.put();
    }
}


