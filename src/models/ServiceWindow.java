package models;

public class ServiceWindow extends Thread{

    private User user;
    private boolean available = true;

    public ServiceWindow(String name) {
        super(name);
     this.user = null;
    }

    public boolean isAvailable() {
        return available;
    }

    public User getUser() {
        return user;
    }

    @Override
    public void run() {
        try {
            sleep(calculateTimeSleep());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        available = true;
    }

    public void setUser(User user) {
        available = false;
        this.user = user;
    }

    private long calculateTimeSleep(){
        if (user != null){
            switch (user.getRequestType()){
                case LOAN: return 2000;
                case DEPOSIT: return 500;
                case OTHER_SERVICE: return 5000;
                case TRANSACTION: return 3500;
                default: return 0;
            }
        }else{
            return 0;
        }
    }
}
