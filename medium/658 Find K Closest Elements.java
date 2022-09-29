package medium;

import java.util.ArrayList;
import java.util.List;

class problem658{
    
    public static void main(String[] args) {
        
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
