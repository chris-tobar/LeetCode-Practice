package medium.November;

class problem1706{
    
    public static void main(String[] args) {
        
        int[][] example1 = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        int[][] example2 = {{-1}};
        int[][] example3 = {{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}};

        System.out.printf("Example 1: %s\n", findBall(example1).toString() );
        System.out.println("Solution: [1,-1,-1,-1,-1]\n");

        System.out.printf("Example 2: %s\n", findBall(example2).toString() );
        System.out.println("Solution: [-1] \n");

        System.out.printf("Example 3: %s\n", findBall(example3).toString());
        System.out.println("Solution: [0,1,2,3,4,-1]\n");
        
    }

    public static int[] findBall(int[][] grid) {
        
        //Each ball is dropped from the every column, hence size = grid[0].length
        int[] sol = new int[grid[0].length];
        
        //Variables that will keep track of what row and column the current ball is traversing through
        //Ball we are working with will be identified with index variable
        int index = 0;
        int row = 0;
        int col = 0;
        
        while(index < grid[0].length)
        {
            
            //Logic to check if it would be stuck against the wall
            if(col < 0 || col >= grid[0].length)
            {
                sol[index++] = -1;
                row = 0;
                col = index;
            }
            //Logic to check if the ball was stuck in a V
            else if(col>=grid[0].length-2 && 
                    (grid[row][col]==1 && grid[row][col+1] ==-1) )
            {
                sol[index++] = -1;
                row = 0;
                col = index;
            }
            //Logic that checks that ball has reached the bottom of the box
            else if(col >= grid.length)
            {
                sol[index++] = col;
                row = 0;
                col = index;
            }
            //Iteration to move column, since none of the other checks occured
            else
            {
                col += grid[row][col];
                row++;
            }
        }
        
        //Return where the balls exited
        return sol;
    }
}
