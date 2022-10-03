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

    //WIth the example of "abaac" and [1,2,3,4,5]
    //If the characters are not duplicated, when they are added to see if the previous letter is the same or not
    //The number added to sol will be 0, and if all characters are unique throughout, then the total sol sum will
    //end up being zero
    public static int minCost(String colors, int[] neededTime) {
        
        //Will store the solution
        int sol = 0;

        //Will keep track of the running sum of duplicated substrings next to each other
        int sum = 0;

        //Keeps track of the biggest number within the duplicated substrings
        int max = 0;
        
        //Iterate through the string characters
        for(int i=0; i<colors.length(); i++)
        {
            //First check to see if index !=0 so we don't get out of bounds error
            //Checks to see if the current character is not the same with the character behind it
            if(i>0 && colors.charAt(i) != colors.charAt(i-1))
            {
                //Since they are different, minus the max found with the total running sum
                sol += sum - max;

                //Reset their values to 0 since there are no duplicates
                sum = 0;
                max = 0;
            }

            //Add current letter time to running sum
            sum += neededTime[i];

            //See if current letter time is biggest found thus far
            max = Math.max(max, neededTime[i]);
        }
        
        //Last character is reached, so check if any time is added, or else they will be 0
        sol += sum - max;
        
        //Return the solution
        return sol;
    }
}
