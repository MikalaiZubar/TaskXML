package by.zubar.mikalai.xmltask.parser;

import by.zubar.mikalai.xmltask.constant.RootConstant;
import by.zubar.mikalai.xmltask.entity.*;
import by.zubar.mikalai.xmltask.exeption.NoSuchTariffException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikalay Zubar on 21.11.2016.
 */
public class TariffDOMBuilder {
    private static final Logger LOGGER = LogManager.getLogger(TariffDOMBuilder.class);

    private List<Tariff> tariffs;
    private DocumentBuilder documentBuilder;

    public TariffDOMBuilder(){
        this.tariffs = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error(e);
        }
    }

    public List<Tariff> getTariffs() {
        return tariffs;
    }

    public void buildListTariffs(String filename){
        Document document;
        String[] names = {"voice-tariff", "internet-tariff"};
        try {
            document = documentBuilder.parse(filename);
            Element root = document.getDocumentElement();
            for(int i=0; i<names.length; i++) {
                NodeList tariffsList = root.getElementsByTagName(names[i]);
                for(int j=0; j<tariffsList.getLength(); j++){
                    Element tariffElement = (Element) tariffsList.item(j);
                    Tariff tariff = buildTariff(tariffElement);
                    tariffs.add(tariff);
                }
            }
        } catch (SAXException | IOException | NoSuchTariffException e) {
           LOGGER.error(e);
        }
    }

    private Tariff buildTariff(Element tariffElement) throws NoSuchTariffException {
        String tariffType = tariffElement.getTagName();
        Tariff tariff = null;
        CallPrice callPrice;
        MessagePrice messagePrice;
        TariffParam tariffParam;
        Internet internet;
        switch (tariffType){
            case "voice-tariff":
                tariff = new VoiceTariff();
                tariff.setName(tariffElement.getAttribute("name"));
                tariff.setOperator(tariffElement.getAttribute("operator"));
                tariff.setPayroll(Double.parseDouble(getElementTextContent(tariffElement, "payroll")));

                callPrice = new CallPrice();
                Element callPriceElement = (Element) tariffElement.getElementsByTagName("call-prices").item(0);
                callPrice.setInternalCall(Double.parseDouble(getElementTextContent(callPriceElement, "internal-call")));
                callPrice.setExternalCall(Double.parseDouble(getElementTextContent(callPriceElement, "external-call")));
                callPrice.setInternationalCall(Double.parseDouble(getElementTextContent(callPriceElement, "international-call")));
                tariff.setCallPrice(callPrice);

                messagePrice = new MessagePrice();
                Element messagePriceElement = (Element) tariffElement.getElementsByTagName("message-prices").item(0);
                messagePrice.setSmsPrice(Double.parseDouble(getElementTextContent(messagePriceElement, "sms-price")));
                messagePrice.setMmsPrice(Double.parseDouble(getElementTextContent(messagePriceElement, "mms-price")));
                tariff.setMessagePrice(messagePrice);

                tariffParam = new TariffParam();
                Element tariffparamElement = (Element) tariffElement.getElementsByTagName("parameters").item(0);
                tariffParam.setMinPrepayment(Double.parseDouble(getElementTextContent(tariffparamElement, "min-prepayment")));
                tariffParam.setTarification(Integer.parseInt(getElementTextContent(tariffparamElement, "tarification")));
                tariffParam.setFavouriteNums(Integer.parseInt(getElementTextContent(tariffparamElement, "fav-numbs")));
                tariff.setTariffParam(tariffParam);
                break;
            case "internet-tariff":
                tariff = new InternetTariff();
                tariff.setName(tariffElement.getAttribute("name"));
                tariff.setOperator(tariffElement.getAttribute("operator"));
                tariff.setPayroll(Double.parseDouble(getElementTextContent(tariffElement, "payroll")));

                callPrice = new CallPrice();
                callPriceElement = (Element) tariffElement.getElementsByTagName("call-prices").item(0);
                callPrice.setInternalCall(Double.parseDouble(getElementTextContent(callPriceElement, "internal-call")));
                callPrice.setExternalCall(Double.parseDouble(getElementTextContent(callPriceElement, "external-call")));
                callPrice.setInternationalCall(Double.parseDouble(getElementTextContent(callPriceElement, "international-call")));
                tariff.setCallPrice(callPrice);

                messagePrice = new MessagePrice();
                messagePriceElement = (Element) tariffElement.getElementsByTagName("message-prices").item(0);
                messagePrice.setSmsPrice(Double.parseDouble(getElementTextContent(messagePriceElement, "sms-price")));
                messagePrice.setMmsPrice(Double.parseDouble(getElementTextContent(messagePriceElement, "mms-price")));
                tariff.setMessagePrice(messagePrice);

                tariffParam = new TariffParam();
                tariffparamElement = (Element) tariffElement.getElementsByTagName("parameters").item(0);
                tariffParam.setMinPrepayment(Double.parseDouble(getElementTextContent(tariffparamElement, "min-prepayment")));
                tariffParam.setTarification(Integer.parseInt(getElementTextContent(tariffparamElement, "tarification")));
                tariffParam.setFavouriteNums(Integer.parseInt(getElementTextContent(tariffparamElement, "fav-numbs")));
                tariff.setTariffParam(tariffParam);

                internet = new Internet();
                Element internetElement = (Element) tariffElement.getElementsByTagName("internet").item(0);
                internet.setMbIncluded(Integer.parseInt(getElementTextContent(internetElement, "included-mb")));
                internet.setMbPrice(Double.parseDouble(getElementTextContent(internetElement, "mb-price")));
                tariff.setInternet(internet);
                break;
            default:
                throw new NoSuchTariffException("Couldn't found such tariff");
        }

        return tariff;
    }

    private static String getElementTextContent(Element element, String elementName){
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }

    public static void printDom(){
        TariffDOMBuilder domBuilder = new TariffDOMBuilder();
        domBuilder.buildListTariffs(RootConstant.getXmlRoot());
        LOGGER.info("DOM BUILDER: ");
        for(Tariff t: domBuilder.getTariffs()){
            LOGGER.info(t.toString());
        }
    }
}
