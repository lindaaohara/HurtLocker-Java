package com.codedifferently;

import org.apache.log4j.Logger;
import org.apache.commons.io.IOUtils;



public class Main {

    private final static Logger logger = Logger.getLogger(Main.class);

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }


    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }
}
