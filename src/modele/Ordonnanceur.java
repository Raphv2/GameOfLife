package modele;

import static java.lang.Thread.*;

public class Ordonnanceur extends Thread {

    private long sleepTime;
    private Runnable runnable;
    private Environnement env;
    public Ordonnanceur(long _sleepTime, Runnable _runnable, Environnement env2) {
        sleepTime = _sleepTime;
        runnable = _runnable;
        env = env2;
    }

    public void setSleepTime(long sleepTime2){
        sleepTime = sleepTime2;
    }

    public void run() {
        while (true) {
            runnable.run();
            try {
                setSleepTime(env.getSpeed());
                sleep(sleepTime);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
