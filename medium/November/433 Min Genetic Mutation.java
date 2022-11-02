package medium.November;

import java.util.HashSet;

/*
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string start to a gene string end 
where one mutation is defined as one single character changed in the gene string.

    For example, "AACCGGTT" --> "AACCGGTA" is one mutation.

There is also a gene bank bank that records all the valid gene mutations.
 A gene must be in bank to make it a valid gene string.

Given the two gene strings start and end and the gene bank bank, 
return the minimum number of mutations needed to mutate from start to end. 
If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.
 */
class problem433{
    
    public static void main(String[] args) {
        
        //SOLUTION: 1
        String[] example1 = {"AACCGGTA"};

        //SOLUTION: 2
        String[] example2 = {"AACCGGTA","AACCGCTA","AAACGGTA"};

        //SOLUTION: 3
        String[] example3 = {"AAAACCCC","AAACCCCC","AACCCCCC"};


        System.out.printf("\nExample 1: %d\n", minMutation("AACCGGTT", "AACCGGTA", example1));
        System.out.println("Solution: 1\n");

        System.out.printf("Example 2: %d\n", minMutation("AACCGGTT", "AAACGGTA", example2));
        System.out.println("Solution: 2\n");

        System.out.printf("Example 3: %d\n", minMutation("AAAAACCC", "AACCCCCC", example3));
        System.out.println("Solution: 3");
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
                if(charsToChange(start,end) == 1)
                    return charCount;
                
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
