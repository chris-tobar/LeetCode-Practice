package medium;

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
        
        ArrayList<Integer> sol = new ArrayList<>();
        
        if(arr[0] >= x)
        {
            for(int i=0; i<k; i++)
                sol.add(arr[i]);
        }
        else if(arr[ arr.length - 1 ] <= x)
        {
            for(int i=arr.length - k; i<arr.length; i++)
                sol.add(arr[i]);
        }
        else
        {
            int pivot = BS(arr, x);
            int left = pivot-1;
            int right = pivot+1;
            
            while(right-left < k)
            {
                int leftDiff = Math.abs(arr[left]-x);
                int rightDiff = Math.abs(arr[right]-x);
                
                if(left >=0 && (leftDiff < rightDiff) || (leftDiff==rightDiff && 
                                                          arr[left]<arr[right]))
                {
                    left--;
                }
                else if( right < arr.length)
                {
                    right++;
                }
                else
                {
                    left--;
                } 
            }
            
            for(int i = left; i<right; i++)
                sol.add(arr[i]);
        }
        
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
