package by.zubarmikalay.task2.constant;

/**
 * Created by Nick on 04.10.16.
 */
public class Constant {

    private static final String ROOT = "txt/settariff.txt";
    private static final String SUBSCRIBER_ROOT = "txt/subscribers.txt";
    private static final String REPORT_ROOT = "txt/report.txt";
    private static final String SEARCH_ROOT = "txt/searchtariff.txt";
    private static final String TARIFF_1 = "start";
    private static final String TARIFF_2 = "midi";
    private static final String TARIFF_3 = "super";

    private Constant(){

    }

    public static String getRoot(){
        return ROOT;
    }

    public static String getSubscriberRoot() {
        return SUBSCRIBER_ROOT;
    }

    public static String getReportRoot() {
        return REPORT_ROOT;
    }

    public static String getSearchRoot() {
        return SEARCH_ROOT;
    }

    public static String getTariff1() {
        return TARIFF_1;
    }

    public static String getTariff2() {
        return TARIFF_2;
    }

    public static String getTariff3() {
        return TARIFF_3;
    }

}
