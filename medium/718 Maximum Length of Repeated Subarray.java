package medium;

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

        int max = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length+1];
        
        
        for(int i=0; i<nums1.length; i++)
        {
            for(int j=0; j<nums2.length; j++)
            {
                if(nums1[i] == nums2[j])
                {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    max = Math.max(max, dp[i+1][j+1]);
                }
            }
        }
        
        return max;
    }
    
}
