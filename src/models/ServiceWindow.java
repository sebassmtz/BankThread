package models;

public class ServiceWindow extends Thread{

    private User user;
    private boolean available;
    private boolean isLive;

    public ServiceWindow(String name) {
        super(name);
        this.user = null;
        this.available = true;
        this.isLive = true;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public boolean isAvailable() {
        return available;
    }

    public User getUser() {
        return user;
    }

    @Override
    public void run() {
        System.out.println("Run "+this.getName() + "available:"+available);
        while (isLive){
//            System.out.println("initRun----------------");
            setAvailable(false);
            try {
                sleep(calculateTimeSleep(user));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (user != null){
                System.out.println("THREAD: "+getName()+ "----------------------------------");
                System.out.println("Attend: "+user.getName()+"-"+user.getRequestType());
                System.out.println("-------------------------------------------------");
                setUser(null);
            }
            setAvailable(true);
        }
        System.out.println("deadThread:"+this.getName());
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

//    public void setUser(User user) {
//        this.user = user;
//    }

    public long calculateTimeSleep(User user){
        if (user != null){
            switch (user.getRequestType()){
                case LOAN: return 3000;
                case DEPOSIT: return 2000;
                case OTHER_SERVICE: return 5000;
                case TRANSACTION: return 3500;
                default: return 0;
            }
        }
        return 0;
    }

    public void setUser(User user){
//        System.out.println("setUser: "+user.getName()+"-"+user.getRequestType());
        this.user = user;
    }
}
