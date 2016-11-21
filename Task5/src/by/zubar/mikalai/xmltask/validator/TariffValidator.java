package by.zubar.mikalai.xmltask.validator;

import by.zubar.mikalai.xmltask.constant.RootConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mikalay Zubar on 20.11.2016.
 */
public class TariffValidator {
    private static final Logger LOGGER = LogManager.getLogger(TariffValidator.class);


    public static boolean validate(){
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(RootConstant.getXsdRoot()));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(RootConstant.getXmlRoot())));
        } catch (SAXException | IOException e) {
            LOGGER.error(e);
            return false;
        }
        return true;
    }
}
