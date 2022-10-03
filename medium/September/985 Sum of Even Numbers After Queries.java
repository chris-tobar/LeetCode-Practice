package medium;

/*
 * You are given an integer array nums and 
 * an array queries where queries[i] = [vali, indexi].

    For each query i, first, apply 
    nums[indexi] = nums[indexi] + vali, then print the sum of the even values of nums.

    Return an integer array answer where answer[i] is the answer to the ith query.
 */
class problem985{
    
    public static void main(String[] args) {
        
        //Solution: [8,6,2,4]
        int[] nums1 = {1,2,3,4};
        int[][] queries1 = {{1,0},
                            {-3,1},
                            {-4,0},
                            {2,3}};

        //Solution: [0]
        int[] nums2 = {1};
        int[][] queries2 = {{4,0}};

        print( sumEvenAfterQueries(nums1, queries1));
        print( sumEvenAfterQueries(nums2, queries2));

    }

    //Function to print out the solutions of the array
    public static void print(int[] solution)
    {
        for(int i: solution)
            System.out.print(i + " ");

        System.out.println();
    }

    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        //Array to store the solution numbers
        int[] solution = new int[nums.length];
        //Index to iterate through our solution array
        int solIndex = 0;
        //Int to keep track of the even numbers found
        int evens = 0;
        
        //Iterate through the array once to count all the even numbers found in beginning
        for(int i: nums)
        {
            if(i%2==0)
                evens += i;
        }
        
        //Iterate through all the queries
        for(int row=0; row<queries.length; row++)
        {
            //Values to keep track of index to change and by what value
            int index=queries[row][1];
            int value=queries[row][0];
            
            //Add it to the number
            nums[ index ] += value;
            
            //If the number is even, then we add it to the even counter, depending if it was
            // even before or odd
            if(nums[index]%2==0)
            {
                //Number was even before, so we only add the difference
                if((nums[index]-value)%2==0 )
                    evens += value;
                //Number was odd before, so we add the whole number
                else
                    evens += nums[index];
            }
            //Number went from even to odd, so we decrement by previous number
            else if((nums[index]-value)%2==0) 
                evens -= nums[index] - value;
                
            //Add even number to solution array
            solution[ solIndex++] = evens;
            
        }
        
        //return the solution array
        return solution;
    }
}
