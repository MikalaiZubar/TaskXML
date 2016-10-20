package by.zubarmikalay.task2.comparator;

import by.zubarmikalay.task2.tariff.Tariff;

import java.util.Comparator;

/**
 * Created by Nick on 02.10.16.
 */
public class TariffComparator implements Comparator<Tariff> {
    @Override
    public int compare(Tariff o1, Tariff o2) {
        if(o1.getSubscriptionFee() < o2.getSubscriptionFee()){
            return -1;
        }else if(o1.getSubscriptionFee() > o2.getSubscriptionFee()){
            return 1;
        }else{
            return 0;
        }
    }
}
