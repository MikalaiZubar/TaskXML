package by.zubar.mikalai.pars.test;

import by.zubar.mikalai.pars.action.ConverterToRPN;
import by.zubar.mikalai.pars.action.Parser;
import by.zubar.mikalai.pars.exception.EmptyFileException;
import by.zubar.mikalai.pars.interpreter.Client;
import by.zubar.mikalai.pars.reader.TextReader;
import by.zubar.mikalai.pars.texttype.TextType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikalay Zubar on 13.11.2016.
 */
public class TextTest {

    private final String INCREMENT_LEXEME = "2+(2-3)*(++1)";
    private final String LEXEME = "2+(2-3)*(2)";
    private final String EXPECTED_PRN = "2 2 3 - 2  * +";
    private Client client = new Client(EXPECTED_PRN);
    private final Double EXPECTED_RESULT = 0.0;
    private final String TEST_ROOT = "testText/testText";
    private static final List<String>  EXPECTED_LIST;

    static{
        EXPECTED_LIST = new ArrayList<>();
        EXPECTED_LIST.add("Hello, it's a test.");
        EXPECTED_LIST.add("Calculating 2+(2-3)*2 is - 0.");
    }

    @Test
    public void convertTest(){
        String prn = ConverterToRPN.convert(LEXEME);
        Assert.assertTrue(EXPECTED_PRN.equals(prn));
    }

    @Test
    public void scanForIncrementTest(){
        String expression = ConverterToRPN.scanForIncrement(INCREMENT_LEXEME);
        Assert.assertTrue(LEXEME.equals(expression));
    }

    @Test
    public void calculateTest(){
        double result  = client.calculate();
        Assert.assertTrue(EXPECTED_RESULT == (result));
    }

    @Test
    public void parseTest() throws EmptyFileException{
        Parser parser = new Parser();
        List<String> resultList = parser.parse(TextType.PARAGRAPH, TextReader.readTextFile(TEST_ROOT));
        boolean result = EXPECTED_LIST.equals(resultList);
        Assert.assertTrue(result);
    }

}
