package com.codedifferently;

import java.util.ArrayList;
import java.util.Arrays;

public class DataReader {
    // take in raw data
    // replace unwanted special characters (keep #./:;) with ;
    // split string into array at ## for end of line

    public static String[] rawDataReader(String data){
        String cleanedData = null;
        String[] dataArray;

        String dataNoSpecialChars=data.replaceAll("[^0-9a-zA-Z#./:;]+",";");
        dataNoSpecialChars = dataNoSpecialChars.toLowerCase();
        dataArray =dataNoSpecialChars.split("##");
        cleanedData =Arrays.toString(dataArray);
        System.out.println(cleanedData);
        return dataArray;
    }
}
