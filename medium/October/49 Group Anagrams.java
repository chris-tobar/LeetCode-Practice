package medium.October;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class problem49{
    
    public static void main(String[] args) {
        
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
  
        //Have a hashmap store the buckets, and a way to identify them
        HashMap<String, List<String>> map = new HashMap<>();
        
        //Iterate through the array
        for(String word: strs)
        {
            //Convert the string into a character array
            char[] ca = word.toCharArray();
            //Sort the array
            Arrays.sort(ca);
            //Get the String value of that character array
            String keyString = String.valueOf(ca);
            
            //Value doesn't exist, so we create a new list for that value
            if(!map.containsKey(keyString))
                map.put(keyString, new ArrayList<>());
            
            //Get the list, and add the string to it
            map.get(keyString).add(word);
        }
        
        //Convert all the values in the map, into an array list
        return new ArrayList<>( map.values() );
    }
}
