package medium.October;

class problem38{
    
    public static void main(String[] args) {
        
    }

    public static String countAndSay(int n) {
        
        //Start with the base case, until you work your way to n-1
        String baseCase = "1";
        for(int i=1; i<n; i++)
            //Keeps updating on its subproblems
            baseCase = countNumbers(baseCase);
        
        return baseCase;
    }
    
    public static String countNumbers(String s){
        
        //String builder that we will be appending to
        StringBuilder sb = new StringBuilder();
        
        //Get the first number we will be starting with
        char num = s.charAt(0);
        
        //Initalize the count to 1 since we are starting with our first digit
        int count = 1;
        
        //Since first digit is already accounted for, start with the second character and iterate to the end
        for(int i=1; i<s.length(); i++)
        {
            //number found is the same, so we increment the count
            if(s.charAt(i) == num)
                count++;
            //Number found is not the same, append count along with number, and reset counter
            else
            {
                sb.append(count);
                sb.append(num);
                num = s.charAt(i);
                count = 1;
            }
        }
        
        //Iteration has ended, append count left over, along with number accounting for
        sb.append(count);
        sb.append(num);

        //Return string version of it
        return sb.toString();
    }
}
