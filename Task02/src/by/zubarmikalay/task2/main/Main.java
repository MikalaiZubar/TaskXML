package by.zubarmikalay.task2.main;

import by.zubarmikalay.task2.action.Adviser;
import by.zubarmikalay.task2.action.TextWriter;
import by.zubarmikalay.task2.constant.Constant;
import by.zubarmikalay.task2.subscriber.SubscriberList;
import by.zubarmikalay.task2.tariff.Tariff;
import by.zubarmikalay.task2.tariff.TariffList;



/**
 * Created by Nick on 30.09.16.
 */
public class Main {

    public static void main(String[] args){

        TariffList tariffList = new TariffList();

        tariffList.sortTariff();

        SubscriberList subscriberList = new SubscriberList();

        TextWriter.createReport(tariffList, subscriberList, Adviser.tariffAdviser(tariffList, Constant.getSearchRoot()));
    }
}
