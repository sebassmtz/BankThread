package models;

import structures.queue.Queue;

public class Bank {
    private UserQueue userQueue;
    private ServiceWindow[] serviceWindows;

    public Bank(int numberWindows, long time) {
        this.serviceWindows = new ServiceWindow[numberWindows];
        this.userQueue = new UserQueue(time);
        userQueue.start();
        createWindows();
        attendPatients();
    }

    public void createWindows(){
        int size = serviceWindows.length;
        for (int i = 0; i < size; i++) {
            serviceWindows[i] = new ServiceWindow("Hilo"+i);
            serviceWindows[i].start();
        }
    }

    public boolean attendPatient(User user){
        int size = serviceWindows.length;
//        System.out.println("userEntry:" +user.getName()+"-"+user.getRequestType());
        for (int i = 0; i < size; i++) {
            if (serviceWindows[i].isAvailable()){
//                System.out.println("toSetUser-----------------------------------");
                serviceWindows[i].setUser(user);
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
//                System.out.println("user-->"+user.getName()+"-"+user.getRequestType());
            }
        }
        for (int i = 0; i < serviceWindows.length; i++) {
            serviceWindows[i].setLive(false);
        }
    }

}
