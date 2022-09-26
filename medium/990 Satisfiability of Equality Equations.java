package medium;
import java.util.HashSet;

class problem990{
    
    public static void main(String[] args) {
        
    }

    public boolean equationsPossible(String[] equations) {
        
        HashSet<String> opposites = new HashSet<>();
        HashSet<Character> eqSet = new HashSet<>();
        HashSet<Character> inqSet = new HashSet<>();
        
        for(int i=0; i<equations.length; i++)
        {
            char x = equations[i].charAt(0);
            char y = equations[i].charAt(3);
            char inverse;
            
            if(equations[i].charAt(1) == '=')
            {
                inverse = '!';
                eqSet.add(x);
                eqSet.add(y);
            }
            else
            {
                inverse = '=';
                inqSet.add(x);
                inqSet.add(y);
            }
            
            String invEquation1 = "" + x + inverse + "=" + y;
            String invEquation2 = "" + y + inverse + "=" + x;
            
            if(opposites.contains( invEquation1) || opposites.contains(invEquation2) )
                return false;
            else
                opposites.add(equations[i]);
        }
        
        
        return true;
    }
}
