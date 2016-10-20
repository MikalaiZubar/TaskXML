package by.zubarmikalay.task2.action;

import by.zubarmikalay.task2.constant.Constant;
import by.zubarmikalay.task2.subscriber.Subscriber;
import by.zubarmikalay.task2.subscriber.SubscriberList;
import by.zubarmikalay.task2.tariff.Tariff;
import by.zubarmikalay.task2.tariff.TariffList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;

/**
 * Created by Nick on 09.10.16.
 */
public class TextWriter {

    private static final Logger LOGGER = LogManager.getLogger(TextWriter.class);

    public static void createReport(TariffList tariffList, SubscriberList subscriberList, List<Tariff> list){
        File report = new File(Constant.getReportRoot());
        List<Tariff> tariffs = tariffList.getTariffList();
        List<Subscriber> subscribers = subscriberList.getSubscriberList();
        FileWriter fileWriter = null;
        BufferedWriter bufferedReader = null;
        PrintWriter printWriter = null;
        try{
            fileWriter = new FileWriter(report, false);
            bufferedReader = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedReader);
            int lineSize = 90;
            for(int i = 0; i < lineSize; i++) {
                printWriter.print("=");
            }
            printWriter.println();
            for (Tariff t: tariffs){
                printWriter.println(t);
            }
            for(int i = 0; i < lineSize; i++) {
                printWriter.print("=");
            }
            printWriter.println();

            for (Subscriber s: subscribers){
                printWriter.println(s);
            }
            for(int i = 0; i < lineSize; i++) {
                printWriter.print("=");
            }
            printWriter.println();
            printWriter.println("Total subscribers amount: " + Subscriber.getNumberOfSubscribers());
            for(int i = 0; i < lineSize; i++) {
                printWriter.print("=");
            }

            printWriter.println();
            printWriter.println("Recommended tariffs:");
            if(list == null){
                printWriter.println("No adjustable tariff found");
            }else {
                for (Tariff t : list) {
                    printWriter.println(t);
                }
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }finally {
            if(printWriter != null){
               printWriter.close();
            }
        }
    }
}
