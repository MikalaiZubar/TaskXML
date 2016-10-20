package by.zubarmikalai.task03.action;

import by.zubarmikalai.task03.entity.Broker;
import by.zubarmikalai.task03.entity.Exchange;
import by.zubarmikalai.task03.entity.Stock;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Nick on 12.10.16.
 */
public class Trade {
    private static Lock lock = new ReentrantLock();
    private static final int maxPossibleIssue = 200_000;
    private static int quantity;

    public static void buyStockPack(Broker broker){
        lock.lock();
        int i;
        quantity = 0;
        double amount = 0;
        Stock stock = null;
        boolean action = true;
        while (action){
            i = (int) (Math.random() * Exchange.receiveStockList().size());
            stock = Exchange.receiveStockList().get(i);
            for(Map.Entry<Stock,Integer> entry: Exchange.getStockStore().entrySet()){
                if(stock.equals(entry.getKey())){
                    quantity = (int) (Math.random() * entry.getValue()) + 1;
                    amount = quantity * stock.getCost();
                    if(amount <= broker.getAccount()) {
                        entry.setValue(entry.getValue() - quantity);
                        action = false;
                   }
                }
            }
        }
        //double stockCost = stock.getCost() * (1+createDiscount());  //Doesn't work???

        double stockCost = stock.getCost()*1.1;  // max possible - cost * 1.1 (+10%)
        stock.setCost(stockCost);
        int counter = 0;
        for(Map.Entry<Stock, Integer> entry: broker.getBrokerStockStore().entrySet()){
            if(stock.equals(entry.getKey())){
                entry.setValue(entry.getValue()+quantity);
                counter++;
            }
        }
        if(counter == 0){
            broker.getBrokerStockStore().put(stock, quantity);
            broker.getBrokerStockList().add(stock);
        }

        double brokerAccount = broker.getAccount() - amount;
        broker.setAccount(brokerAccount);
        double stockActive = 0;
        for(Map.Entry<Stock, Integer> entry: broker.getBrokerStockStore().entrySet()){
            stockActive += entry.getKey().getCost()*entry.getValue();
        }
        broker.setActive(stockActive+broker.getAccount());
        lock.unlock();
    }

    public static void sellStockPack(Broker broker) {
        lock.lock();
        int i = (int) (Math.random() * broker.getBrokerStockList().size());
        Stock stock = broker.getBrokerStockList().get(i);
        quantity = 0;
        double amount = 0;
        for(Map.Entry<Stock, Integer> entry: broker.getBrokerStockStore().entrySet()){
            if(stock.equals(entry.getKey())){
                quantity = (int) (Math.random() * entry.getValue()) + 1;
                amount = quantity * entry.getKey().getCost();
                entry.setValue(entry.getValue()-quantity);
            }
        }
        //double stockCost = stock.getCost() *(1-createDiscount()); // doesn't work???
        double stockCost = stock.getCost()*0.9; // min possible - 10%
        stock.setCost(stockCost);
        for(Map.Entry<Stock, Integer> entry: Exchange.getStockStore().entrySet()){
            if(stock.equals(entry.getKey())){
                entry.setValue(entry.getValue()+quantity);
            }
        }
        double brokerAccount = broker.getAccount() + amount;
        broker.setAccount(brokerAccount);
        double stockActive = 0;
        for(Map.Entry<Stock, Integer> entry: broker.getBrokerStockStore().entrySet()){
            stockActive += entry.getKey().getCost()*entry.getValue();
        }
        broker.setActive(stockActive+broker.getAccount());
        lock.unlock();
    }


    public static double createDiscount(){
        lock.lock();
        double discount = quantity/maxPossibleIssue;
        lock.unlock();
        return discount;
    }
}
