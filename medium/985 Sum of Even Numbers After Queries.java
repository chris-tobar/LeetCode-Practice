package medium;

class problem985{
    
    public static void main(String[] args) {
        
    }

    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int[] solution = new int[nums.length];
        int solIndex = 0;
        int evens = 0;
        
        for(int i: nums)
        {
            if(i%2==0)
                evens += i;
        }
        
        for(int row=0; row<queries.length; row++)
        {
            int index=queries[row][1];
            int value=queries[row][0];
            
            nums[ index ] += value;
            
            if(nums[index]%2==0)
            {
                if((nums[index]-value)%2==0 )
                    evens += value;
                else
                    evens += nums[index];
            }
            else if((nums[index]-value)%2==0) 
                evens -= nums[index] - value;
                
            solution[ solIndex++] = evens;
            
        }
        
        
        return solution;
    }
}
