package com.codedifferently.hurt;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {

    //split result of readRawDataToString into lines at "##"
    //replace ^%*!@ characters after Food with ;
    //separate at ; to get keys
    //set the map with keys for name, price, type, and expiration
    //set value based on :
    //do regex on keys and values
    private String[]dataArray;
    private String result;
    private String namePattern = "(^\\w{4}:)(\\w+)";
    private String pricePattern = "(\\d\\.\\d{2})";
    private int errorCounter;

    public String nameParser(String stringToParse) throws NullPointerException{
        String itemName = "";
        Pattern nameRegex = Pattern.compile(namePattern);
        Matcher nameMatcher = nameRegex.matcher(stringToParse);
        try{
            if(nameMatcher.find()) {
                itemName = nameMatcher.group(2);
                return itemName;
            } else{
                throw new NullPointerException();
            }
        } catch(NullPointerException npe){
            errorCounter++;
        }
        return itemName;

    }
    public String priceParser(String stringToParse) throws NullPointerException{
        String itemPrice = "";
        Pattern priceRegex = Pattern.compile(pricePattern);
        Matcher priceMatcher = priceRegex.matcher(stringToParse);
        try{
            if(priceMatcher.find()) {
                itemPrice = priceMatcher.group(1);
                return itemPrice;
            } else{
                throw new NullPointerException();
            }
        } catch(NullPointerException npe){
            errorCounter++;
        }
        return itemPrice;

    }


    public String formatResult(String dataArray) {
        String line = dataArray;

        line = line.replace("^", ";");
        line = line.replace("%", ";");
        line = line.replace("*", ";");
        line = line.replace("!", ";");
        line = line.replace("@", ";");

        HashMap<String, String> map = Arrays.stream(line.split(";"))
                .map(entry -> entry.split(":"))
                .collect(Collectors.toMap(entry -> entry[0], entry->entry[1]));
        return map.toString();



    }


   // public Parser(String name, Double price, String type, Date expiration){


    //}



 //   public String findValueByKey(String key, String data){

  //      return null;
  //  }


    public int getErrorCounter(){
        return errorCounter;
    }
}

