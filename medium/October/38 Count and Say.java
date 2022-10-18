package medium.October;

import java.util.LinkedHashMap;

class problem38{
    
    public static void main(String[] args) {
        
    }

    public static String countAndSay(int n) {
        
        return "";
    }
    
    public static LinkedHashMap<Integer,Integer> mapPairings(String number)
    {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        
        for(int i=0; i<number.length(); i++)
        {
            int num = number.charAt(i) - '0';
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        
        return map;
    }
    
    public static String pairConversion(LinkedHashMap<Integer,Integer> map)
    {
        StringBuilder sb = new StringBuilder();
        
        
        
        return sb.toString();
    }
}
