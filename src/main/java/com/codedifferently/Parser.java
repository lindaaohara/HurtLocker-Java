package com.codedifferently;

import com.codedifferently.Item;
import exceptions.ItemCreationException;
import exceptions.ItemMissingKeyException;
import exceptions.ItemMissingValueException;

import java.util.*;

public class Parser {

    //take in cleaned data string from DataReader
    //separate at ; to get keys
    //set the map with keys for name, price, type, and expiration
    //set value based on :
    //fix c0okies by replacing zero

    private ArrayList<String> listOfKeys;


    private int errorCounter;

    public Parser(){
        listOfKeys= new ArrayList<>();
        listOfKeys.add("name");
        listOfKeys.add("price");
        listOfKeys.add("type");
        listOfKeys.add("expiration");


    }
    public List<Item> makeItemList(String[] cleanedDataArray) throws Exception {
       List<Item> itemsList = new ArrayList();
       for(String cleanedData : cleanedDataArray){
           Item item = makeItemFromString(cleanedData);
           if(item != null){
               itemsList.add(item);
           }

       }
       return itemsList;
    }

    public Item makeItemFromString(String cleanedData) throws Exception {
        HashMap<String, String> itemData = new HashMap<>();
        try {
            for (String key : listOfKeys) {
                String value = findFieldByKeyValue(key, cleanedData);
                itemData.put(key, value);
            }
            return new Item(itemData);

            } catch(ItemMissingKeyException exception){
                System.out.println("MissingKeyException");
                //return null;
            } catch(ItemMissingValueException exception){
                System.out.println("MissingValueException");
                //return null;
            }
        return new Item(itemData);

    }



    public String findFieldByKeyValue(String key, String cleanedData) throws Exception {
        String[] dataArray = cleanedData.split(";");
        String value = null;
        for (String item : dataArray) {
            System.out.println("item: " + item);
            System.out.println("key: " + key);
            String[] itemArray = item.split(":");
            System.out.println("itemArray[0]: " + itemArray[0]);
            if (listOfKeys.contains(itemArray[0])) {

                if (itemArray.length < 2) {
                    errorCounter++;
                    throw new ItemMissingValueException();
                }
                value = itemArray[1];


            } else {
                errorCounter++;
                throw new ItemMissingKeyException();

            }
        }
        return value;
    }



    public int getErrorCounter(){
        return errorCounter;
    }
}

