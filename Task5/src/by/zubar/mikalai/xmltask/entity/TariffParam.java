package by.zubar.mikalai.xmltask.entity;

/**
 * Created by Mikalay Zubar on 20.11.2016.
 */
public class TariffParam {
    private double minPrepayment;
    private int tarification;
    private int favouriteNums;

    public double getMinPrepayment() {
        return minPrepayment;
    }

    public void setMinPrepayment(double minPrepayment) {
        this.minPrepayment = minPrepayment;
    }

    public int getTarification() {
        return tarification;
    }

    public void setTarification(int tarification) {
        this.tarification = tarification;
    }

    public int getFavouriteNums() {
        return favouriteNums;
    }

    public void setFavouriteNums(int favouriteNums) {
        this.favouriteNums = favouriteNums;
    }

    @Override
    public String toString() {
        return "TariffParam{" +
                "minPrepayment=" + minPrepayment +
                ", tarification=" + tarification +
                ", favouriteNums=" + favouriteNums +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TariffParam that = (TariffParam) o;

        if (Double.compare(that.getMinPrepayment(), getMinPrepayment()) != 0) return false;
        if (getTarification() != that.getTarification()) return false;
        return getFavouriteNums() == that.getFavouriteNums();

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getMinPrepayment());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + getTarification();
        result = 31 * result + getFavouriteNums();
        return result;
    }
}
