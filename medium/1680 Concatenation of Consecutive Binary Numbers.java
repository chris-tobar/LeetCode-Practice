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
        
        long sum = 0;
        
        for(int i=1; i<=n; i++)
        {
            String binary = Integer.toBinaryString(i);
            sum = ( (sum << binary.length()) + i) % 1000000007;
        }
        
        return (int) sum;
        
    }
}
