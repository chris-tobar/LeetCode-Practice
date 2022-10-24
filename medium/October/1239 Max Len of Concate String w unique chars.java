package medium.October;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * You are given an array of strings arr.
 *  A string s is formed by the concatenation of a subsequence of arr that has unique characters.

    Return the maximum possible length of s.

    A subsequence is an array that can be derived from 
    another array by deleting some or no elements without changing
    the order of the remaining elements.
 */
class problem1239{
    
    public static void main(String[] args) {
        
        ArrayList<String> example1 = new ArrayList<>( Arrays.asList("un","iq","ue"));
        ArrayList<String> example2 = new ArrayList<>( Arrays.asList("cha","r","act","ers"));
        ArrayList<String> example3 = new ArrayList<>( Arrays.asList("abcdefghijklmnopqrstuvwxyz"));

        System.out.println( maxLength(example1) );
        System.out.println( maxLength(example2) );
        System.out.println( maxLength(example3) );
    }

    public static int maxLength(List<String> arr) {

        //ArrayList that will store the length of the strings iterating over
        List<Integer> dp = new ArrayList<>();

        //First string we start with is "", so size is 0
        dp.add(0);

        //Number that will store the max len of string found
        int res = 0;
        
        //Iterate through every word in the list
        for (String word: arr) {
            

            int a = 0;

            //Keeps track of any duplicate letters found within word
            int dup = 0;
            
            //Iterate through the characters for the word found
            for (char wordChars : word.toCharArray()) 
            {
                dup |= a & (1 << (wordChars - 'a'));
                a |= 1 << (wordChars - 'a');
            }
            
            //String found has duplicate letters, so we will skip over it
            if (dup > 0) 
                continue;
            
            //Passed the check above, iterate through to see if our combo has any duplicate chars found
            for (int i = dp.size() - 1; i >= 0; --i) 
            {
                //Duplicate chars have been found, skip over it 
                if ((dp.get(i) & a) > 0) 
                    continue;
                dp.add(dp.get(i) | a);
                
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
            }
        }

        //return the max length
        return res;
    }

}
