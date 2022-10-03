package medium.October;

import java.util.PriorityQueue;

class problem1578{
    
    public static void main(String[] args) {
        
    }

    public int minCost(String colors, int[] neededTime) {
        
        PriorityQueue<Integer> values = new PriorityQueue<>();
        int cost = 0;
        int sub = 0;
        
        for(int i=0; i<colors.length()-1; i++)
        {
            if(Character.compare( colors.charAt(i), colors.charAt(i+1))==0  )
            {
                sub = subStringLength(colors,i);
                
                for(int j=i; j<sub; j++)
                    values.add( neededTime[j] );
                
                while(values.size() > 2)
                    cost += values.poll();
                
                values.clear();
                i=sub;
            }
            
            
        }
        
        return cost;
    }
    
    public int subStringLength(String colors,int beginning)
    {
        int end = beginning;
        
        for(int i=beginning; colors.charAt(i)==colors.charAt(beginning) && i<colors.length()-1; i++)
            end++;
        
        return end;
    }
}
