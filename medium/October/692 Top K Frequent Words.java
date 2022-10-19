package medium.October;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

class problem692{
    
    public static void main(String[] args) {
        
    }

    public static List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String,Integer> freq = new HashMap<>();
        List<String> sol = new ArrayList<>();
        
        for(String word: words)
            freq.put(word, freq.getOrDefault(word,0) + 1);
        
        
        
        //For loop to iterate through k strings to get our solution
        for(int i=0; i<k; i++)
        {
            
        }
        
        
        
        return sol;
    }
}
