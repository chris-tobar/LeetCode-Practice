package easy.November;

/*
 * Given a string s of lower and upper case English letters.

    A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

    0 <= i <= s.length - 2
    s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.

    To make the string good, you can choose two adjacent characters that make the 
    string bad and remove them. You can keep doing this until the string becomes good.

    Return the string after making it good. The answer is guaranteed to be 
    unique under the given constraints.

    Notice that an empty string is also good.
 */
class problem1544{

    public static void main(String[] args)
    {
        //SOLUTION: "leetcode"
        String example1 = "leEeetcode";

        //SOLUTION: ""
        String example2 = "abBAcC";

        //SOLUTION: "s"
        String example3 = "s";

        System.out.printf("Example 1: \"%s\" %n", makeGood(example1));
        System.out.println("Solution: \"leetcode\" \n");

        System.out.printf("Example 2: \"%s\" %n", makeGood(example2));
        System.out.println("Solution: \"\" \n");

        System.out.printf("Example 3: \"%s\" %n", makeGood(example3));
        System.out.println("Solution: \"s\"\n");
    }

    public static String makeGood(String s) {
        
        //Base case
        if(s.length() == 1)
            return s;
        
        //StringBuilder to store the string, since we are going to be appending characters
        StringBuilder sb = new StringBuilder();
        
        //Iterate through the string
        for(int i=0; i<s.length()-1; i++)
        {
            //Store the letters and lower case them to compare and see if they are the same
            Character letter = Character.toLowerCase( s.charAt(i) ) ;
            Character letterAhead = Character.toLowerCase( s.charAt(i+1) );
            
            //Letters are the same, we will now check to see if we should append them or delete them
            if( letter.equals(letterAhead) )
            {
                Character temp = s.charAt(i);
                Character temp2 = s.charAt(i+1);
                
                //One letter is upper and the other is lower, so we will delete both characters
                if( !temp.equals(temp2) )
                    i++;
                //They were both upper case or lower case, so we will append that character
                else
                    sb.append( s.charAt(i));
            }
            //Letters were not the same, so we will append current letter
            else
                sb.append( s.charAt(i));
            
        }
        
        //Catches some base cases that ending letter is not included
        //Solution needs to be reworked because of this bottom logic
        sb.append(s.charAt( s.length() -1 ) );
        
        //Return the good string
        return sb.toString();
    }
}