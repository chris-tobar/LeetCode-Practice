package medium.November;

class problem1706{
    
    public static void main(String[] args) {
        
    }

    public static int[] findBall(int[][] grid) {
        
        int[] sol = new int[grid[0].length];
        
        int index = 0;
        int row = 0;
        int col = 0;
        
        while(index < grid[0].length)
        {
            
            if(col < 0 || col >= grid[0].length)
            {
                sol[index++] = -1;
                row = 0;
                col = index;
            }
            else if(col>=grid[0].length-2 && 
                    (grid[row][col]==1 && grid[row][col+1] ==-1) )
            {
                sol[index++] = -1;
                row = 0;
                col = index;
            }
            else if(col >= grid.length)
            {
                sol[index++] = col;
                row = 0;
                col = index;
            }
            else
            {
                col += grid[row][col];
                row++;
            }
        }
        
        return sol;
    }
}
