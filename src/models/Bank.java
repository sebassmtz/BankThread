package models;

import structures.queue.Queue;

import java.util.Iterator;
import java.util.stream.IntStream;

public class Bank {
    private UserQueue userQueue;
    private ServiceWindow[] serviceWindows;
    private int[] conts;

    public Bank(int numberWindows, long time) {
        this.serviceWindows = new ServiceWindow[numberWindows];
        this.userQueue = new UserQueue(time);
        userQueue.start();
        createWindows();
        attendPatients();
        conts = countVariables();
    }

    public int[] getConts() {
        return conts;
    }

    public void createWindows(){
        int size = serviceWindows.length;
        IntStream.range(0, size).forEach(i -> {
            serviceWindows[i] = new ServiceWindow("Hilo");
            serviceWindows[i].start();
        });
    }

    public boolean attendPatient(User user){
        int size = serviceWindows.length;
        for (ServiceWindow serviceWindow : serviceWindows) {
            if (serviceWindow.isAvailable()) {
                serviceWindow.setUser(user);
                return true;
            }
        }
        return false;
    }

    public void attendPatients(){
        while (userQueue.isAlive()){
            User user = userQueue.getUserQueue();
            if (user != null){
                boolean attend = false;
                while (!attend){
                    attend = attendPatient(user);
                }
            }
        }
        for (ServiceWindow serviceWindow : serviceWindows) {
            serviceWindow.setLive(false);
        }
    }

    public int[] countVariables(){
        int[] counts = new int[3];
        for (ServiceWindow serviceWindow : serviceWindows) {
            boolean status = true;
            do {
                status = serviceWindow.isAlive();
            } while (status);
            counts[0] += serviceWindow.getCount();
        }
        while (!userQueue.getUsers().isEmpty()){
            userQueue.getUserQueue();
            counts[1]++;
        }
        counts[2] = userQueue.getCountUser();
        return counts;
    }

}
