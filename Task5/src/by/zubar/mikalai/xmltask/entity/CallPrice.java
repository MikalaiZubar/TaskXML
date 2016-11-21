package by.zubar.mikalai.xmltask.entity;

/**
 * Created by Mikalay Zubar on 20.11.2016.
 */
public class CallPrice {
    private double internalCall;
    private double externalCall;
    private double internationalCall;


    public double getInternalCall() {
        return internalCall;
    }

    public void setInternalCall(double internalCall) {
        this.internalCall = internalCall;
    }

    public double getExternalCall() {
        return externalCall;
    }

    public void setExternalCall(double externalCall) {
        this.externalCall = externalCall;
    }

    public double getInternationalCall() {
        return internationalCall;
    }

    public void setInternationalCall(double internationalCall) {
        this.internationalCall = internationalCall;
    }

    @Override
    public String toString() {
        return "CallPrice{" +
                "internalCall=" + internalCall +
                ", externalCall=" + externalCall +
                ", internationalCall=" + internationalCall +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CallPrice callPrice = (CallPrice) o;

        if (Double.compare(callPrice.getInternalCall(), getInternalCall()) != 0) return false;
        if (Double.compare(callPrice.getExternalCall(), getExternalCall()) != 0) return false;
        return Double.compare(callPrice.getInternationalCall(), getInternationalCall()) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getInternalCall());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getExternalCall());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getInternationalCall());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
