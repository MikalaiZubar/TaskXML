package by.zubarmikalai.task03.creator;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Nick on 24.10.16.
 */
public class IdCreator {
    private static AtomicInteger brokerCounter = new AtomicInteger(0);
    private static AtomicInteger stockCounter = new AtomicInteger(0);

    public static int createBrokerId(){
        return brokerCounter.incrementAndGet();
    }

    public static int createStockId(){
        return stockCounter.incrementAndGet();
    }
}
