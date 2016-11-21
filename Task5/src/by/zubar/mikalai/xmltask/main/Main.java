package by.zubar.mikalai.xmltask.main;

import by.zubar.mikalai.xmltask.parser.TariffDOMBuilder;
import by.zubar.mikalai.xmltask.parser.TariffSAXParser;
import by.zubar.mikalai.xmltask.parser.TariffStAXBuilder;

/**
 * Created by Mikalay Zubar on 20.11.2016.
 */
public class Main {
    public static void main(String[] args) {
      //  SimpleTariffParser.parse();

        TariffSAXParser.printSAX();

        TariffDOMBuilder.printDom();

        TariffStAXBuilder .printStAX();
    }
}
