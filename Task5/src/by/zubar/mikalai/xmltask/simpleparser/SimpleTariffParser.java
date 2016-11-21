package by.zubar.mikalai.xmltask.simpleparser;

import by.zubar.mikalai.xmltask.constant.RootConstant;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Created by Mikalay Zubar on 20.11.2016.
 */
public class SimpleTariffParser extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String s = localName;
        for(int i=0; i<attributes.getLength(); i++) {
            s += " " + attributes.getLocalName(i) + "=" + attributes.getValue(i);
        }
        System.out.print(s.trim());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(localName);;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.print(new String(ch, start, length));
    }

    public static void parse(){
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SimpleTariffParser parser = new SimpleTariffParser();
            reader.setContentHandler(parser);
            reader.parse(RootConstant.getXmlRoot());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
