package by.zubarmikalay.task2.subscriber;

import by.zubarmikalay.task2.action.Creator;
import by.zubarmikalay.task2.constant.Constant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by Nick on 09.10.16.
 */
public class SubscriberList {
    private List<Subscriber> subscriberList;

    public SubscriberList(){
        subscriberList = createSubscriberList();
    }

    public List<Subscriber> getSubscriberList() {
        return subscriberList;
    }

    public List<Subscriber> createSubscriberList(){
        List<Subscriber> list = Creator.createSubscriber(Creator.getTariffList(), Constant.getSubscriberRoot());
        return list;
    }


}
