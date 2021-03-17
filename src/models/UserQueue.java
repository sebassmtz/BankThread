package models;

import structures.queue.Queue;

import java.util.Iterator;
import java.util.Random;

public class UserQueue extends Thread{
    private Queue<User> users;
    private long time;
    private RequestType[] requestTypes;
    private Random random;

    public UserQueue(long time) {
        this.users = new Queue<>(User::compare);
        this.time = time;
        random = new Random();
        requestTypes = RequestType.values();
    }

    @Override
    public void run() {
        boolean isActive = true;
        long count = 0;
        while (isActive){
            User user = createRandomUser();
            users.push(user);
            isActive = (count != time);
            count += 1000;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(user.getName()+"-"+user.getId()+"-"+user.getRequestType());
        }
    }

    public long getTime() {
        return time;
    }

    private User createRandomUser(){
        return new User("",String.valueOf(random.nextInt(10000)),generateRequest(4));
    }

    private RequestType generateRequest(int size){
        return requestTypes[random.nextInt(size)];
    }
}
