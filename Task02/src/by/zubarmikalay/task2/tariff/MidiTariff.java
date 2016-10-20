package by.zubarmikalay.task2.tariff;

/**
 * Created by Nick on 30.09.16.
 */
public class MidiTariff extends StartTariff {
    private int midiTariffId;
    private String name;
    private double subscriptionFee;
    private double minuteCost;
    private double smsCost;
    private int minutesIncluded;
    private int smsIncluded;
    private static int numberOfMidiTariffs;

    public MidiTariff() {
        numberOfMidiTariffs++;
        midiTariffId = numberOfMidiTariffs;
    }

    public MidiTariff(String name, double subscriptionFee, double minuteCost, double smsCost, int minutesIncluded, int smsIncluded) {
        this.name = name;
        this.subscriptionFee = subscriptionFee;
        this.minuteCost = minuteCost;
        this.smsCost = smsCost;
        this.minutesIncluded = minutesIncluded;
        this.smsIncluded = smsIncluded;
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
        return getClass().getSimpleName()+"  "+name+" { id "+midiTariffId+": subscribtion fee "+
                subscriptionFee+ '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MidiTariff)) return false;
        if (!super.equals(o)) return false;

        MidiTariff that = (MidiTariff) o;

        if (Double.compare(that.getSubscriptionFee(), getSubscriptionFee()) != 0) return false;
        if (Double.compare(that.getMinuteCost(), getMinuteCost()) != 0) return false;
        if (Double.compare(that.getSmsCost(), getSmsCost()) != 0) return false;
        if (getMinutesIncluded() != that.getMinutesIncluded()) return false;
        if (getSmsIncluded() != that.getSmsIncluded()) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;

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
        result = 31 * result + getMinutesIncluded();
        result = 31 * result + getSmsIncluded();
        return result;
    }
}

