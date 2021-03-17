package models;

import structures.queue.Queue;

import java.util.Iterator;

public class Bank {
    private UserQueue userQueue;
    private ServiceWindow[] serviceWindows;
    private int count = 0,countQueu = 0;

    public int getCount() {
        return count;
    }

    public int getCountQueu() {
        return countQueu;
    }

    public Bank(int numberWindows, long time) {
        this.serviceWindows = new ServiceWindow[numberWindows];
        this.userQueue = new UserQueue(time);
        userQueue.start();
        createWindows();
        attendPatients();
    }

    public int totalUsers(){
        return userQueue.getCountUser();
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
        for (ServiceWindow serviceWindow : serviceWindows) {
            serviceWindow.setLive(false);
        }
        for (ServiceWindow serviceWindow : serviceWindows) {
            while (serviceWindow.isAlive()){
            }
            count += serviceWindow.getCount();
        }
        int count1 = 0;
//        Iterator<User> ok = userQueue.getUsers().iterator();
        while (!userQueue.getUsers().isEmpty()){
            userQueue.getUserQueue();
//            User chet= ok.next();
//            System.out.println("Sobraron:" + chet.getName());
            countQueu++;
        }
    }

}
