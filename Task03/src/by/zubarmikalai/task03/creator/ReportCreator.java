package by.zubarmikalai.task03.creator;

import by.zubarmikalai.task03.entity.Broker;
import by.zubarmikalai.task03.entity.StockExchange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;

/**
 * Created by Nick on 20.10.16.
 */
public class ReportCreator {

    private static final Logger LOGGER = LogManager.getLogger(ReportCreator.class);
    private static final String ROOT = "report/report.txt";

    public static void createReport(){
        File report = new File(ROOT);
        List<Broker> brokerList = StockExchange.receiveBrokerList();
        FileWriter fileWriter;
        BufferedWriter bufferedReader;
        PrintWriter printWriter = null;
        try{
            fileWriter = new FileWriter(report, false);
            bufferedReader = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedReader);
            int lineSize = 60;
            for(int i = 0; i < lineSize; i++) {
                printWriter.print("=");
            }
            printWriter.println();
                printWriter.println("The winner is "+ brokerList.get(brokerList.size()-1));
            for(int i = 0; i < lineSize; i++) {
                printWriter.print("=");
            }
            printWriter.println();
            printWriter.println("The loser is "+ brokerList.get(0));
        } catch (IOException e) {
            LOGGER.error("File not found", e);
        }finally {
            if(printWriter != null){
                printWriter.close();
            }
        }
    }
}
