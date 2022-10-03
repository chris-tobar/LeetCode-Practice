package medium.September;

/*
 * You are given an array of strings equations that represent relationships 
 * between variables where each string equations[i] is of length 4 and
 *  takes one of two different forms: "xi==yi" or "xi!=yi".
 * Here, xi and yi are lowercase letters (not necessarily different) 
 * that represent one-letter variable names.
 * 
 * Return true if it is possible to assign integers to variable 
 * names so as to satisfy all the given equations, or false otherwise.
 */
class problem990{
    
    public static void main(String[] args) {
        
        //Solution:false
        String[] example1 = {"a==b","b!=a"};

        //Solution: true
        String[] example2 = {"b==a","a==b"};

        //Solution:false
        String[] example3 = {"a==b","b!=c","c==a"};

        System.out.println( equationsPossible(example1));
        System.out.println( equationsPossible(example2));
        System.out.println( equationsPossible(example3));

    }

    public static boolean equationsPossible(String[] equations) {
        
        //Integer array that uses the letter as the index, and the value as the letter its equal too
        int[] union = new int[26];
        
        //Making each letter equal itself
        for(int i=0; i<26; i++)
            union[i] = i;
        
        //Iterate through finding statements where the left equals the right
        for(String statement: equations)
        {
            char x = statement.charAt(0);
            char y = statement.charAt(3);
            if(statement.charAt(1) == '=')
                //Adjusting it so letter x equals y within the union array
                union[ find(x-'a',union)] = find(y- 'a',union);
        }
        
        for(String statement: equations)
        {
            char x = statement.charAt(0);
            char y = statement.charAt(3);
            //Contradicting statement found, so return false
            if(statement.charAt(1) == '!' && find(x-'a',union) == find(y-'a',union))
                return false;
        }
        
        //No contradictions found, return true
        return true;
    }
    
    public static int find(int x, int[] union)
    {
        if( x != union[x])
            union[x] = find(union[x],union);
        
        return union[x];
    }
}
