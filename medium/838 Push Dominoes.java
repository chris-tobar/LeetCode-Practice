package medium;

/*
 * There are n dominoes in a line, and we place each domino vertically upright.
 *  In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 * 
 * After each second, each domino that is falling to the left pushes the adjacent 
 * domino on the left. Similarly, the dominoes falling to the right push their 
 * adjacent dominoes standing on the right.
 * 
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 * 
 *  For the purposes of this question, we will consider that a falling domino expends no additional 
 * force to a falling or already fallen domino.
 * 
 * You are given a string dominoes representing the initial state where:

    dominoes[i] = 'L', if the ith domino has been pushed to the left,
    dominoes[i] = 'R', if the ith domino has been pushed to the right, and
    dominoes[i] = '.', if the ith domino has not been pushed.
    
 * Return a string representing the final state.
 */
class problem838{

    public static void main(String[] args)
    {
        //Solution: "RR.L"
        String example1 = "RR.L";

        //Solution: "LL.RR.LLRRLL.."
        String example2 = ".L.R...LR..L..";

        //Solution: "LL.RR"
        String example3 = ".L.R.";

        System.out.println( pushDominoes(example1));
        System.out.println( pushDominoes(example2));
        System.out.println( pushDominoes(example3));

    }

    public static String pushDominoes(String dominoes) {

        StringBuilder waves = new StringBuilder(dominoes);
        StringBuilder prev = new StringBuilder("");
        
        while( !waves.toString().equals( prev.toString() ) )
        {
            prev = new StringBuilder(waves);
            
            for(int i=0; i<waves.length(); i++)
            {
                if( (i!=0 && i!=waves.length()-1) && prev.charAt(i)=='.' && 
                   prev.charAt(i-1)=='R' && prev.charAt(i+1)=='L')
                {
                    waves.setCharAt(i,'.');
                }
                else if(i!=0 && prev.charAt(i)=='.' && prev.charAt(i-1) == 'R')
                {
                    waves.setCharAt(i,'R');
                }
                else if(i!=waves.length()-1 && prev.charAt(i)=='.' && prev.charAt(i+1)=='L')
                {
                    waves.setCharAt(i,'L');
                }
            }

        }
        
        return waves.toString();
    }
}
