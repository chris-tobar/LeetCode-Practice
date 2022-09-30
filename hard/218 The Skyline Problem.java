package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
class problem218{

    public static void main(String[] args) {
        
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        List<List<Integer>> sol = new ArrayList<>();
        
        //Keeps track of duplicate points within a building
        HashMap<Integer,Integer> points = new HashMap<>();
        
        
        //Iterate through the buildings within the list
        for(int i=0; i<buildings.length; i++)
        {
            //Left point does not exist, so we will add it to hashmap
            //Then do some more logic
            if(!points.containsKey(buildings[i][0]))
            {
                points.put(buildings[i][0],buildings[i][2]);
                
            }
            //Point is duplicated so we will take the bigger height and add it to the hashmap
            else
            {
                int hashHeight = points.get(buildings[i][0]);
                int max = Math.max(hashHeight, buildings[i][2]);

                points.put(buildings[i][0], max);
            }
            
            //Right point does not exist, so we will add it to the hasmap
            //Then do some more logic 
            if(!points.containsKey(buildings[i][1]))
            {
                System.out.println("temp");
            }
            else
            {
                System.out.println("temp");
            }
        }
        
        return sol;
    }
}