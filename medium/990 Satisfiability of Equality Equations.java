package medium;

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
        
        int[] union = new int[26];
        
        for(int i=0; i<26; i++)
            union[i] = i;
        
        for(String statement: equations)
        {
            if(statement.charAt(1) == '=')
                union[ find(statement.charAt(0)-'a',union)] = find(statement.charAt(3) - 'a',union);
        }
        
        for(String statement: equations)
        {
            if(statement.charAt(1) == '!' && find(statement.charAt(0)-'a',union) == find(statement.charAt(3)-'a',union))
                return false;
        }
        
        return true;
    }
    
    public static int find(int x, int[] union)
    {
        if( x != union[x])
            union[x] = find(union[x],union);
        
        return union[x];
    }
}
