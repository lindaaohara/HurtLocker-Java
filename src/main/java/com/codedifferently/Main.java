package com.codedifferently;

import org.apache.log4j.Logger;
import org.apache.commons.io.IOUtils;

import java.util.*;


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
        String[] cleanedDataArray = DataReader.rawDataReader(output);
        Parser parser = new Parser();
        List<Item> itemList =parser.makeItemList(cleanedDataArray);

        Set<String> setOfKnownItemKeysAsName = new HashSet<>();

        for(Item item : itemList){
            setOfKnownItemKeysAsName.add(item.getName());
        }
        System.out.println(itemList);
        int numberOfErrors = parser.getErrorCounter();
        Printer printer = new Printer(itemList);
        Map<String, ArrayList<String>> groceryCount = printer.getItemCount();
        //ArrayList<String> milkPriceList = groceryCount.get("milk");
        for(String keyNameOfItem : setOfKnownItemKeysAsName){
            int counterOfItem = groceryCount.get(keyNameOfItem).size();
            System.out.println(keyNameOfItem + ": " + counterOfItem);
            System.out.println(ItemStringFormatter.createColumnString(keyNameOfItem, counterOfItem));

            HashMap<String, Integer> pricesOccurances = new HashMap<String, Integer>();
            for(String price: groceryCount.get(keyNameOfItem)){
                pricesOccurances.put(price, pricesOccurances.get(price) != null ? pricesOccurances.get(price) + 1 : 1 );
                System.out.println(ItemStringFormatter.createColumnString(keyNameOfItem,pricesOccurances.get(price)));
            }
        }
    }
}
