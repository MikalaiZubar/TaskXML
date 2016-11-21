package by.zubarmikalai.task03.comparator;

import by.zubarmikalai.task03.entity.Broker;

import java.util.Comparator;

/**
 * Created by Nick on 20.10.16.
 */
public class BrokerComparator implements Comparator<Broker> {

    @Override
    public int compare(Broker o1, Broker o2) {
        if(o1.getActive() > o2.getActive()){
            return 1;
        }else if(o1.getActive() < o2.getActive()){
            return -1;
        }else {
            return 0;
        }
    }
}
