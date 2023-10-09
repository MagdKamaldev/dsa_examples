package com.array;

import java.util.Arrays;
import java.util.List;

public class count_items_matching_a_rule {
    public static void main(String[] args) {
        List<List<String>> items = Arrays.asList(
                Arrays.asList("phone", "blue", "pixel"),
                Arrays.asList("computer", "silver", "lenovo"),
                Arrays.asList("phone", "gold", "iphone")
        );

        String ruleKey = "color";
        String ruleValue = "silver";

        int result = countMatches(items, ruleKey, ruleValue);
        System.out.println("Count: " + result);
    }
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
      int count = 0;
      int category;
        if(ruleKey.equals("type")){
        category = 0;
        }else if(ruleKey.equals("color")){
            category = 1;
        }else if(ruleKey.equals("name")){
            category = 2;
        }else{
            return -1;
        }

      for (int i = 0 ;i<items.size();i++){
        if(items.get(i).get(category).equals(ruleValue)){
            count++;
        }
      }
      return count;
    }
}
