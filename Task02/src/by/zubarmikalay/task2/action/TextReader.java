package by.zubarmikalay.task2.action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Nick on 30.09.16.
 */
public class TextReader {


    public List<String> textReader(String s) throws IOException{
        Path path = Paths.get(s);
        List<String> tariffList = Files.readAllLines(path);
        return tariffList;

    }


}
