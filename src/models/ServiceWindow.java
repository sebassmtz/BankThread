package models;

public class ServiceWindow extends Thread{

    private User user;
    private boolean available;

    public ServiceWindow() {
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
        this.user = user;
        available = false;
    }

    private long calculateTimeSleep(){
        switch (user.getRequestType()){
            case LOAN: return 2000;
            case DEPOSIT: return 500;
            case OTHER_SERVICE: return 5000;
            case TRANSACTION: return 3500;
            default: return 0;
        }
    }
}
