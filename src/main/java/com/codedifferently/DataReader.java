package com.codedifferently;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class DataReader {
    // take in raw data
    // replace unwanted special characters (keep #./:;) with ";"
    // split string into array at ## for end of line


    static String[] dataArray;

    public static String[] rawDataReader(String output){
        String dataNoSpecialChars=output.replaceAll("[^0-9a-zA-Z#./:;]+",";");
        dataNoSpecialChars = dataNoSpecialChars.toLowerCase();
        String []dataArray =dataNoSpecialChars.split("##");
        String cleanedData =Arrays.toString(dataArray);
        System.out.println(cleanedData);
        return dataArray;
    }
    public static String[]getDataArray(){
        return dataArray;
    }
}
