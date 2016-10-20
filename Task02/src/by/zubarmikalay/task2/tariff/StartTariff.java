package by.zubarmikalay.task2.tariff;


import by.zubarmikalay.task2.constant.Constant;

/**
 * Created by Nick on 29.09.16.
 */
public class StartTariff extends Tariff {

    private int startTariffId;
    private final double SUBSCRIPTON_FEE = 0.0;
    private double minuteCost;
    private double smsCost;
    private String name;
    private static int numberOfStartTariffs;

    public StartTariff() {
        numberOfStartTariffs++;
        startTariffId = numberOfStartTariffs;
    }

    public StartTariff(String name, double minuteCost, double smsCost) {
        this.name = name;
        this.minuteCost = minuteCost;
        this.smsCost = smsCost;
    }

    public double getSubscriptionFee() {
        return SUBSCRIPTON_FEE;
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

    public int getStartTariffId() {
        return startTariffId;
    }

    public void setStartTariffId(int startTariffId) {
        this.startTariffId = startTariffId;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" "+name + " { id "+startTariffId+": subscribtion fee "+
                SUBSCRIPTON_FEE+ '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StartTariff)) return false;

        StartTariff that = (StartTariff) o;

        if (Double.compare(that.SUBSCRIPTON_FEE, SUBSCRIPTON_FEE) != 0) return false;
        if (Double.compare(that.getMinuteCost(), getMinuteCost()) != 0) return false;
        if (Double.compare(that.getSmsCost(), getSmsCost()) != 0) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(SUBSCRIPTON_FEE);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getMinuteCost());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getSmsCost());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
