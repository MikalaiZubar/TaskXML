package by.zubar.mikalai.xmltask.test;

import by.zubar.mikalai.xmltask.constant.RootConstant;
import by.zubar.mikalai.xmltask.entity.*;
import by.zubar.mikalai.xmltask.parser.TariffDOMBuilder;
import by.zubar.mikalai.xmltask.parser.TariffSAXParser;
import by.zubar.mikalai.xmltask.parser.TariffStAXBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikalay Zubar on 21.11.2016.
 */
public class ParserTest {

    private Tariff voiceTariff = setVoiceTariff();
    private Tariff internetTariff = setInternetTariff();
    private List<Tariff> tariffList;


    public Tariff  setVoiceTariff(){
        Tariff tariff = new VoiceTariff("Easy_to_say", "MTS", 0.55);
        CallPrice callPrice = new CallPrice();
        callPrice.setInternalCall(0.07);
        callPrice.setExternalCall(0.14);
        callPrice.setInternationalCall(1.38);
        MessagePrice messagePrice = new MessagePrice();
        messagePrice.setSmsPrice(0.04);
        messagePrice.setMmsPrice(0.08);
        TariffParam tariffParam = new TariffParam();
        tariffParam.setMinPrepayment(3.00);
        tariffParam.setTarification(60);
        tariffParam.setFavouriteNums(3);
        tariff.setCallPrice(callPrice);
        tariff.setMessagePrice(messagePrice);
        tariff.setTariffParam(tariffParam);
        return tariff;
    }

    public Tariff setInternetTariff(){
        Tariff tariff = new InternetTariff("Business.PRO", "Velcom", 14.90);
        CallPrice callPrice = new CallPrice();
        callPrice.setInternalCall(0.01);
        callPrice.setExternalCall(0.08);
        callPrice.setInternationalCall(1.17);
        MessagePrice messagePrice = new MessagePrice();
        messagePrice.setSmsPrice(0.04);
        messagePrice.setMmsPrice(0.15);
        TariffParam tariffParam = new TariffParam();
        tariffParam.setMinPrepayment(5.00);
        tariffParam.setTarification(12);
        tariffParam.setFavouriteNums(5);
        Internet internet = new Internet();
        internet.setMbIncluded(2000);
        internet.setMbPrice(0.02);
        tariff.setCallPrice(callPrice);
        tariff.setMessagePrice(messagePrice);
        tariff.setTariffParam(tariffParam);
        tariff.setInternet(internet);
        return tariff;
    }

    {
        tariffList = new ArrayList<>();
        tariffList.add(voiceTariff);
        tariffList.add(internetTariff);
    }

    @Test
    public void buildListTariffsDOMTest(){
        TariffDOMBuilder domBuilder = new TariffDOMBuilder();
        domBuilder.buildListTariffs(RootConstant.getXmlRoot());
        Assert.assertTrue(tariffList.equals(domBuilder.getTariffs()));
    }

    @Test
    public void parseTariffSAXTest(){
        List resultList = TariffSAXParser.parseTariff();
        Assert.assertTrue(tariffList.equals(resultList));
    }

    @Test
    public void buildListTariffsStAXTest(){
        TariffStAXBuilder staxBuilder = new TariffStAXBuilder();
        staxBuilder.buildListTariffs(RootConstant.getXmlRoot());
        Assert.assertTrue(tariffList.equals(staxBuilder.getTariffs()));
    }
}