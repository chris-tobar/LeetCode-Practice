package easy.October;

class problem766{
    
    public static void main(String[] args) {
        
        System.out.println("Hello world!");
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        
        //Iterate through the array len -1 so we don't check corners and go out of bounds
        for (int i = 0; i < matrix.length - 1; i++) 
        {
            //Same logic as above, len - 1 so we don't check corners and go out of bounds
            for (int j = 0; j < matrix[i].length - 1; j++) 
            {
                //Number in the diagnals don't match up, return false
                if (matrix[i][j] != matrix[i + 1][j + 1]) 
                    return false;
            }
        }
        
        //All diagnals have the same number, return true
        return true;
    }
}