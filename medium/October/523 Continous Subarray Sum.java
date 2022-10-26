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
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        
        int runningSum = 0;
        
        for(int i=0; i<nums.length; i++)
        {
            runningSum += nums[i];
            
            if(k!=0)
                runningSum %= k;
            
            Integer prev = map.get(runningSum);
            
            if(prev != null)
            {
                if(i - prev > 1)
                    return true;
            }
            else
                map.put(runningSum, i);
        }
        
        return false;
    }
}
