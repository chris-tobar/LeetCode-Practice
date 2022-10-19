package medium.October;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

/*
 * Given an array of strings words and an integer k, return the k most frequent strings.

    Return the answer sorted by the frequency from highest to lowest. 
    Sort the words with the same frequency by their lexicographical order.
 */
class problem692{
    
    public static void main(String[] args) {
        
        //Solution: {i, love}
        String[] example1 = {"i","love","leetcode","i","love","coding"};

        //Solution: {the, is, sunny, day}
        String[] example2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};

        System.out.println( topKFrequent(example1, 2));
        System.out.println( topKFrequent(example2, 4));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String,Integer> freq = new HashMap<>();
        List<String> sol = new ArrayList<>();
        
        //Hashmap that stores the frequency of the words found
        for(String word: words)
            freq.put(word, freq.getOrDefault(word,0) + 1);
        
        
        //Missing logic for sorting through hashmap values in order, to be able
        //to loop through k values and achieve solution needed
        
        //For loop to iterate through k strings to get our solution
        for(int i=0; i<k; i++)
        {
            
        }
        
        //Return the solution
        return sol;
    }
}
