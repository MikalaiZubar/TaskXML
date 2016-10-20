package by.zubarmikalay.task2.factory;

import by.zubarmikalay.task2.exception.NegativeTariffValueException;
import by.zubarmikalay.task2.tariff.SuperTariff;
import by.zubarmikalay.task2.tariff.Tariff;

/**
 * Created by Nick on 05.10.16.
 */
public class SuperTariffFactory{
    public static Tariff createTariff(String... strings) throws IllegalArgumentException , NegativeTariffValueException{
        String name = strings[1];
        String subscrFee = strings[2];
        String minuteCost = strings[3];
        String smsCost = strings[4];
        String mbCost = strings[5];
        String minutesIncluded = strings[6];
        String smsIncluded = strings[7];
        String mbIncluded = strings[8];
        SuperTariff superTariff = new SuperTariff();
        superTariff.setName(name);
        if(Double.parseDouble(subscrFee) >= 0){
            superTariff.setSubscriptionFee(Double.parseDouble(subscrFee));
        }else{
            throw new NegativeTariffValueException("Negative value in subscription fee field");
        }
        if(Double.parseDouble(minuteCost) >= 0){
            superTariff.setMinuteCost(Double.parseDouble(minuteCost));
        }else{
            throw new NegativeTariffValueException("Negative value in minute cost field");
        }
        if (Double.parseDouble(smsCost) >= 0){
            superTariff.setSmsCost(Double.parseDouble(smsCost));
        }else{
            throw new NegativeTariffValueException("Negative value in sms cost field");
        }
        if(Double.parseDouble(mbCost) >= 0){
            superTariff.setMbCost(Double.parseDouble(mbCost));
        }else{
            throw new NegativeTariffValueException("Negative value in mb cost field");
        }
        if(Integer.parseInt(minutesIncluded) >= 0){
            superTariff.setMinutesIncluded(Integer.parseInt(minutesIncluded));
        }else {
            throw new NegativeTariffValueException("Negative value in minutes included field");
        }
        if (Integer.parseInt(smsIncluded) >= 0){
            superTariff.setSmsIncluded(Integer.parseInt(smsIncluded));
        }else{
            throw new NegativeTariffValueException("Negative value in sms included field");
        }
        if(Integer.parseInt(mbIncluded) >= 0){
            superTariff.setMbIncluded(Integer.parseInt(mbIncluded));
        }else{
            throw new NegativeTariffValueException("Negative value in mb included field");
        }

        return superTariff;
    }
}
