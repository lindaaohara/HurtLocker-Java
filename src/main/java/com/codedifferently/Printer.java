package com.codedifferently;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {

  private List<Item> itemList;

    public Printer(List<Item> itemList){
        this.itemList = itemList;
    }
    public Map<String, ArrayList<String>> getItemCount(){
        Map<String, ArrayList<String>> itemCount = new HashMap<>();
        for(Item item:itemList){
            ArrayList<String> listOfPrices = itemCount.get(item.getName());
            if(listOfPrices == null){
                listOfPrices = new ArrayList<>();
                itemCount.put(item.getName(), listOfPrices);
            }
            listOfPrices.add(item.getPrice());
        }
        return itemCount;
    }
}
