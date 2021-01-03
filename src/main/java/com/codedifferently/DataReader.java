package com.codedifferently;

import java.util.ArrayList;
import java.util.Arrays;

public class DataReader {
    /*
    public ArrayList<String> rawDataReader(String data){
        String[] dataArray = data.split("##");
        ArrayList<String> dataList = new ArrayList<>(Arrays.asList(dataArray));
        return dataList;
    }

     */


    public static String rawDataReader(String data){
        String cleanedData = null;
        String[] dataArray;

        String dataNoSpecialChars=data.replaceAll("[^0-9a-zA-Z#./:;]+",";");
        dataNoSpecialChars = dataNoSpecialChars.toLowerCase();
        dataArray =dataNoSpecialChars.split("##");
        cleanedData =Arrays.toString(dataArray);
        return cleanedData;
    }
}
