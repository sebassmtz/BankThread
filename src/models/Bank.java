package models;

import structures.queue.Queue;

public class Bank {
    private Queue<User> usersQueue;
    private ServiceWindow[] serviceWindows;
    private long timeSimulation;

    public Bank(int numberWindows,long time) {
        this.timeSimulation = time;
        this.serviceWindows = new ServiceWindow[numberWindows];
    }
}
