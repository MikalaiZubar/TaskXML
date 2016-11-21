package by.zubar.mikalai.xmltask.parser;

import by.zubar.mikalai.xmltask.constant.RootConstant;
import by.zubar.mikalai.xmltask.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikalay Zubar on 20.11.2016.
 */
public class TariffSAXParser extends DefaultHandler{
    private static final Logger LOGGER = LogManager.getLogger(TariffSAXParser.class);

    private static List<Tariff> tariffList;
    private Tariff currentTariff;
    private CallPrice currentCallPrice;
    private MessagePrice currentMessagePrice;
    private TariffParam currentParameters;
    private Internet currentInternet;
    private StringBuilder stringBuilder;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
       switch (qName){
           case "voice-tariff":
               currentTariff = new VoiceTariff();
               currentCallPrice = new CallPrice();
               currentMessagePrice = new MessagePrice();
               currentParameters = new TariffParam();
               currentTariff.setName(attributes.getValue("name"));
               currentTariff.setOperator(attributes.getValue("operator"));
               break;
           case "internet-tariff":
               currentTariff = new InternetTariff();
               currentCallPrice = new CallPrice();
               currentMessagePrice = new MessagePrice();
               currentParameters = new TariffParam();
               currentInternet = new Internet();
               currentTariff.setName(attributes.getValue("name"));
               currentTariff.setOperator(attributes.getValue("operator"));
               break;
       }


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "payroll":
                currentTariff.setPayroll(Double.parseDouble(stringBuilder.toString()));
                break;
            case "internal-call":
                currentCallPrice.setInternalCall(Double.parseDouble(stringBuilder.toString()));
                break;
            case "external-call":
                currentCallPrice.setExternalCall(Double.parseDouble(stringBuilder.toString()));
                break;
            case "international-call":
                currentCallPrice.setInternationalCall(Double.parseDouble(stringBuilder.toString()));
                break;
            case "sms-price":
                currentMessagePrice.setSmsPrice(Double.parseDouble(stringBuilder.toString()));
                break;
            case "mms-price":
                currentMessagePrice.setMmsPrice(Double.parseDouble(stringBuilder.toString()));
                break;
            case "min-prepayment":
                currentParameters.setMinPrepayment(Double.parseDouble(stringBuilder.toString()));
                break;
            case "tarification":
                currentParameters.setTarification(Integer.parseInt(stringBuilder.toString()));
                break;
            case "fav-numbs":
                currentParameters.setFavouriteNums(Integer.parseInt(stringBuilder.toString()));
                break;
            case "included-mb":
                currentInternet.setMbIncluded(Integer.parseInt(stringBuilder.toString()));
                break;
            case "mb-price":
                currentInternet.setMbPrice(Double.parseDouble(stringBuilder.toString()));
                break;
            case "voice-tariff":
                currentTariff.setCallPrice(currentCallPrice);
                currentTariff.setMessagePrice(currentMessagePrice);
                currentTariff.setTariffParam(currentParameters);
                tariffList.add(currentTariff);
                break;
            case "internet-tariff":
                currentTariff.setCallPrice(currentCallPrice);
                currentTariff.setMessagePrice(currentMessagePrice);
                currentTariff.setTariffParam(currentParameters);
                currentTariff.setInternet(currentInternet);
                tariffList.add(currentTariff);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        stringBuilder = new StringBuilder();
        stringBuilder.append(ch, start, length);
    }

    public static List<Tariff> parseTariff(){
        tariffList = new ArrayList<>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            DefaultHandler handler = new TariffSAXParser();
            parser.parse(RootConstant.getXmlRoot(),handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOGGER.error(e);
        }
        return tariffList;
    }

    public static void printSAX(){
        LOGGER.info("SAX PARSER:");
        for(Tariff t: parseTariff()){
            LOGGER.info(t.toString());
        }
    }
}
