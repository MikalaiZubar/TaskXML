package by.zubarmikalai.task03.Main;

import by.zubarmikalai.task03.action.LogCreator;
import by.zubarmikalai.task03.action.ReportCreator;
import by.zubarmikalai.task03.entity.Exchange;
import by.zubarmikalai.task03.entity.ExchangeScheduler;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nick on 17.10.16.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Exchange.getExchange();
        Thread t = new Thread(new ExchangeScheduler());
        t.start();
        Exchange.startTrading();

        TimeUnit.SECONDS.sleep(12);

        LogCreator.createLog();

        Exchange.sortBroker();

        ReportCreator.createReport();
        }
    }

