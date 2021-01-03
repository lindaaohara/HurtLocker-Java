package com.codedifferently;

import com.codedifferently.Item;
import exceptions.ItemCreationException;
import exceptions.ItemMissingKeyException;
import exceptions.ItemMissingValueException;

import java.util.*;

public class Parser {

    //split result of readRawDataToString into lines at "##"
    //replace ^%*!@ characters after Food with ;
    //separate at ; to get keys
    //set the map with keys for name, price, type, and expiration
    //set value based on :
    //do regex on keys and values

    private ArrayList<String> listOfKeys;


    private int errorCounter;

    public Parser(){
        listOfKeys= new ArrayList<>();
        listOfKeys.add("name");
        listOfKeys.add("price");
        listOfKeys.add("type");
        listOfKeys.add("expiration");

    }

    public Item makeItemFromString(String cleanedData) throws Exception {
        HashMap<String, String> itemData = new HashMap<>();
        try {
            for (String key : listOfKeys) {
                String value = findFieldByKeyValue(key, cleanedData);
                itemData.put(key, value);
            }
            return new Item(itemData);
        } catch (ItemMissingKeyException exception) {
            throw new ItemCreationException();
        } catch (ItemMissingValueException exception) {
            throw new ItemCreationException();
        }
    }



    public String findFieldByKeyValue(String key, String cleanedData) throws Exception{
        String[] dataArray = cleanedData.split(";");
        String value = null;
        for(String item : dataArray){
            if(item.contains(key)){
                String[] itemArray = item.split(":");
                if(itemArray.length < 2) throw new ItemMissingValueException();
                value = itemArray[1];
                errorCounter++;
            }
        }
        if(value == null) throw new ItemMissingKeyException();
        errorCounter++;
        return value;
    }

    public int getErrorCounter(){
        return errorCounter;
    }
}

