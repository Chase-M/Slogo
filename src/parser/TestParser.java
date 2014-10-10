package parser;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestParser {
    @Test
    public void TestSplit(){
    Parser p=new Parser();
    p.parse("hello     world");
    System.out.println();
    p.parse("adshfl;adsfa  \n  hsadfkjadhsf");
    assertEquals(" "," ");
}
}
