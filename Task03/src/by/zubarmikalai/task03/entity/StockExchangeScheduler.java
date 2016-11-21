package by.zubarmikalai.task03.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by Nick on 19.10.16.
 */
public class StockExchangeScheduler implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(StockExchangeScheduler.class);
    private final int WORKING_TIME = 10;

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(WORKING_TIME);
        } catch (InterruptedException e) {
            LOGGER.error("StokExchange work is interrupted ", e);
        }
            StockExchange.setClosed(true);

    }
}
