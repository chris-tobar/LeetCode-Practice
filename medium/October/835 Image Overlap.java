package medium.October;

class problem835{
    
    public static void main(String[] args) {

        //Solution: 3
        int[][] example1A = {{1,1,0},{0,1,0},{0,1,0}};
        int[][] example1B = {{0,0,0},{0,1,1},{0,0,1}};

        //Solution: 1
        int[][] example2A = {{1}};
        int[][] example2B = {{1}};

        //Solution: 0
        int[][] example3A = {{0}};
        int[][] example3B = {{0}};


        System.out.printf("\nExample 1: %d\n",largestOverlap(example1A, example1B));
        System.out.println("Solution: 3\n");

        System.out.printf("Example 2: %d\n",largestOverlap(example2A, example2B));
        System.out.println("Solution: 1\n");

        System.out.printf("Example 3: %d\n",largestOverlap(example3A, example3B));
        System.out.println("Solution: 0\n");

        
    }

    public static int largestOverlap(int[][] img1, int[][] img2) {
        
        //Counts the max overlap using the helper function
        int overlap = 0;
        
        //We want to try all offset combinations of img1 to img2, so we take the negative len + 1
        //we +1 to avoid going out of bounds
        for(int i= -img1.length + 1; i<img1.length; i++)
        {
            for(int j= -img1[0].length+1; j<img1[0].length; j++)
            {
                //Get the count of overlapping matrices from helper function
                overlap = Math.max(overlap, countOverlap(img1,img2,i,j));
            }
        }
        
        //Return max count found
        return overlap;
        
    }
    
    private static int countOverlap(int[][] img1, int[][] img2, int rowOffset, int colOffset)
    {
        //Initalize count to 0
        int count = 0;
        
        //Iterate through the image array
        for(int row = 0; row<img1.length; row++)
        {
            for(int col=0; col< img1[0].length; col++)
            {
                //Row or Column would be out of bounds with the offset, so we skip over that iteration
                if(row+rowOffset<0 || row+rowOffset >= img1.length || col+colOffset<0 || col+colOffset >= img1[0].length)
                    continue;
                
                //No longer out of bounds, we then check to see if there are any overlap of 1s
                if(img1[row][col] + img2[row+rowOffset][col+colOffset] == 2)
                    count++;
            }
        }
        
        //Return all overlap of 1's
        return count;
    }
}
