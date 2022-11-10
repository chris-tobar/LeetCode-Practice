package easy.November;

import java.util.Stack;

class problem1047{
    
    public static void main(String[] args)
    {

    }

    public static String removeDuplicates(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++)
        {
            if(!stack.isEmpty() && s.charAt(i)==stack.peek())
                stack.pop();
            else
                stack.push( s.charAt(i));
        }
        
        int index = stack.size() - 1;
        char[] word = new char[stack.size()];
        
        while(!stack.isEmpty())
            word[index--] = stack.pop();
            
            
        return new String(word);
    }
}
