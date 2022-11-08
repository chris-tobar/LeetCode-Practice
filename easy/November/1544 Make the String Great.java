package easy.November;

import java.util.Stack;

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
        
        //Stack that will hold all characters that pass the check
        Stack<Character> stack = new Stack<>();
        
        //Iterate through the string size
        for(int i=0; i<s.length(); i++)
        {
            //If the character is upper/lower or lower/upper, the difference between them in ASCII
            //Will be 32, hence this check
            if(!stack.isEmpty() && Math.abs( stack.peek()-s.charAt(i)) == 32)
                stack.pop();
            //Characters are not the same, so we push it to the stack
            else
                stack.push(s.charAt(i));
        }
        
        //Character array that will now take the characters inside the stack
        char[] solution = new char[stack.size()];
        
        //Initalize index at stack size-1, since characters are stored in reverse
        int index = stack.size() - 1;
        
        //Loop through the stack, pushing the characters into the array
        while(!stack.isEmpty())
        {
            solution[index--] = stack.pop();
        }
        
        //Return the new string
        return new String(solution);
    }
}