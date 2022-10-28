package medium.October;

class problem835{
    
    public static void main(String[] args) {
        
    }

    public static int largestOverlap(int[][] img1, int[][] img2) {
        
        int overlap = 0;
        
        for(int i= -img1.length + 1; i<img1.length; i++)
        {
            for(int j= -img1[0].length+1; j<img1[0].length; j++)
            {
                overlap = Math.max(overlap, countOverlap(img1,img2,i,j));
            }
        }
        
        return overlap;
        
    }
    
    private static int countOverlap(int[][] img1, int[][] img2, int rowOffset, int colOffset)
    {
        int count = 0;
        
        for(int row = 0; row<img1.length; row++)
        {
            for(int col=0; col< img1[0].length; col++)
            {
                if(row+rowOffset<0 || row+rowOffset >= img1.length || col+colOffset<0 || col+colOffset >= img1[0].length)
                    continue;
                
                if(img1[row][col] + img2[row+rowOffset][col+colOffset] == 2)
                    count++;
            }
        }
        
        return count;
    }
}
