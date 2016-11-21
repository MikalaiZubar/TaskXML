package by.zubarmikalai.task03.entity;

import by.zubarmikalai.task03.action.Trade;
import by.zubarmikalai.task03.creator.IdCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Nick on 11.10.16.
 */
public class Broker extends Thread{

    private static final Logger LOGGER = LogManager.getLogger(Broker.class);
    private long id;
    private double account;
    private double active;
    private List<Stock> brokerStockList = StockExchange.receiveStockList();
    private Map<Stock, Integer> brokerStockStore = new LinkedHashMap<>();
    private Lock lock = new ReentrantLock();

    public Broker( double account){
        this.account = account;
        id = IdCreator.createBrokerId();
    }

    public List<Stock> getBrokerStockList() {
        return brokerStockList;
    }

    public Map<Stock, Integer> getBrokerStockStore() {
        return brokerStockStore;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public double getActive() {
        return active;
    }

    public void setActive(double active) {
        this.active = active;
    }

    @Override
    public long getId() {
        return id;
    }

    public void run(){
        while(!StockExchange.isClosed()){
            lock.lock();
            try {
                Trade.buyStockPack(this);
                LOGGER.info("Broker "+this.getId()+" is buying");
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                LOGGER.error("Broker " + this.getId() + " interrupted", e);
            }finally {
                lock.unlock();
            }

            lock.lock();
            try {
                Trade.sellStockPack(this);
                LOGGER.info("Broker "+this.getId()+" is selling");
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                LOGGER.error("Broker " + this.getId() + " interrupted", e);
            }finally {
                lock.unlock();
            }
        }
    }

    @Override
    public String toString() {
        return "Broker{" +
                "id=" + id +
                ", account=" + account +
                ", active=" + active + '}';
    }


}
