package medium.October;

class problem38{
    
    public static void main(String[] args) {
        
    }

    public static String countAndSay(int n) {
        
        String baseCase = "1";
        for(int i=1; i<n; i++)
            baseCase = countNumbers(baseCase);
        
        return baseCase;
    }
    
    public static String countNumbers(String s){
        
        StringBuilder sb = new StringBuilder();
        
        char num = s.charAt(0);
        
        int count = 1;
        
        for(int i=1; i<s.length(); i++)
        {
            if(s.charAt(i) == num)
                count++;
            else
            {
                sb.append(count);
                sb.append(num);
                num = s.charAt(i);
                count = 1;
            }
        }
        
        sb.append(count);
        sb.append(num);
        return sb.toString();
    }
}
