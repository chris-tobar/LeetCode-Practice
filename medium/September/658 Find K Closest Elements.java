package medium.September;

import java.util.ArrayList;
import java.util.List;


/*
 * Given a sorted integer array arr, two integers k and x, 
 * return the k closest integers to x in the array. The result should also be sorted in ascending order.

    An integer a is closer to x than an integer b if:

    |a - x| < |b - x|, or
    |a - x| == |b - x| and a < b

 */
class problem658{
    
    public static void main(String[] args) {
        
        int[] example1 = {1,2,3,4,5};
        int[] example2 = {1,1,1,10,10,10};

        //Solution: {1,2,3,4}
        printList( findClosestElements(example1, 4, 3));

        //Solution: {1,2,3,4}
        printList( findClosestElements(example1, 4, -1));

        //Solution: {2,3,4,5}
        printList( findClosestElements(example1, 4, 6));

        //Solution: {10}
        printList( findClosestElements(example2, 1, 9));


    }

    public static void printList(List<Integer> arr)
    {
        for(int i: arr)
            System.out.print(i + " ");

        System.out.println();
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        //ArrayList to store the solution
        ArrayList<Integer> sol = new ArrayList<>();
        
        //Two edges cases
        // 1. If the first number is greater than x, get 0 to k
        if(arr[0] >= x)
        {
            for(int i=0; i<k; i++)
                sol.add(arr[i]);
        }
        // 2. If the last number is less than x, then get length-k to length-1
        else if(arr[ arr.length - 1 ] <= x)
        {
            for(int i=arr.length - k; i<arr.length; i++)
                sol.add(arr[i]);
        }
        else
        {
            //Use BS to find the pivot point we are going to be manuvering around
            int pivot = BS(arr, x);
            int left = pivot-1;
            int right = pivot+1;
            
            //Keep searching until we have the size of array searching for
            while(right-left < k)
            {
                //Calculate the differences now to make reading it easier
                int leftDiff = Math.abs(arr[left]-x);
                int rightDiff = Math.abs(arr[right]-x);
                
                //Left number is closer and smaller than right
                if(left >=0 && (leftDiff < rightDiff) || (leftDiff==rightDiff && 
                                                          arr[left]<arr[right]))
                {
                    left--;
                }
                //Right number is smaller and hasn't reached the end
                else if( right < arr.length)
                {
                    right++;
                }
                //Right number has reached the end, so we can only move the pointer left
                else
                {
                    left--;
                } 
            }
            
            //Iterate from left pointer to the right to keep the numbers in order
            for(int i = left; i<right; i++)
                sol.add(arr[i]);
        }
        
        //Return the solution
        return sol;
    }
    
    private static int BS(int[] arr, int x)
    {
        int low = 0;
        int high = arr.length-1;
        
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            
            if(arr[mid]==x)
                return mid;
            else if(arr[mid] < x )
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return low;
    }
}
