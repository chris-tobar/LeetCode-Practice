package medium;

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
