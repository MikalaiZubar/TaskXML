package by.zubarmikalai.task03.creator;

import by.zubarmikalai.task03.entity.Broker;
import by.zubarmikalai.task03.entity.Stock;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Nick on 17.10.16.
 */
public class Creator {
    private static final double BROKER_ACCOUNT = 1_000_000.0;
    private static final int STOCK_ISSUE = 300_000;

    public static List<Broker> createBrokerList(){
        double account = BROKER_ACCOUNT;
        int min = 30;
        int delta = 21;
        int quantity = (int) (Math.random()*min) + delta;
        List<Broker> brokerList = new LinkedList<>();
        for (int i = 0; i < quantity; i++){
            brokerList.add(new Broker(account));
        }
        return brokerList;
    }

    public static List<Stock> createStockList(){
        int max = 5;
        int delta = 5;
        int quantity = (int) (Math.random()*max) + delta;
        List<Stock> stockList = new LinkedList<>();
        for (int i = 0; i < quantity; i++){
            double cost =   Math.random()*5;
            int issue = (int) (Math.random()*STOCK_ISSUE) + STOCK_ISSUE;
            stockList.add(new Stock(cost, issue));
        }
        return stockList;
    }

    public static Map<Stock, Integer> createExchangeStockStore(List<Stock> stockList){
        Map<Stock,Integer> stockStore = new LinkedHashMap<>();
        for(Stock s: stockList){
            stockStore.put(s, s.getIssue());
        }
        return stockStore;
    }


}