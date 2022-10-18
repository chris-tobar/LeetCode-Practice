package medium.October;

/*
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

    countAndSay(1) = "1"
    countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), 
    which is then converted into a different digit string.

    To determine how you "say" a digit string, split it into the minimal number of substrings
     such that each substring contains exactly one unique digit. Then for each substring, 
     say the number of digits, then say the digit. Finally, concatenate every said digit.

    For example, the saying and conversion for digit string "3322251":

        two 3's, three 2's, one 5, and one 1
        2 3 +       3 2 +   1 5 +   1 1
                    "23321511"

    Given a positive integer n, return the nth term of the count-and-say sequence.
 */
class problem38{
    
    public static void main(String[] args) {
        
        //Solution: 1
        int example1 = 1;

        //Solution: 1211
        int example2 = 4;

        //Solution: 3113112221232112111312211312113211
        int example3 = 12;

        System.out.println( countAndSay(example1));
        System.out.println( countAndSay(example2));
        System.out.println( countAndSay(example3));
    }

    public static String countAndSay(int n) {
        
        //Start with the base case, until you work your way to n-1
        String baseCase = "1";
        for(int i=1; i<n; i++)
            //Keeps updating on its subproblems
            baseCase = countNumbers(baseCase);
        
        return baseCase;
    }
    
    public static String countNumbers(String s){
        
        //String builder that we will be appending to
        StringBuilder sb = new StringBuilder();
        
        //Get the first number we will be starting with
        char num = s.charAt(0);
        
        //Initalize the count to 1 since we are starting with our first digit
        int count = 1;
        
        //Since first digit is already accounted for, start with the second character and iterate to the end
        for(int i=1; i<s.length(); i++)
        {
            //number found is the same, so we increment the count
            if(s.charAt(i) == num)
                count++;
            //Number found is not the same, append count along with number, and reset counter
            else
            {
                sb.append(count);
                sb.append(num);
                num = s.charAt(i);
                count = 1;
            }
        }
        
        //Iteration has ended, append count left over, along with number accounting for
        sb.append(count);
        sb.append(num);

        //Return string version of it
        return sb.toString();
    }
}
