package easy.November;

import java.util.Stack;

class problem1047{
    
    public static void main(String[] args)
    {
        //SOLUTION: "ca"
        String example1 = "abbaca";

        //SOLUTION: "ay"
        String example2 = "azxxzy";

        System.out.printf("Example 1: \"%s\" %n", removeDuplicates(example1) );
        System.out.println("Solution: \"ca\" \n");

        System.out.printf("Example 2: \"%s\" %n", removeDuplicates(example2) );
        System.out.println("Solution: \"ay\" \n");
    }

    public static String removeDuplicates(String s) {
        
        //Stack that will store characters as they get popped or pushed
        Stack<Character> stack = new Stack<>();
        
        //Loop through all the characters in the string
        for(int i=0; i<s.length(); i++)
        {
            //Pop from stack if theres a letter in there and they are the same
            if(!stack.isEmpty() && s.charAt(i)==stack.peek())
                stack.pop();
            else
            //Stack is empty or characters didn't match
                stack.push( s.charAt(i));
        }
        
        //Since stack stored the characters in reverse, we have index pointer
        //Start from the end of the array, and we work our way backwards
        int index = stack.size() - 1;
        char[] word = new char[stack.size()];
        
        //Keep putting characters in the array starting from the end until stack is empty
        while(!stack.isEmpty())
            word[index--] = stack.pop();
            
        //return completed string
        return new String(word);
    }
}
