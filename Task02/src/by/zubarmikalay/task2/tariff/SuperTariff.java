package by.zubarmikalay.task2.tariff;

/**
 * Created by Nick on 30.09.16.
 */
public class SuperTariff extends MidiTariff {
    private int superTariffId;
    private String name;
    private double subscriptionFee;
    private double minuteCost;
    private double smsCost;
    private double mbCost;
    private int minutesIncluded;
    private int smsIncluded;
    private int mbIncluded;
    private static int numberOfSuperTariffs;


    public SuperTariff() {
        numberOfSuperTariffs++;
        superTariffId = numberOfSuperTariffs;
    }

    public SuperTariff(String name, double subscriptionFee, double minuteCost, double smsCost, double mbCost, int minutesIncluded, int smsIncluded, int mbIncluded) {
        this.name = name;
        this.subscriptionFee = subscriptionFee;
        this.minuteCost = minuteCost;
        this.smsCost = smsCost;
        this.mbCost = mbCost;
        this.minutesIncluded = minutesIncluded;
        this.smsIncluded = smsIncluded;
        this.mbIncluded = mbIncluded;
    }

    @Override
    public double getSubscriptionFee() {
        return subscriptionFee;
    }

    @Override
    public void setSubscriptionFee(double subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    @Override
    public double getMinuteCost() {
        return minuteCost;
    }

    @Override
    public void setMinuteCost(double minuteCost) {
        this.minuteCost = minuteCost;
    }

    @Override
    public double getSmsCost() {
        return smsCost;
    }

    @Override
    public void setSmsCost(double smsCost) {
        this.smsCost = smsCost;
    }

    public double getMbCost() {
        return mbCost;
    }

    public void setMbCost(double mbCost) {
        this.mbCost = mbCost;
    }

    public int getMinutesIncluded() {
        return minutesIncluded;
    }

    public void setMinutesIncluded(int minutesIncluded) {
        this.minutesIncluded = minutesIncluded;
    }

    public int getSmsIncluded() {
        return smsIncluded;
    }

    public void setSmsIncluded(int smsIncluded) {
        this.smsIncluded = smsIncluded;
    }

    public int getMbIncluded() {
        return mbIncluded;
    }

    public void setMbIncluded(int mbIncluded) {
        this.mbIncluded = mbIncluded;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" "+name + " { id "+superTariffId
                +": subscribtion fee "+subscriptionFee+'}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuperTariff)) return false;
        if (!super.equals(o)) return false;

        SuperTariff tariff = (SuperTariff) o;

        if (Double.compare(tariff.getSubscriptionFee(), getSubscriptionFee()) != 0) return false;
        if (Double.compare(tariff.getMinuteCost(), getMinuteCost()) != 0) return false;
        if (Double.compare(tariff.getSmsCost(), getSmsCost()) != 0) return false;
        if (Double.compare(tariff.getMbCost(), getMbCost()) != 0) return false;
        if (getMinutesIncluded() != tariff.getMinutesIncluded()) return false;
        if (getSmsIncluded() != tariff.getSmsIncluded()) return false;
        if (getMbIncluded() != tariff.getMbIncluded()) return false;
        return getName() != null ? getName().equals(tariff.getName()) : tariff.getName() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        temp = Double.doubleToLongBits(getSubscriptionFee());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getMinuteCost());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getSmsCost());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getMbCost());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getMinutesIncluded();
        result = 31 * result + getSmsIncluded();
        result = 31 * result + getMbIncluded();
        return result;
    }
}
