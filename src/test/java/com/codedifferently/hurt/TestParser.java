package com.codedifferently.hurt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestParser {
    private static String sampleInput = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";

    Parser parser;
    @Before
    public void setup(){
        parser = new Parser();
    }

    @Test
    public void testNameParser(){

        String expected = "Milk";
        String actual = parser.nameParser(sampleInput);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNullNameParser(){

        String sampleInput2="naMe:;price:3.23;type:Food^expiration:1/04/2016";

        int expectedErrorCounter =1;
        parser.nameParser(sampleInput2);
        int actualErrorCounter = parser.getErrorCounter();

        Assert.assertEquals(expectedErrorCounter, actualErrorCounter);
    }

    @Test
    public void testPriceParser(){
        String expected = "3.23";
        String actual = parser.priceParser(sampleInput);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testNullPriceParser(){
        String sampleInput3="naMe:Milk;price:;type:Food^expiration:1/04/2016";

        int expectedErrorCounter = 1;
        parser.priceParser(sampleInput3);
        int actualErrorCounter = parser.getErrorCounter();

        Assert.assertEquals(expectedErrorCounter, actualErrorCounter);

    }
    @Test
    public void testMap(){
        String sampleInput3="naMe:Milk;price:;type:Food^expiration:1/04/2016";
        HashMap<String, String> map = new HashMap;

        String expected = "Milk";
        String actual = parser.formatResult(sampleInput3).map.get("name");
        Assert.assertEquals(expected, actual);
    }
}
