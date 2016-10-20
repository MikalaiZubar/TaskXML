package by.zubarmikalai.task03.entity;


/**
 * Created by Nick on 11.10.16.
 */
public class Stock {
    private static long count = 0;
    private long id = count++;
    private double cost;
    private int issue;

    public Stock(double cost, int issue){
        this.cost = cost;
        this.issue = issue;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    public int getIssue() {
        return issue;
    }


    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", cost=" + cost +
                ", issue=" + issue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;

        Stock stock = (Stock) o;

        return getId() == stock.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}
