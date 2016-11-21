package by.zubarmikalai.task03.creator;

import by.zubarmikalai.task03.entity.Broker;
import by.zubarmikalai.task03.entity.StockExchange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * Created by Nick on 20.10.16.
 */
public class StatisticCreator {
    private static final Logger LOGGER = LogManager.getLogger(StatisticCreator.class);

    public static void createLog(){
        for(Broker b: StockExchange.receiveBrokerList()){
            LOGGER.info(b);
        }

        for (Map.Entry entry: StockExchange.getStockStore().entrySet()){
            LOGGER.info(entry.getKey()+ " : " + entry.getValue());
        }

        /*
        for(Broker b: StockExchange.receiveBrokerList()) {
            LOGGER.info("Broker " + b.getId());
            for (Map.Entry entry : b.getBrokerStockStore().entrySet()) {
                LOGGER.info(entry.getKey() + " : " + entry.getValue());
            }
        }
        */
    }

}
