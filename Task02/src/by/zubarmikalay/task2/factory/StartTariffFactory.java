package by.zubarmikalay.task2.factory;

import by.zubarmikalay.task2.exception.NegativeTariffValueException;
import by.zubarmikalay.task2.tariff.StartTariff;
import by.zubarmikalay.task2.tariff.Tariff;

/**
 * Created by Nick on 05.10.16.
 */
public class StartTariffFactory {

    public static Tariff createTariff(String... strings) throws IllegalArgumentException, NegativeTariffValueException {
        String name = strings[1];
        String minuteCost = strings[2];
        String smsCost = strings[3];
        StartTariff startTariff = new StartTariff();
        startTariff.setName(name);
        if(Double.parseDouble(minuteCost) >= 0){
            startTariff.setMinuteCost(Double.parseDouble(minuteCost));
        }else{
            throw new NegativeTariffValueException("Negative value in minute cost field");
        }
        if (Double.parseDouble(smsCost) >= 0){
            startTariff.setSmsCost(Double.parseDouble(smsCost));
        }else{
            throw new NegativeTariffValueException("Negative value in sms cost field");
        }

        return startTariff;
    }
}
