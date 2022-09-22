package easy;

class problem557{
    
    public static void main(String[] args) {
        
        //Solution: s'teL ekat edoCteeL tsetnoc
        String example1 = "Let's take LeetCode contest";

        //Solution: doG gniD
        String example2 = "God Ding";

        System.out.println( reverseWords(example1));
        System.out.println( reverseWords(example2));

    }

    public static String reverseWords(String s) {
        
        StringBuilder word = new StringBuilder(s);
        word.reverse();
        
        StringBuilder sol = new StringBuilder();
        
        for(int i=word.length()-1, prev=word.length(); i>=0; i--)
        {
            if( Character.isWhitespace( word.charAt(i)) )
            {
                sol.append( word.substring(i+1,prev) + " ");
                prev = i;
            }
            else if(i == 0)
                sol.append( word.substring(i,prev) );
        }
        
        return sol.toString();
    }
}
