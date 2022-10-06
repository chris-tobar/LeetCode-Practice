package medium.October;

import java.util.HashMap;
import java.util.TreeMap;

/*
 * Design a time-based key-value data structure that can store multiple values for the same key at different 
 * time stamps and retrieve the key's value at a certain timestamp.

    Implement the TimeMap class:

    TimeMap() Initializes the object of the data structure.
    void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
    String get(String key, int timestamp) Returns a value such that set was called previously, 
    with timestamp_prev <= timestamp. If there are multiple such values, it returns the value 
    associated with the largest timestamp_prev. If there are no values, it returns "".

 */
class problem981{

    public static void main(String[] args) {
        
        TimeMap timeMap1 = new TimeMap();

        // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap1.set("foo", "bar", 1);  

        // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar"
        System.out.println( timeMap1.get("foo", 3) ); 

        // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap1.set("foo", "bar2", 4); 

        //Returns "bar2"
        System.out.println(timeMap1.get("foo", 4) );  
        
        // return "bar2"
        System.out.println(timeMap1.get("foo", 5) );

        // return "bar"
        System.out.println(timeMap1.get("foo", 1) );        

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