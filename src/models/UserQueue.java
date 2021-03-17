package models;

import structures.queue.Queue;

import java.util.Iterator;

public class UserQueue extends Thread{
    private Queue<User> users;
    private long time;

    public UserQueue(long time) {
        this.users = new Queue<>(User::compare);
        this.time = time;
    }

    @Override
    public void run() {
        boolean isActive = true;
        long count = 0;
        while (isActive){
            User user = new User("A","1",RequestType.DEPOSIT);
            users.push(user);
            isActive = (count != time);
            count += 1000;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(user.getName()+"-"+user.getId());
        }
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
//            System.out.println(user.getName()+"-"+user.getId());
        }
    }

    public long getTime() {
        return time;
    }

    private User createRandomUser(){
        return new User("","",RequestType.DEPOSIT);
    }
}
