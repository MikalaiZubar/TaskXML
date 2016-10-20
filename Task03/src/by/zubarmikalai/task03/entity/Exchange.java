package by.zubarmikalai.task03.entity;

import by.zubarmikalai.task03.action.BrokerComparator;
import by.zubarmikalai.task03.action.Creator;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Nick on 11.10.16.
 */
public class Exchange {
    private static Exchange exchange = null;
    private static ReentrantLock lock = new ReentrantLock();
    private static List<Broker> brokerList;
    private static List<Stock> stockList;
    private static Map<Stock, Integer> stockStore;
    private static boolean closed;


    private Exchange() {
        stockList = Creator.createStockList();
        stockStore = Creator.createExchangeStockStore(stockList);
        brokerList = Creator.createBrokerList();
    }

    public static Exchange getExchange() {
        lock.lock();
        try {
            if (exchange == null) {
                exchange = new Exchange();
            }
        } finally {
            lock.unlock();
        }
        return exchange;
    }

    public static List<Broker> receiveBrokerList() {
        return brokerList;
    }

    public static List<Stock> receiveStockList() {
        return stockList;
    }

    public static Map<Stock, Integer> getStockStore() {
        return stockStore;
    }

    public static   boolean isClosed() {
        return closed;
    }

    public static void setClosed(boolean closed) {
        Exchange.closed = closed;
    }

    public static void startTrading() {
        for (Broker b : brokerList) {
            b.start();
        }
    }

    public static void sortBroker(){
        BrokerComparator comparator = new BrokerComparator();
        Collections.sort(brokerList, comparator);
    }

}
