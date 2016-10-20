package by.zubarmikalay.task2.subscriber;

import by.zubarmikalay.task2.exception.NoSuchTariffException;
import by.zubarmikalay.task2.tariff.Tariff;

import java.util.List;

/**
 * Created by Nick on 09.10.16.
 */
public class SubscriberCreator {

    public static Subscriber fabricateSubscriber(List<Tariff> tariffList, String ... strings) throws IllegalArgumentException, NoSuchTariffException {
        String name = strings[0];
        String tariff = strings[1];
        String  sumOfPayment = strings[2];

        Subscriber subscriber = new Subscriber();
        subscriber.setSubscriberName(name);
        subscriber.setSumOfPayment(Double.parseDouble(sumOfPayment));
        for(Tariff t: tariffList){
            if(t.getName().toLowerCase().equals(tariff.toLowerCase())) {
                subscriber.setTariff(t);
                subscriber.setCurrentAccount(subscriber.getSumOfPayment() - t.getSubscriptionFee());
            }
        }
        if(subscriber.getTariff() == null){
            Subscriber.setNumberOfSubscribers(Subscriber.getNumberOfSubscribers()-1);
            throw new NoSuchTariffException("No such tariff exist");
        }
       return subscriber;
    }
}
