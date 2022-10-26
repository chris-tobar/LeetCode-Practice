package medium.October;

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
        
        //Iterate through the array and find all possible combinations to see if they add up
        for(int i=0; i<nums.length - 1; i++)
        {
            int sum = nums[i];
            
            for(int j=i+1; j<nums.length; j++)
            {
                sum += nums[j];
                
                //Number equals a multiple of the sum
                if(sum%k == 0)
                    return true;
            }
        }
        
        //Iterated throughout the array and no solution was found
        return false;
    }
}
