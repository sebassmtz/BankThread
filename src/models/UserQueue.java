package models;

import structures.queue.Queue;

import java.util.Iterator;
import java.util.Random;

public class UserQueue extends Thread{
    private Random rnd = new Random();
    private Queue<User> users;
    private long time;
    private int countUser;
    private RequestType[] requestTypes;

    public UserQueue(long time) {
        this.users = new Queue<>(User::compare);
        this.time = time;
        this.requestTypes = RequestType.values();
        this.countUser = 0;
    }

    public int getCountUser() {
        return countUser;
    }

    public Queue<User> getUsers() {
        return users;
    }

    @Override
    public void run() {
        boolean isActive = true;
        long count = 0;
        while (isActive){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            User user = createRandomUser();
            users.push(user);
            countUser++;
            isActive = (count != time);
            count += 1000;
            System.out.println("Entra: "+user.getName()+"-"+user.getId()+"-"+user.getRequestType());
        }
        System.out.println("final: "+isAlive());
        System.out.println("isempty: "+users.isEmpty());
    }

    public long getTime() {
        return time;
    }

    private User createRandomUser(){
        return new User(generateRandomCode(),String.valueOf(rnd.nextInt(10000)),getRandomRequest(4));
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

    private RequestType getRandomRequest(int size){
        return requestTypes[rnd.nextInt(size)];
    }

    public User getUserQueue(){
        return users.poll();
    }
}
