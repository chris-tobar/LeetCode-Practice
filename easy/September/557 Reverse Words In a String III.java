package easy.September;

/*
 * Given a string s, reverse the order of characters 
 * in each word within a sentence while still preserving 
 * whitespace and initial word order.
 */
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
        
        //Take the string and reverse it
        StringBuilder word = new StringBuilder(s);
        word.reverse();
        
        //new StringBuilder to keep track of the solution
        StringBuilder sol = new StringBuilder();
        
        //Iterate through StringBuilder starting from the end
        for(int i=word.length()-1, prev=word.length(); i>=0; i--)
        {
            //White space is encountered, so we want to append it to our solution
            if( Character.isWhitespace( word.charAt(i)) )
            {
                //We don't want white space to appended at beginning, so we take one more ahead of it
                //And then append the white space at the end
                sol.append( word.substring(i+1,prev) + " ");

                //Make prev keep track of the last seen white space
                //Since prev is exclusive, it will never be apppended at the end
                prev = i;
            }
            //Index is 0, so we append the rest of the string, w/out whitespace at the end
            else if(i == 0)
                sol.append( word.substring(i,prev) );
        }
        
        //Return our solution
        return sol.toString();
    }
}
