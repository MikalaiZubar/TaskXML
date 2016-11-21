package by.zubar.mikalai.xmltask.parser;

import by.zubar.mikalai.xmltask.constant.RootConstant;
import by.zubar.mikalai.xmltask.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikalay Zubar on 21.11.2016.
 */
public class TariffStAXBuilder {
    private static final Logger LOGGER = LogManager.getLogger(TariffStAXBuilder.class);

    private List<Tariff> tariffs = new ArrayList<>();
    private XMLInputFactory inputFactory;

    public TariffStAXBuilder(){
        inputFactory = XMLInputFactory.newInstance();
    }

    public List<Tariff> getTariffs(){
        return tariffs;
    }

    public void buildListTariffs(String fileName){
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(RootConstant.getXmlRoot()));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()){
                int type = reader.next();
                if(type == XMLStreamConstants.START_ELEMENT){
                    name = reader.getLocalName();
                    Tariff tariff;
                    switch (name){
                        case "voice-tariff":
                            tariff = buildVoiceTariff(reader);
                            tariffs.add(tariff);
                            break;
                        case "internet-tariff":
                            tariff = buildInternetTariff(reader);
                            tariffs.add(tariff);
                            break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found ", e);
        } catch (XMLStreamException e) {
            LOGGER.error(e);
        }finally {
            try {
                if(inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error(e);
            }
        }
    }

    private Tariff buildVoiceTariff(XMLStreamReader reader) throws XMLStreamException{
        Tariff tariff = new VoiceTariff();
        tariff.setName(reader.getAttributeValue(null, "name"));
        tariff.setOperator(reader.getAttributeValue(null, "operator"));
        String name;
        while (reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name){
                        case "payroll":
                            tariff.setPayroll(Double.parseDouble(getXMLText(reader)));
                            break;
                        case "call-prices":
                            tariff.setCallPrice(getXMLCallPrice(reader));
                            break;
                        case "message-prices":
                            tariff.setMessagePrice(getXMLMessagePrice(reader));
                            break;
                        case "parameters":
                            tariff.setTariffParam(getXMLTariffParam(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals("voice-tariff")){
                        return tariff;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown elememt in tag Tariff");
    }

    private Tariff buildInternetTariff(XMLStreamReader reader) throws XMLStreamException{
        Tariff tariff = new InternetTariff();
        tariff.setName(reader.getAttributeValue(null, "name"));
        tariff.setOperator(reader.getAttributeValue(null, "operator"));
        String name;
        while (reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name){
                        case "payroll":
                            tariff.setPayroll(Double.parseDouble(getXMLText(reader)));
                            break;
                        case "call-prices":
                            tariff.setCallPrice(getXMLCallPrice(reader));
                            break;
                        case "message-prices":
                            tariff.setMessagePrice(getXMLMessagePrice(reader));
                            break;
                        case "parameters":
                            tariff.setTariffParam(getXMLTariffParam(reader));
                            break;
                        case "internet":
                            tariff.setInternet(getXMLInternet(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals("internet-tariff")){
                        return tariff;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown elememt in tag Tariff");
    }


    private CallPrice getXMLCallPrice(XMLStreamReader reader) throws XMLStreamException{
        CallPrice callPrice = new CallPrice();
        int type;
        String name;
        while (reader.hasNext()){
            type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name) {
                        case "internal-call":
                            callPrice.setInternalCall(Double.parseDouble(getXMLText(reader)));
                            break;
                        case "external-call":
                            callPrice.setExternalCall(Double.parseDouble(getXMLText(reader)));
                            break;
                        case "international-call":
                            callPrice.setInternationalCall(Double.parseDouble(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(name.equals("call-prices")){
                        return callPrice;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Call-price");
    }

    private MessagePrice getXMLMessagePrice(XMLStreamReader reader) throws XMLStreamException{
        MessagePrice messagePrice = new MessagePrice();
        int type;
        String name;
        while (reader.hasNext()){
            type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name) {
                        case "sms-price":
                            messagePrice.setSmsPrice(Double.parseDouble(getXMLText(reader)));
                            break;
                        case "mms-price":
                            messagePrice.setMmsPrice(Double.parseDouble(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(name.equals("message-prices")){
                        return messagePrice;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Call-price");
    }

    private TariffParam getXMLTariffParam(XMLStreamReader reader) throws XMLStreamException{
        TariffParam tariffParam = new TariffParam();
        int type;
        String name;
        while (reader.hasNext()){
            type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name) {
                        case "min-prepayment":
                            tariffParam.setMinPrepayment(Double.parseDouble(getXMLText(reader)));
                            break;
                        case "tarification":
                            tariffParam.setTarification(Integer.parseInt(getXMLText(reader)));
                            break;
                        case "fav-numbs":
                            tariffParam.setFavouriteNums(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(name.equals("parameters")){
                        return tariffParam;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Call-price");
    }

    private Internet getXMLInternet(XMLStreamReader reader) throws XMLStreamException{
        Internet internet = new Internet();
        int type;
        String name;
        while (reader.hasNext()){
            type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name) {
                        case "included-mb":
                            internet.setMbIncluded(Integer.parseInt(getXMLText(reader)));
                            break;
                        case "mb-price":
                            internet.setMbPrice(Double.parseDouble(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(name.equals("internet")){
                        return internet;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Call-price");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException{
        String text = null;
        if (reader.hasNext()){
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    public static void printStAX(){

            TariffStAXBuilder builder = new TariffStAXBuilder();
            builder.buildListTariffs(RootConstant.getXmlRoot());
            LOGGER.info("StAX BUILDER: ");
            for(Tariff t: builder.getTariffs()){
                LOGGER.info(t.toString());
            }


    }

}
