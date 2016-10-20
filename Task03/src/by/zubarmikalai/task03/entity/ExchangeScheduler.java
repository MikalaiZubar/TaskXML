package by.zubarmikalai.task03.entity;

import java.util.concurrent.TimeUnit;

/**
 * Created by Nick on 19.10.16.
 */
public class ExchangeScheduler implements Runnable {
    private final int WORKING_TIME = 10;

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(WORKING_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            Exchange.setClosed(true);

    }
}
