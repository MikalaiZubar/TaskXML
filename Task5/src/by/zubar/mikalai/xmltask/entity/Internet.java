package by.zubar.mikalai.xmltask.entity;

/**
 * Created by Mikalay Zubar on 20.11.2016.
 */
public class Internet {
    private int mbIncluded;
    private double mbPrice;

    public int getMbIncluded() {
        return mbIncluded;
    }

    public void setMbIncluded(int mbIncluded) {
        this.mbIncluded = mbIncluded;
    }

    public double getMbPrice() {
        return mbPrice;
    }

    public void setMbPrice(double mbPrice) {
        this.mbPrice = mbPrice;
    }

    @Override
    public String toString() {
        return "Internet{" +
                "mbIncluded=" + mbIncluded +
                ", mbPrice=" + mbPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Internet internet = (Internet) o;

        if (getMbIncluded() != internet.getMbIncluded()) return false;
        return Double.compare(internet.getMbPrice(), getMbPrice()) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getMbIncluded();
        temp = Double.doubleToLongBits(getMbPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
