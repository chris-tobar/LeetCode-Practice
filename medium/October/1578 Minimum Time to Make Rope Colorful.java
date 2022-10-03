package medium.October;

import java.util.PriorityQueue;

class problem1578{
    
    public static void main(String[] args) {
        
    }

    public int minCost(String colors, int[] neededTime) {
        
        //Values of colors next to each other would be added to this priorityQueue
        PriorityQueue<Integer> values = new PriorityQueue<>();
        //Keeps track of the total cost of removing ballons
        int cost = 0;

        //Keeps track of substring length
        int sub = 0;
        
        //Iterate through the string length-1
        for(int i=0; i<colors.length()-1; i++)
        {
            //Letter found next to each other are duplicates
            if(Character.compare( colors.charAt(i), colors.charAt(i+1))==0  )
            {
                //Get the substring of duplicated colors
                sub = subStringLength(colors,i);
                
                //Iterate through adding them to the priorityQueue
                for(int j=i; j<sub; j++)
                    values.add( neededTime[j] );
                
                //Pop the values found
                while(values.size() > 2)
                    cost += values.poll();
                
                //Clear the priorityQueue so it doesn't bleed into next substring found
                values.clear();
                //Make the iteration begin at end of substring found
                i=sub;
            }
        }
        
        //Return found cost
        return cost;
    }
    
    /*
     * Helper function to help find the substring length
     */
    public int subStringLength(String colors,int beginning)
    {
        int end = beginning;
        
        for(int i=beginning; colors.charAt(i)==colors.charAt(beginning) && i<colors.length()-1; i++)
            end++;
        
        return end;
    }
}
