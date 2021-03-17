package models;


public class ServiceWindow extends Thread{

    User user;
    private int count;
    boolean alive = true;

    public ServiceWindow(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            sleep(calculateTimeSleep(user));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        System.out.println("Durmio:"+ getName());
        System.out.println("Consumio " + user.getName());
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    private long calculateTimeSleep(User user){
            switch (user.getRequestType()){
                case LOAN: return 2000;
                case DEPOSIT: return 1000;
                case OTHER_SERVICE: return 5000;
                case TRANSACTION: return 3500;
                default: return 0;
            }
    }
}
