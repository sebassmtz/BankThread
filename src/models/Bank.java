package models;

import structures.queue.Queue;

public class Bank {
    private UserQueue userQueue;
    private ServiceWindow[] serviceWindows;

    public Bank(int numberWindows, long time) {
        this.serviceWindows = new ServiceWindow[numberWindows];
        this.userQueue = new UserQueue(time);
        userQueue.start();
    }

    public void put(){
        int size = serviceWindows.length;
        for (int i = 0; i < size; i++) {
            serviceWindows[i] = new ServiceWindow("Hilo"+i);
            serviceWindows[i].start();
            if (serviceWindows[i].isAvailable()){
                serviceWindows[i].setUser(userQueue.getUserQueue());

                System.out.println("-"+ serviceWindows[i].getUser().getName());
            }
        }
    }

}
