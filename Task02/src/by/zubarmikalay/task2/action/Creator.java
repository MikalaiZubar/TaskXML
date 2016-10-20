package by.zubarmikalay.task2.action;

import by.zubarmikalay.task2.constant.Constant;
import by.zubarmikalay.task2.exception.NegativeTariffValueException;
import by.zubarmikalay.task2.exception.NoSuchTariffException;
import by.zubarmikalay.task2.factory.MidiTariffFactory;
import by.zubarmikalay.task2.factory.StartTariffFactory;
import by.zubarmikalay.task2.subscriber.SubscriberCreator;
import by.zubarmikalay.task2.factory.SuperTariffFactory;
import by.zubarmikalay.task2.enumtariff.EnumTariff;
import by.zubarmikalay.task2.subscriber.Subscriber;
import by.zubarmikalay.task2.tariff.Tariff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 30.09.16.
 */
public class Creator {

    private static final Logger LOGGER = LogManager.getLogger(Creator.class);
    private static List<Tariff> tariffList;
    private static List<Subscriber> subscriberList;

    public static List<Tariff> getTariffList() {
        return tariffList;
    }

    public static List<Subscriber> getSubscriberList() {
        return subscriberList;
    }

    public static List<Tariff> createTarrif(String root) {

        final int START_LINE_LENGTH = 4;
        final int MIDI_LINE_LENGTH = 7;
        final int SUPER_LINE_LENGTH = 9;

        TextReader tr = new TextReader();
        ArrayList<String> inputMessage = null;
        try {
            inputMessage = (ArrayList<String>) tr.textReader(root);
        } catch (IOException e) {
            LOGGER.fatal("Missing input data file ", e);
        }
        tariffList = new ArrayList<>();
        for (int i = 0; i < inputMessage.size(); i++) {
            String line = inputMessage.get(i);
            String[] str = line.split(" ");
            if (str.length == START_LINE_LENGTH || str.length == MIDI_LINE_LENGTH || str.length == SUPER_LINE_LENGTH) {
                String s = str[0].toLowerCase();
                if (s.equals(Constant.getTariff1()) || s.equals(Constant.getTariff2())
                        || s.equals(Constant.getTariff3())) {
                    EnumTariff enumTariff = EnumTariff.valueOf(s.toUpperCase());
                    switch (enumTariff) {
                        case START:
                            Tariff tariff = null;
                            try {
                                tariff = StartTariffFactory.createTariff(str);
                            } catch (NegativeTariffValueException n) {
                                LOGGER.error("Argument has negative value at line: " + (i + 1), n);
                                continue;
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("Wrong argument type at line: " + (i + 1), e);
                                continue;
                            }
                            tariffList.add(tariff);
                            break;
                        case MIDI:
                            try {
                                tariff = MidiTariffFactory.createTariff(str);
                            } catch (NegativeTariffValueException n) {
                                LOGGER.error("Argument has negative value at line: " + (i + 1), n);
                                continue;
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("Wrong argument type at line: " + (i + 1), e);
                                continue;
                            }
                            tariffList.add(tariff);
                            break;
                        case SUPER:
                            try {
                                tariff = SuperTariffFactory.createTariff(str);
                            } catch (NegativeTariffValueException n) {
                                LOGGER.error("Argument has negative value at line: " + (i + 1), n);
                                continue;
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("Wrong argument type at line: " + (i + 1), e);
                                continue;
                            }
                            tariffList.add(tariff);
                            break;
                    }
                } else {
                    LOGGER.error("Incorrect type of Tariff at line " + (i + 1));
                    continue;
                }
            } else {
                LOGGER.error("Incorrect size of input data values at line: " + (i+1));
                continue;
            }
        }
        return tariffList;
    }

    public static List<Subscriber> createSubscriber( List<Tariff> tariffList, String root){
        final int SUBSCRIBER_LENGTH = 3;
        TextReader tr = new TextReader();
        List<String> list = null;
        try {
            list =  tr.textReader(root);
        } catch (IOException e) {
            LOGGER.fatal("Missing input data file ", e);
        }
        subscriberList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            String line = list.get(i);
            String[] str = line.split(" ");
            if(str.length == SUBSCRIBER_LENGTH) {
                Subscriber subscriber;
                try {
                   subscriber = SubscriberCreator.fabricateSubscriber(tariffList, str);
                }catch (IllegalArgumentException e){
                   LOGGER.error("Wrong subscribers argument type at line: " + (i+1), e);
                   continue;
                }catch (NoSuchTariffException n){
                    LOGGER.error("Invalid tariff name at subscribers line: " + (i+1), n);
                    continue;
                }
                subscriberList.add(subscriber);
            } else {
                LOGGER.error("Incorrect size of subscribers input data at line: " + (i+1));
                continue;
            }
        }
        return subscriberList;
    }
}


