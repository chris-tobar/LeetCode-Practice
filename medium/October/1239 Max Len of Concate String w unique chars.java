package medium.October;

import java.util.List;
import java.util.ArrayList;

class problem1239{
    
    public static void main(String[] args) {
        
    }

    public static int maxLength(List<String> arr) {

        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        
        for (String word: arr) {
            
            int a = 0;
            int dup = 0;
            
            for (char wordChars : word.toCharArray()) 
            {
                dup |= a & (1 << (wordChars - 'a'));
                a |= 1 << (wordChars - 'a');
            }
            
            if (dup > 0) 
                continue;
            
            for (int i = dp.size() - 1; i >= 0; --i) 
            {
                if ((dp.get(i) & a) > 0) 
                    continue;
                dp.add(dp.get(i) | a);
                
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
            }
        }
        return res;
    }

}
