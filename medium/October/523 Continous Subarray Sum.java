package medium.October;

import java.util.HashMap;
/*
 * Given an integer array nums and an integer k, return true if nums has 
 * a continuous subarray of size at least two whose elements sum up to a 
 * multiple of k, or false otherwise.

    An integer x is a multiple of k if there exists an integer n 
    such that x = n * k. 0 is always a multiple of k.
 */
class problem523{
    
    public static void main(String[] args) {
        
        int[] example1 = {23,2,4,6,7};
        int[] example2 = {23,2,6,4,7};

        System.out.printf("\nExample 1: %b\n", checkSubarraySum(example1, 6));
        System.out.println("Solution: true\n");


        System.out.printf("Example 2: %b\n", checkSubarraySum(example2, 6));
        System.out.println("Solution: true\n");

        System.out.printf( "Example 3: %b\n",checkSubarraySum(example2, 13));
        System.out.println("Solution: false\n");
            
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        
        //Hashmap that will keep track of the running remainders
        HashMap<Integer,Integer> map = new HashMap<>();

        //Initalize condition in case the starting value is 0
        map.put(0,-1);
        
        int runningSum = 0;
        
        //Iterate through the array
        for(int i=0; i<nums.length; i++)
        {
            //Add number to the running sum
            runningSum += nums[i];
            
            //Find the remainder IF AND ONLY IF the number we are using is not 0
            if(k!=0)
                runningSum %= k;
            
            //See if there exists a number within the map that has the same remainder as our current running sum
            Integer prev = map.get(runningSum);
            
            //There exists a number within our map that has that remainder
            if(prev != null)
            {
                //There are two locations that have the same remainder, meaning we found a multiple of our number k
                if(i - prev > 1)
                    return true;
            }
            else
                //Remainder doesn't exist yet, OR the size of our window doesn't contain AT LEAST 2 numbers
                map.put(runningSum, i);
        }
        
        //No numbers have been found
        return false;
    }
}
