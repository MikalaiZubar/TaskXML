package by.zubarmikalay.task2.factory;

import by.zubarmikalay.task2.exception.NegativeTariffValueException;
import by.zubarmikalay.task2.tariff.MidiTariff;
import by.zubarmikalay.task2.tariff.Tariff;

/**
 * Created by Nick on 05.10.16.
 */
public class MidiTariffFactory {

    public static Tariff createTariff(String... strings) throws IllegalArgumentException, NegativeTariffValueException {
        String name = strings[1];
        String subscrFee = strings[2];
        String minuteCost = strings[3];
        String smsCost = strings[4];
        String minutesIncluded = strings[5];
        String smsIncluded = strings[6];

        MidiTariff midiTariff = new MidiTariff();
        midiTariff.setName(name);
        if(Double.parseDouble(subscrFee) >= 0){
            midiTariff.setSubscriptionFee(Double.parseDouble(subscrFee));
        }else{
            throw new NegativeTariffValueException("Negative value in subscription fee field");
        }
        if(Double.parseDouble(minuteCost) >= 0){
            midiTariff.setMinuteCost(Double.parseDouble(minuteCost));
        }else{
            throw new NegativeTariffValueException("Negative value in minute cost field");
        }
        if (Double.parseDouble(smsCost) >= 0){
            midiTariff.setSmsCost(Double.parseDouble(smsCost));
        }else{
            throw new NegativeTariffValueException("Negative value in sms cost field");
        }
        if(Integer.parseInt(minutesIncluded) >= 0){
            midiTariff.setMinutesIncluded(Integer.parseInt(minutesIncluded));
        }else {
            throw new NegativeTariffValueException("Negative value in minutes included field");
        }
        if (Integer.parseInt(smsIncluded) >= 0){
            midiTariff.setSmsIncluded(Integer.parseInt(smsIncluded));
        }else{
            throw new NegativeTariffValueException("Negative value in sms included field");
        }

        return midiTariff;
    }
}
