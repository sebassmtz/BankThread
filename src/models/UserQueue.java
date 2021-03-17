package models;

import structures.queue.Queue;

import java.util.Iterator;
import java.util.Random;

public class UserQueue extends Thread{
    private Random rnd = new Random();
    private Queue<User> users;
    private long time;
    private RequestType[] requestTypes;

    public UserQueue(long time) {
        this.users = new Queue<>(User::compare);
        this.time = time;
        this.requestTypes = RequestType.values();
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
        return new User(generateRandomCode(),String.valueOf(rnd.nextInt(10000)),getRandomrequest(4));
    }

    private String generateRandomCode(){
        String code = "";
        for (int i = 0; i < 7; i++) {
            if (i < 4){
                code += (char) (rnd.nextInt(25) + 65);
            }else{
                code += (char) (rnd.nextInt(25) + 97);
            }
        }
        return code;
    }

    private RequestType getRandomrequest(int size){
        return requestTypes[rnd.nextInt(size)];
    }
}
