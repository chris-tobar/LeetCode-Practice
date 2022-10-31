package easy.October;

/*
 * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

    A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
 */
class problem766{
    
    public static void main(String[] args) {
        
        //Solution: true
        int[][] example1 = {{1,2,3,4},
                            {5,1,2,3},
                            {9,5,1,2}};

        //Solution: false
        int[][] example2 = {{1,2},
                            {2,2}};


        System.out.printf("%nExample 1: %b %n", isToeplitzMatrix(example1));
        System.out.println("Solution: true \n");

        System.out.printf("Example 2: %b %n", isToeplitzMatrix(example2));
        System.out.println("Solution: false \n");
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