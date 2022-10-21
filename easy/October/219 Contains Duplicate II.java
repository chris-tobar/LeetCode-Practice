package easy.October;

import java.util.HashSet;

class problem219{
    
    public static void main(String[] args) {
        
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        
        if(k == 0)
            return false;
        
        HashSet<Integer> dups = new HashSet<>();
        int left = 0;
        int right = 1;
        
        dups.add( nums[left]);
        
        while(right < nums.length)
        {
            
            if( right-left > k)
            {
                dups.remove(nums[left]);
                left++;
            }
            
            if(dups.contains(nums[right]))
                return true;
                
            
            dups.add( nums[right] );
            right++;
            
        }
        
        return false;
    }
}
