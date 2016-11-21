package by.zubar.mikalai.xmltask.entity;

/**
 * Created by Mikalay Zubar on 20.11.2016.
 */
public class VoiceTariff extends Tariff {
    private TariffParam tariffParam;

    public VoiceTariff(){}

    public VoiceTariff(String name, String operator, double payroll, CallPrice callPrice, MessagePrice messagePrice, TariffParam tariffParam) {
        super(name, operator, callPrice, messagePrice, payroll);
        this.tariffParam = tariffParam;
    }

    public VoiceTariff (String name, String operator, double payroll){
        super(name, operator, payroll);
    }

    public TariffParam getTariffParam() {
        return tariffParam;
    }

    public void setTariffParam(TariffParam tariffParam) {
        this.tariffParam = tariffParam;
    }

    @Override
    public void setInternet(Internet internet) {

    }

    @Override
    public Internet getInternet() {
        return null;
    }

    @Override
    public String toString() {
        return  "VoiceTariff{" +"\n"+
                "name=" + super.getName()+ "\n" +
                "operator=" + super.getOperator() + "\n" +
                "payroll=" + String.valueOf(super.getPayroll()) + "\n" +
                super.getCallPrice().toString() + "\n" +
                super.getMessagePrice().toString() + "\n" +
                tariffParam +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        VoiceTariff that = (VoiceTariff) o;

        return getTariffParam().equals(that.getTariffParam());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getTariffParam().hashCode();
        return result;
    }
}
