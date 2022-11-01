package medium.November;

/*
 * You have a 2-D grid of size m x n representing a box, and you have n balls. 
 * The box is open on the top and bottom sides.

    Each cell in the box has a diagonal board spanning two corners of the cell that can 
    redirect a ball to the right or to the left.

        A board that redirects the ball to the right spans the top-left corner to the 
        bottom-right corner and is represented in the grid as 1.

        A board that redirects the ball to the left spans the top-right corner 
        to the bottom-left corner and is represented in the grid as -1.

    We drop one ball at the top of each column of the box. Each ball can get stuck 
    in the box or fall out of the bottom. A ball gets stuck if it hits a 
    "V" shaped pattern between two boards or if a board redirects the ball 
    into either wall of the box.

Return an array answer of size n where answer[i] is the column that the
 ball falls out of at the bottom after dropping the ball from the ith column 
 at the top, or -1 if the ball gets stuck in the box.
 */
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
