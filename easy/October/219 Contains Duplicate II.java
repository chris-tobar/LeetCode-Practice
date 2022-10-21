package easy.October;

import java.util.HashSet;

/*
 * Given an integer array nums and an integer k,
 *  return true if there are two distinct indices i and j 
 * in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
class problem219{
    
    public static void main(String[] args) {
        
        //Solution: True
        int[] example1 = {1,2,3,1};

        //Solution: True
        int[] example2 = {1,0,1,1};

        //Solution: False
        int[] example3 = {1,2,3,1,2,3};

        System.out.println( containsNearbyDuplicate(example1, 3));
        System.out.println( containsNearbyDuplicate(example2, 1));
        System.out.println( containsNearbyDuplicate(example3, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        
        //Minimum size needed to solve this problem is 1, thus it will always be false
        if(k == 0)
            return false;
        
        //HashSet to keep track of duplicate numbers found
        HashSet<Integer> dups = new HashSet<>();

        //Left pointer that will decrease when it reaches size of window
        int left = 0;
        //Right pointer that will increase size of the window
        int right = 1;
        
        //Add the left pointer
        dups.add( nums[left]);
        
        //Iterate through the array until we reach the end, or we found a solution
        while(right < nums.length)
        {
            //Window size is too big, so we will decrease it
            //Also get rid of number that it was pointing to
            if( right-left > k)
            {
                dups.remove(nums[left]);
                left++;
            }
            
            //Window size fits, and a duplicate number has been found
            if(!dups.add( nums[right++]))
                return true;
                
        }
        
        //Duplicate number was never found in the size of window requested
        return false;
    }
}
