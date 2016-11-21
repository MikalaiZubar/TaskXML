package by.zubar.mikalai.pars.action;

import by.zubar.mikalai.pars.texttype.TextType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mikalay Zubar on 02.11.2016.
 */
public class Parser {


    public  List<String> parse(TextType type, String text){
        Pattern pattern = Pattern.compile(type.getRegex());
        Matcher matcher = pattern.matcher(text);
        List<String> stringList = new ArrayList<>();
        while (matcher.find()) {
            stringList.add(matcher.group());
        }
        return stringList;
    }

}
