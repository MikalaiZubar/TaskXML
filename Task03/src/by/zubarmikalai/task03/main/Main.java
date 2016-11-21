package by.zubarmikalai.task03.main;

import by.zubarmikalai.task03.creator.StatisticCreator;
import by.zubarmikalai.task03.creator.ReportCreator;
import by.zubarmikalai.task03.entity.StockExchange;
import by.zubarmikalai.task03.entity.StockExchangeScheduler;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nick on 17.10.16.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        StockExchange.getStockExchange();

        new Thread(new StockExchangeScheduler()).start();

        StockExchange.startTrading();

        TimeUnit.SECONDS.sleep(11);

        StatisticCreator.createLog();

        StockExchange.sortBroker();

        ReportCreator.createReport();
        }
    }

