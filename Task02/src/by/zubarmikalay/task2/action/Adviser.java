package by.zubarmikalay.task2.action;

import by.zubarmikalay.task2.tariff.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 02.10.16.
 */
public class Adviser {

    private static final Logger LOGGER = LogManager.getLogger(Adviser.class);

    public static List<Tariff> tariffAdviser(TariffList tariffList, String root) {
        TextReader tr = new TextReader();
        List<String> strings = null;
        List<Tariff> recommendedTariffs = new ArrayList<>();
        try {
            strings = tr.textReader(root);
        } catch (IOException e) {
            LOGGER.fatal("No file found ", e);
        }
        for (String s : strings) {
            String[] str = s.split(" ");
            String maxSubscrFee;
            String minMinutesInc;
            String minMbInc;
            double subscription;
            int minute;
            int mb;
            try{
                maxSubscrFee = str[0];
                minMinutesInc = str[1];
                minMbInc = str[2];
                subscription = Double.parseDouble(maxSubscrFee);
                minute = Integer.parseInt(minMinutesInc);
                mb = Integer.parseInt(minMbInc);
            }catch (ArrayIndexOutOfBoundsException e){
                LOGGER.error("Wrong size of tariff search line", e);
                continue;
            }catch (IllegalArgumentException e){
                LOGGER.error("Wrong data type in tariff search line", e);
                continue;
            }

            List<Tariff> startTariffs = new ArrayList<>();
            List<Tariff> midiTariffs = new ArrayList<>();
            List<Tariff> superTariffs = new ArrayList<>();
            for (Tariff t : tariffList.getTariffList()) {
                if (t.getClass().getSimpleName().toLowerCase().equals("starttariff")) {
                    startTariffs.add(t);
                }
                if (t.getClass().getSimpleName().toLowerCase().equals("miditariff")) {
                    midiTariffs.add(t);
                }
                if (t.getClass().getSimpleName().toLowerCase().equals("supertariff")) {
                    superTariffs.add(t);
                }
            }
            if (subscription == 0 && minute == 0 && mb == 0) {
                recommendedTariffs.addAll(startTariffs);
            }
            if (subscription > 0 && minute > 0 && mb == 0) {
                for (Tariff t : midiTariffs) {
                    MidiTariff tariff = (MidiTariff) t;
                    if (subscription >= tariff.getSubscriptionFee() &&
                            minute <= tariff.getMinutesIncluded()) {
                        recommendedTariffs.add(tariff);
                    }
                }
            }
            if (subscription > 0 && minute > 0 && mb > 0) {
                for (Tariff t : superTariffs) {
                    SuperTariff tariff = (SuperTariff) t;
                    if (subscription >= tariff.getSubscriptionFee() &&
                            minute <= tariff.getMinutesIncluded() &&
                            mb <= tariff.getMbIncluded()) {
                        recommendedTariffs.add(tariff);
                    }
                }
            }
        }
        return recommendedTariffs;
    }
}