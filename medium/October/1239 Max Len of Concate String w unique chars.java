package medium.October;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

class problem1239{
    
    public static void main(String[] args) {
        
    }

    public static int maxLength(List<String> arr) {
        
        int max = 0;
        
        for(int i=0; i<arr.size(); i++)
        {
            HashSet<Character> dups = new HashSet<>();
            StringBuilder word = new StringBuilder(arr.get(i));
            
            if(addToSet( word.toString() , dups) )
                max = Math.max(max, word.length() );
            
            for(int j=i+1; j<arr.size(); j++)
            {
                if(unique(arr.get(j), dups))
                {
                    addToSet(arr.get(j),dups);
                    word.append(arr.get(j));
                    max = Math.max(max, word.length());
                }
            }
            
        }
        
        return max;
    }
    
    public static boolean addToSet(String word, Set<Character> dups)
    {
        for(int i=0; i<word.length(); i++)
        {
            if(!dups.add( word.charAt(i)))
                return false;
        }
        
        return true;
    }
    
    public static boolean unique(String word, Set<Character> dups)
    {
        for(int i=0; i<word.length(); i++)
        {
            if(dups.contains(word.charAt(i)))
                return false;
        }
        
        return true;
    }
}
