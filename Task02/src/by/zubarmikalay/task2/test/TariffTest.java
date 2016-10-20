package by.zubarmikalay.task2.test;

import by.zubarmikalay.task2.action.Adviser;
import by.zubarmikalay.task2.action.Creator;
import by.zubarmikalay.task2.subscriber.Subscriber;
import by.zubarmikalay.task2.tariff.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 02.10.16.
 */
public class TariffTest {


    private StartTariff startTariff = new StartTariff("StartOne", 0.50, 0.20);
    private MidiTariff midiTariff = new MidiTariff("MidiTwo", 120.0, 0.25, 0.15, 80, 100);
    private SuperTariff superTariff = new SuperTariff("SuperOne", 200.0, 0.20, 0.10, 0.05, 100, 150, 1024);
    private List<Tariff> expectedTariffList;


    @Before
    public void makeTariffList() {
        expectedTariffList = new ArrayList<>();
        expectedTariffList.add(startTariff);
        expectedTariffList.add(midiTariff);
        expectedTariffList.add(superTariff);
    }

    @Test
    public void createTarrifTest(){
        List<Tariff> tariffList =  Creator.createTarrif("testtxt/testRoot.txt");
        Assert.assertTrue(expectedTariffList.equals(tariffList));
    }

    @Test
    public void createSubscriberTest(){
        List<Subscriber> expectedSubscriberList = new ArrayList<>();
        expectedSubscriberList.add(new Subscriber("One", expectedTariffList.get(0), 150));
        expectedSubscriberList.add(new Subscriber("Two", expectedTariffList.get(1), 200));
        expectedSubscriberList.add(new Subscriber("Three", expectedTariffList.get(2), 250));
        List<Subscriber> subscribers = Creator.createSubscriber(expectedTariffList, "testtxt/testSubscriber.txt");
        Assert.assertTrue(expectedSubscriberList.equals(subscribers));
    }

    @Test
    public void tarifAdviserTest() {
        TariffList tariffList = new TariffList(expectedTariffList);
        List<Tariff> expectedAdvise = new ArrayList<>();
        expectedAdvise.add(midiTariff);
        expectedAdvise.add(startTariff);
        List<Tariff> advise = Adviser.tariffAdviser(tariffList, "testtxt/testSearch.txt");
        Assert.assertTrue(expectedAdvise.equals(advise));
    }
        //all other significant methods should work properly if this three work
}
