package medium.October;

import java.util.HashMap;
import java.util.TreeMap;

class problem981{

    public static void main(String[] args) {
        
        TimeMap timeMap = new TimeMap();
    }

    public static class TimeMap {

        HashMap<String, TreeMap<Integer,String> > map;
        
        public TimeMap() {
            map = new HashMap<>();
        }
        
        public void set(String key, String value, int timestamp) {
            
            if( !map.containsKey(key) )
            {
                TreeMap<Integer,String> temp = new TreeMap<>();
                temp.put(timestamp, value);
                
                map.put(key, temp);
            }
            else
            {
                TreeMap<Integer,String> temp = map.get(key);
                temp.put(timestamp,value);
            }
        }
        
        public String get(String key, int timestamp) {
            
            if(!map.containsKey(key))
                return "";
            
            TreeMap<Integer,String> temp = map.get(key);
            
            if( temp.floorKey(timestamp) == null)
                return "";
            
            Integer floorKey = temp.floorKey(timestamp);
            
            return temp.get(floorKey);
        }
    }

}