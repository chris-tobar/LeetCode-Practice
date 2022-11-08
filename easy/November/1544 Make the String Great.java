package easy.November;

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
        
        if(s.length() == 1)
            return s;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length()-1; i++)
        {
            Character letter = Character.toLowerCase( s.charAt(i) ) ;
            Character letterAhead = Character.toLowerCase( s.charAt(i+1) );
            
            if( letter.equals(letterAhead) )
            {
                Character temp = s.charAt(i);
                Character temp2 = s.charAt(i+1);
                
                if( !temp.equals(temp2) )
                    i++;
                else
                    sb.append( s.charAt(i));
            }
            else
                sb.append( s.charAt(i));
            
        }
        
        sb.append(s.charAt( s.length() -1 ) );
        
        return sb.toString();
    }
}