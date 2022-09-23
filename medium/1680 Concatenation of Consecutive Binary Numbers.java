package medium;
import java.math.BigInteger;

class problem1680{
    
    public static void main(String[] args) {
        
    }

    public int concatenatedBinary(int n) {
        
        StringBuilder binary = new StringBuilder();
        
        for(int i=1; i<=n; i++)
        {
            binary.append( Integer.toBinaryString(i) );
        }
        
        BigInteger temp = new BigInteger(binary.toString(), 2);
        BigInteger mod = new BigInteger("1000000007");
        temp = temp.mod( mod );
        
        
        return temp.intValue();
        
        
    }
}
