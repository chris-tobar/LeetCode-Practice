package medium.November;

import java.util.HashSet;
class problem433{
    
    public static void main(String[] args) {
        
    }

    public static int minMutation(String start, String end, String[] bank) {
        
        int charCount = 0;
        boolean endInBank = false;
        HashSet<Integer> indexToSkip = new HashSet<>();
        
        if(bank.length == 0)
            return start.equals(end) ? 0 : -1;
        else if(start.equals(end))
            return 0;
        
        charCount = charsToChange(start,end);

        for(String gene: bank)
        {
            if(gene.equals(end))
                endInBank = true;
        }
        
        if(charCount > bank.length || !endInBank)
            return - 1;
        
        //CHECKS BANK NOW TO SEE IF MODIFICATION IS AVAILABLE
        for(int i=0; i< charCount; i++)
        {
            for(int j=0; j<bank.length; j++)
            {
                if(start.equals(end))
                    break;
                
                //SKip over index since we mutated through it
                if(indexToSkip.contains(j))
                    continue;
                
                if(charsToChange(start, bank[j]) == 1)
                {
                    start = bank[j];
                    indexToSkip.add(j);
                }
                
            }
        }
    
        return start.equals(end) ? charCount : -1;
    }
    
    public static int charsToChange(String start, String end)
    {
        
        int count = 0;
        
        for(int i=0; i<8; i++)
        {
            if(start.charAt(i) != end.charAt(i))
                count++;
        }
        
        return count;
    }
}
