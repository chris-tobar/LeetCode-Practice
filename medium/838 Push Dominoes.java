package medium;

class problem838{

    public static void main(String[] args)
    {
        String example1 = "RR.L";
        String example2 = ".L.R...LR..L..";

        pushDominoes(example2);
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
