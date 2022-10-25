package easy.October;

class problem1662{
    
    public static void main(String[] args) {
        
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        //StringBuilder that will store the strings in word1
        StringBuilder wordOne = new StringBuilder();

        //StringBuilder that will store the strings in word2
        StringBuilder wordTwo = new StringBuilder();
        
        //Iterate through the array and append to first string builder
        for(String temp: word1)
            wordOne.append(temp);
        
        //Iterate through second array and append to second string builder
        for(String temp: word2)
            wordTwo.append(temp);
        
        //If the two strings are the same, it will return 0, else it will return -1 or 1
        //Meaning they differ
        if(wordOne.compareTo(wordTwo) == 0)
            return true;
        else 
            return false;
    }
}
