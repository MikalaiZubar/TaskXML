package by.zubar.mikalai.xmltask.entity;

/**
 * Created by Mikalay Zubar on 20.11.2016.
 */
public class InternetTariff extends VoiceTariff {
    private Internet internet;

    public InternetTariff(){}

    public InternetTariff(String name, String operator, double payroll) {
        super(name, operator, payroll);
    }

    public InternetTariff(String name, String operator, double payroll, CallPrice callPrice, MessagePrice messagePrice, TariffParam tariffParam, Internet internet) {
        super(name, operator, payroll, callPrice, messagePrice, tariffParam);
        this.internet = internet;
    }

    public Internet getInternet() {
        return internet;
    }

    public void setInternet(Internet internet) {
        this.internet = internet;
    }

    @Override
    public String toString() {
        return "InternetTariff{" +"\n"+
                "name=" + super.getName()+ "\n" +
                "operator=" + super.getOperator() + "\n" +
                "payroll=" + String.valueOf(super.getPayroll()) + "\n" +
                super.getCallPrice().toString() + "\n" +
                super.getMessagePrice().toString() + "\n" +
                super.getTariffParam() + "\n" +
                internet +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        InternetTariff that = (InternetTariff) o;

        return getInternet().equals(that.getInternet());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getInternet().hashCode();
        return result;
    }
}
