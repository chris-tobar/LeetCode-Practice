package medium;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

class problem609{

    public static void main(String[] args)
    {
        //Solution: [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
        String[] path1 = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};

        //Solution: [["root/a/2.txt","root/c/d/4.txt"],["root/a/1.txt","root/c/3.txt"]]
        String[] path2 = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"};

        //Solution: [["root/cflrodi/irrgfoyzwbj/q/rjytmebdlzcdakl/eozikpwsempmhuf/qaipsnreapdgye/n/kf/zq/kwkmqvtxtnw.txt","root/cflrodi/irrgfoyzwbj/q/rjytmebdlzcdakl/eozikpwsempmhuf/qaipsnreapdgye/n/kf/zq/gj.txt"]]
        String[] path3 = {"root/cflrodi/irrgfoyzwbj/q/rjytmebdlzcdakl/eozikpwsempmhuf/qaipsnreapdgye/n/kf/zq udosmfn.txt(lnmahafnssgsrgnkfosaasgyq) sditog.txt(tsuxooqqlmbrewwpysatghuowmmucqhzodpvrvhul) kwkmqvtxtnw.txt(oeqaxwnzbkowwhrwwmxfbzrqqeuxvdijtnwybyfsihb) gj.txt(oeqaxwnzbkowwhrwwmxfbzrqqeuxvdijtnwybyfsihb) khrct.txt(wrrajcclaeuzgiivqhjxjyt)"};
        
        
        // System.out.println( solution(path1) + "\n");
        // System.out.println( solution(path2) + "\n");
        System.out.println( solution(path3) + "\n");
    }

    public static List<List<String>> solution(String[] paths)
    {
        List<List<String>> sol = new ArrayList<>();
        HashMap<String,List<String>> duplicates = new HashMap<>();
        
        for(String pathways: paths)
        {
            String[] split = pathways.split("\\s+");
            String directory = split[0];
            
            for(int i=1; i<split.length; i++)
            {
                //file[0] contains the # while file[1] contains the content
                String[] file = split[i].split(".txt");
                
                if( !duplicates.containsKey(file[1]) )
                {
                    List<String> temp = new ArrayList<>();
                    temp.add( directory + "/" + file[0] + ".txt");
                    duplicates.put(file[1], temp);
                }
                else
                {
                    duplicates.get(file[1]).add(directory + "/" + file[0] + ".txt");
                }
            }  
        }
        
        //Iterate through keylist to determine if there were any duplicates
        for(String key: duplicates.keySet())
        {
            if(duplicates.get(key).size() > 1)
                sol.add(duplicates.get(key));
        }
        
        return sol;
    }
}