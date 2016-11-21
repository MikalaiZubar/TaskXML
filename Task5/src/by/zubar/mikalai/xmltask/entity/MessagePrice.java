package by.zubar.mikalai.xmltask.entity;

/**
 * Created by Mikalay Zubar on 20.11.2016.
 */
public class MessagePrice {
    private double smsPrice;
    private double mmsPrice;

    public double getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(double smsPrice) {
        this.smsPrice = smsPrice;
    }

    public double getMmsPrice() {
        return mmsPrice;
    }

    public void setMmsPrice(double mmsPrice) {
        this.mmsPrice = mmsPrice;
    }

    @Override
    public String toString() {
        return "MessagePrice{" +
                "smsPrice=" + smsPrice +
                ", mmsPrice=" + mmsPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessagePrice that = (MessagePrice) o;

        if (Double.compare(that.getSmsPrice(), getSmsPrice()) != 0) return false;
        return Double.compare(that.getMmsPrice(), getMmsPrice()) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getSmsPrice());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getMmsPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
