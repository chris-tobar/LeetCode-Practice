package easy.October;

class problem766{
    
    public static void main(String[] args) {
        
        System.out.println("Hello world!");
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        
        //Below mid line
        for(int row=1; row< rowLength; row++)
        {
            int curr = matrix[row][0];
            
            for(int col=0; col< colLength; col++)
            {
                if(row+col >= rowLength)
                    break;
                
                if(matrix[row+col][col] != curr)
                    return false;
            }
        }
        
        //MidLine
        for(int row=0; row< rowLength; row++)
        {
            if(matrix[row][row] != matrix[0][0])
                return false;
        }
        
        //upper mid Line
        for(int row=0; row < rowLength-1; row++)
        {
            //TODO FIX BUG
            int curr = matrix[0][row+1];
            
            for(int col=1; col < colLength; col++)
            {
                if(row+col-1 >= rowLength)
                    break;
                
                if(matrix[col-1][col] != curr)
                    return false;
            }
        }
        
        
    
        return true;
    }
}