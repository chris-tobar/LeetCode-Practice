package medium.October;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class problem49{
    
    public static void main(String[] args) {
        
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
  
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String word: strs)
        {
            char[] ca = word.toCharArray();
            Arrays.sort(ca);
            String keyString = String.valueOf(ca);
            
            if(!map.containsKey(keyString))
                map.put(keyString, new ArrayList<>());
            
            map.get(keyString).add(word);
        }
        
        return new ArrayList<>( map.values() );
    }
}
