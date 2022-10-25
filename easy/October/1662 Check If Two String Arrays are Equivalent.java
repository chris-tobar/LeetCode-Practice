package easy.October;

/*
 * Given two string arrays word1 and word2, return true if the two arrays 
 * represent the same string, and false otherwise.

    A string is represented by an array if the array 
    elements concatenated in order forms the string.
 */
class problem1662{
    
    public static void main(String[] args) {
        
        String[] example1A = {"ab","c"};
        String[] example1B = {"a","bc"};

        String[] example2A = {"a","cb"};
        String[] example2B = {"ab","c"};

        String[] example3A = {"abc","d","defg"};
        String[] example3B = {"abcddefg"};


        System.out.printf( "\nExample1: %b\n", arrayStringsAreEqual(example1A, example1B));
        System.out.println("Solution: true \n");
        System.out.printf( "Example2: %b\n",arrayStringsAreEqual(example2A, example2B));
        System.out.println("Solution: false \n");
        System.out.printf( "Example3: %b\n", arrayStringsAreEqual(example3A, example3B));
        System.out.println("Solution: true \n");

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
