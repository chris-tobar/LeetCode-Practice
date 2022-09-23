package medium;
import java.math.BigInteger;

/*
 * Given an integer n, return the decimal value of 
 * the binary string formed by concatenating the binary 
 * representations of 1 to n in order, modulo 109 + 7.
 */
class problem1680{
    
    public static void main(String[] args) {
        
        //Solution: 1
        int example1 = 1;

        //Solution: 27
        int example2 = 3;

        //Solution: 505379714
        int example3 = 12;

        System.out.println( concatenatedBinary(example1));
        System.out.println( concatenatedBinary(example2));
        System.out.println( concatenatedBinary(example3));

    }

    public static int concatenatedBinary(int n) {
        
        //Sum that will store the solution
        long sum = 0;
        
        //Iterate through the numbers starting from 1 to n
        for(int i=1; i<=n; i++)
        {
            //Convert number to binary string
            String binary = Integer.toBinaryString(i);

            //Move over bits by size of string, add number to sum, and then take mod of whole number to avoid int overflow
            sum = ( (sum << binary.length()) + i) % 1000000007;
        }
        
        //Conver long into an int
        return (int) sum;
        
    }
}
