package com.codedifferently;

import com.codedifferently.Item;
import com.codedifferently.Parser;
import exceptions.ItemMissingKeyException;
import exceptions.ItemMissingValueException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;


public class TestParser {
    private static String sampleCleanedData="name:milk;price:3.23;type:food;expiration:1/04/2016";
    private static String sampleMissingValue="name:;  price:3.23; type: food; expiration: 1/04/2016";
    private static String sampleMissingKey= ":milk;  price:3.23; type: food; expiration: 1/04/2016";

    Parser parser;
    @Before
    public void setup(){
        parser = new Parser();
        int errorCounter=0;
    }

    @Test
    public void testNameParser() throws Exception{

        String expected = "milk";
        String actual = parser.findFieldByKeyValue("name",sampleCleanedData);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testErrorCounter() throws Exception {

        int expectedErrorCounter =1;
        parser.findFieldByKeyValue("name", sampleMissingValue);
        int actualErrorCounter = parser.getErrorCounter();

        Assert.assertEquals(expectedErrorCounter, actualErrorCounter);
    }

    @Test
    public void testPriceParser()throws Exception{
        String expected = "3.23";
        String actual = parser.findFieldByKeyValue("price", sampleCleanedData);

        Assert.assertEquals(expected, actual);
    }


    @Test(expected = ItemMissingKeyException.class)
    public void findFieldByKeyValueTest1() throws Exception{
        parser.findFieldByKeyValue("name", sampleMissingKey);
    }

    @Test(expected = ItemMissingValueException.class)
    public void findFieldByKeyValueTest2() throws Exception{
        parser.findFieldByKeyValue("name", sampleMissingValue);
    }

    @Test
    public void makeItemFromString() throws Exception{
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "milk");
        data.put("price", "3.23");
        data.put("type", "food");
        data.put("expiration", "1/04/2016");
        Item expected = new Item(data);
        Item actual = parser.makeItemFromString(sampleCleanedData);
        Assert.assertEquals(expected.toString(), actual.toString());
    }
}
