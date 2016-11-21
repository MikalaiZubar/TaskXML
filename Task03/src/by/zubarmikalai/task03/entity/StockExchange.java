package by.zubarmikalai.task03.entity;

import by.zubarmikalai.task03.comparator.BrokerComparator;
import by.zubarmikalai.task03.creator.Creator;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Nick on 11.10.16.
 */
public class StockExchange {
    private static StockExchange stockExchange;
    private static ReentrantLock lock = new ReentrantLock();
    private static List<Broker> brokerList;
    private static List<Stock> stockList;
    private static Map<Stock, Integer> stockStore;
    private static boolean closed;


    private StockExchange() {
        stockList = Creator.createStockList();
        stockStore = Creator.createExchangeStockStore(stockList);
        brokerList = Creator.createBrokerList();
    }

    public static StockExchange getStockExchange() {
        lock.lock();
        try {
            if (stockExchange == null) {
                stockExchange = new StockExchange();

            }
        } finally {
            lock.unlock();
        }
        return stockExchange;
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
        StockExchange.closed = closed;
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
