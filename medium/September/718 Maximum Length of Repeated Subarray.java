package medium.September;

/*
 * Given two integer arrays nums1 and nums2, 
 * return the maximum length of a subarray that 
 * appears in both arrays.
 */
class problem718{

    public static void main(String[] args) {
        
        //Solution: 3
        //The repeated subarray w/ max len is [3,2,1]
        int[] exampleA1 = {1,2,3,2,1};
        int[] exampleA2 = {3,2,1,4,7};

        //Solution: 5
        int[] exampleB1 = {0,0,0,0,0};
        int[] exampleB2 = {0,0,0,0,0};

        System.out.println( findLength(exampleA1, exampleA2));
        System.out.println( findLength(exampleB1, exampleB2));

    }

    public static int findLength(int[] nums1, int[] nums2) {

        //This will keep track of the max number length of subarray found
        int max = 0;

        //Row will keep track of nums1, while Col will keep track of nums2
        int[][] dp = new int[nums1.length + 1][nums2.length+1];
        
        //Iterate through both of the arrays
        for(int i=0; i<nums1.length; i++)
        {
            for(int j=0; j<nums2.length; j++)
            {
                //If the number found in nums1 == nums2, then we increment the total subarray found in dp by 1
                //Then keep track of the max found
                if(nums1[i] == nums2[j])
                {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    max = Math.max(max, dp[i+1][j+1]);
                }
            }
        }
        
        //Returns the max subarray size found
        return max;
    }
    
}
