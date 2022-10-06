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

        //HashMap to store multiple values 
        HashMap<String, TreeMap<Integer,String> > map;
        
        //Initializes the hashmap
        public TimeMap() {
            map = new HashMap<>();
        }
        
        public void set(String key, String value, int timestamp) {
            
            //The key doesn't exist, so we will create a new value pairing inside
            if( !map.containsKey(key) )
                map.put(key, new TreeMap<>());

            //Get the treemap associated with it, and then put the value into it
            map.get(key).put(timestamp,value);
        }
        
        public String get(String key, int timestamp) {
            
            //No key exists so we return ""
            if(!map.containsKey(key))
                return "";
            
            TreeMap<Integer,String> temp = map.get(key);
            
            //There are no key values inside treemap, so we will return ""
            if( temp.floorKey(timestamp) == null)
                return "";
            
            //Finds the exact number, or the number that is the largest found, but also smaller than value looking for
            Integer floorKey = temp.floorKey(timestamp);
            
            //Return that value that we are searching for
            return temp.get(floorKey);
        }
    }

}