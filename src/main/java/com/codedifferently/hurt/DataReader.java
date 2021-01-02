package com.codedifferently.hurt;

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
    public String[] rawDataReader(String data){
        String[] dataArray =data.split("##");
        return dataArray;
    }
}
