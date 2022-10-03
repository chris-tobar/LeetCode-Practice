package medium.October;

import java.util.PriorityQueue;

/*
 * Alice has n balloons arranged on a rope. You are given a 0-indexed string 
 * colors where colors[i] is the color of the ith balloon.

        Alice wants the rope to be colorful. She does not want two
        consecutive balloons to be of the same color, so she asks 
        Bob for help. Bob can remove some balloons from the rope to 
        make it colorful. You are given a 0-indexed integer array neededTime where 
        neededTime[i] is the time (in seconds) that Bob needs to 
        remove the ith balloon from the rope.

*  Return the minimum time Bob needs to make the rope colorful.
 */
class problem1578{
    
    public static void main(String[] args) {
        
        //Solution: 3
        String example1 = "abaac";
        int[] time1 = {1,2,3,4,5};

        //Solution: 0
        String example2 = "abc";
        int[] time2 = {1,2,3};

        //Solution: 2
        String example3 = "aabaa";
        int[] time3 = {1,2,3,4,1};

        System.out.println( minCost(example1, time1) );
        System.out.println( minCost(example2, time2) );
        System.out.println( minCost(example3, time3) );
    }

    public static int minCost(String colors, int[] neededTime) {
        
        int sol = 0;
        int sum = 0;
        int max = 0;
        
        for(int i=0; i<colors.length(); i++)
        {
            if(i>0 && colors.charAt(i) != colors.charAt(i-1))
            {
                sol += sum - max;
                sum = 0;
                max = 0;
            }
            
            sum += neededTime[i];
            max = Math.max(max, neededTime[i]);
        }
        
        sol += sum - max;
        
        return sol;
    }
}
