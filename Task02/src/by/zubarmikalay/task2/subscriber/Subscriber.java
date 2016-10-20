package by.zubarmikalay.task2.subscriber;

import by.zubarmikalay.task2.tariff.Tariff;

/**
 * Created by Nick on 05.10.16.
 */
public class Subscriber {

    private String subscriberName;
    private double sumOfPayment;
    private double currentAccount;
    private int subscriberId;
    private Tariff tariff;
    private static int numberOfSubscribers;


    public Subscriber(){
        numberOfSubscribers ++;
        subscriberId = numberOfSubscribers;
    }

    public Subscriber(String name, Tariff tariff, double sumOfPayment){
        subscriberName = name;
        this.tariff = tariff;
        this.sumOfPayment = sumOfPayment;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public double getSumOfPayment() {
        return sumOfPayment;
    }

    public void setSumOfPayment(double sumOfPayment) {
        this.sumOfPayment = sumOfPayment;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public double getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(double currentAccount) {
        this.currentAccount = currentAccount;
    }

    public static int getNumberOfSubscribers() {
        return numberOfSubscribers;
    }

    public static void setNumberOfSubscribers(int numberOfSubscribers) {
        Subscriber.numberOfSubscribers = numberOfSubscribers;
    }

    @Override
    public String toString() {
        return  "subscriberName='" + subscriberName + '\'' +
                ", sumOfPayment=" + sumOfPayment +
                ", currentAccount=" + currentAccount +
                ", subscriberId=" + subscriberId +
                ", tariff=" + tariff.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscriber)) return false;

        Subscriber that = (Subscriber) o;

        if (Double.compare(that.getSumOfPayment(), getSumOfPayment()) != 0) return false;
        if (getSubscriberName() != null ? !getSubscriberName().equals(that.getSubscriberName()) : that.getSubscriberName() != null)
            return false;
        return getTariff() != null ? getTariff().equals(that.getTariff()) : that.getTariff() == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getSubscriberName() != null ? getSubscriberName().hashCode() : 0;
        temp = Double.doubleToLongBits(getSumOfPayment());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getTariff() != null ? getTariff().hashCode() : 0);
        return result;
    }
}
