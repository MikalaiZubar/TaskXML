package by.zubar.mikalai.xmltask.entity;

/**
 * Created by Mikalay Zubar on 20.11.2016.
 */
public abstract class Tariff {
    private String name;
    private String operator;
    private CallPrice callPrice;
    private MessagePrice messagePrice;
    private double payroll;

    public Tariff(){}

    public Tariff(String name, String operator, double payroll){
        this.name = name;
        this.operator = operator;
        this.payroll = payroll;
    }

    public Tariff(String name, String operator, CallPrice callPrice, MessagePrice messagePrice, double payroll) {
        this.name = name;
        this.operator = operator;
        this.callPrice = callPrice;
        this.messagePrice = messagePrice;
        this.payroll = payroll;
    }

    public String getName() {
        return name;
    }

    public abstract void setTariffParam(TariffParam param);

    public abstract TariffParam getTariffParam();

    public abstract void setInternet(Internet internet);

    public abstract Internet getInternet();

    public void setName(String name) {
        this.name = name;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public CallPrice getCallPrice() {
        return callPrice;
    }

    public void setCallPrice(CallPrice callPrice) {
        this.callPrice = callPrice;
    }

    public MessagePrice getMessagePrice() {
        return messagePrice;
    }

    public void setMessagePrice(MessagePrice messagePrice) {
        this.messagePrice = messagePrice;
    }

    public double getPayroll() {
        return payroll;
    }

    public void setPayroll(double payroll) {
        this.payroll = payroll;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "name='" + name + '\'' +
                ", operator='" + operator + '\'' +
                ", callPrice=" + callPrice +
                ", messagePrice=" + messagePrice +
                ", payroll=" + payroll +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tariff tariff = (Tariff) o;

        if (Double.compare(tariff.payroll, payroll) != 0) return false;
        if (!name.equals(tariff.name)) return false;
        if (!operator.equals(tariff.operator)) return false;
        if (!callPrice.equals(tariff.callPrice)) return false;
        return messagePrice.equals(tariff.messagePrice);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + operator.hashCode();
        result = 31 * result + callPrice.hashCode();
        result = 31 * result + messagePrice.hashCode();
        temp = Double.doubleToLongBits(payroll);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
