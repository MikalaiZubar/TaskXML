package by.zubarmikalay.task2.tariff;

/**
 * Created by Nick on 05.10.16.
 */
public abstract class Tariff {
    private  String name;
    private  double subscriptionFee;
    private  double minuteCost;
    private  double smsCost;


    public double getSubscriptionFee() {
        return subscriptionFee;
    }

    public void setSubscriptionFee(double subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public double getMinuteCost() {
        return minuteCost;
    }

    public void setMinuteCost(double minuteCost) {
        this.minuteCost = minuteCost;
    }

    public double getSmsCost() {
        return smsCost;
    }

    public void setSmsCost(double smsCost) {
        this.smsCost = smsCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
