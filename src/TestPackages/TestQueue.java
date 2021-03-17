package TestPackages;

import models.UserQueue;

public class TestQueue {
    public static void main(String[] args) {
        UserQueue userQueue = new UserQueue(6000);
        userQueue.start();
    }

}
