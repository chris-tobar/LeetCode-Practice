package easy.October;

class problem1662{
    
    public static void main(String[] args) {
        
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        StringBuilder wordOne = new StringBuilder();
        StringBuilder wordTwo = new StringBuilder();
        
        for(String temp: word1)
            wordOne.append(temp);
        
        for(String temp: word2)
            wordTwo.append(temp);
        
        if(wordOne.compareTo(wordTwo) == 0)
            return true;
        else 
            return false;
    }
}
