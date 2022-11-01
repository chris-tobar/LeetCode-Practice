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
        
        //Variable to keep track of row Length and col Lengh
        int rowLen = grid.length;
        int colLen = grid[0].length;
        //Keep track of where the balls land
        int[] res = new int[colLen];
        
        //Iterate through all the COLUMN length
        for (int i = 0; i < colLen; i++) 
        {
            //leftSpace is where the ball currently is
            int leftSpace = i;
            //rightSpace is where the ball wants to head to
            int rightSpace = 0;
            
            //Iterate throughout the ROWS
            for (int j = 0; j < rowLen; j++) 
            {
                //Calculate what column the ball will land in 
                rightSpace = leftSpace + grid[j][leftSpace];
                
                //Ball is stuck against the wall on both sides OR it has been stuck on a V bend
                if (rightSpace < 0 || rightSpace >= colLen || 
                    grid[j][rightSpace] != grid[j][leftSpace]) 
                {
                    //leftSpace is -1 since it never exits the box, and exit out of the loop
                    leftSpace = -1;
                    break;
                }
                leftSpace = rightSpace;
            }
            
            //Assign that index where the ball ended up
            res[i] = leftSpace;
        }
        //Return the solution
        return res;
    }
}
