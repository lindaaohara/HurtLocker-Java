package com.codedifferently;

import com.codedifferently.DataReader;
import org.junit.Assert;
import org.junit.Test;


public class TestDataReader {

    private static String sampleInput = "naMe:Milk;price:3.23;type:Food^expiration:1/25/2016##" +
            "naME:BreaD;price:1.23;type:Food%expiration:1/02/2016##";


    @Test
    public void testRawDataReader(){
        //Given
        DataReader dataReader = new DataReader();

        //When
        String expected = "[name:milk;price:3.23;type:food;expiration:1/25/2016" +
                ", name:bread;price:1.23;type:food;expiration:1/02/2016]";
        String actual = dataReader.rawDataReader(sampleInput);

        Assert.assertEquals(expected, actual);



    }
}
