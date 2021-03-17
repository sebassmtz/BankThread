package models;

import structures.queue.Queue;

public class Bank {
    private final long time;
    private UserQueue userQueue;
    private ServiceWindow[] serviceWindows;

    public Bank(int numberWindows, long time) throws InterruptedException {
        this.serviceWindows = new ServiceWindow[numberWindows];
        this.time = time;
        userQueue = new UserQueue(time);
        userQueue.start();
        createWindows();
    }

    public void createWindows() throws InterruptedException {
        int size = serviceWindows.length;
        for (int i = 0; i < size; i++) {
            serviceWindows[i] = new ServiceWindow("Hilo"+(i+1));
            serviceWindows[i].start();
            System.out.println(serviceWindows[i].getName());
        }
    }


}
