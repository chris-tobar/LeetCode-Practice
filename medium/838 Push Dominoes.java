package medium;

/*
 * There are n dominoes in a line, and we place each domino vertically upright.
 *  In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 * 
 * After each second, each domino that is falling to the left pushes the adjacent 
 * domino on the left. Similarly, the dominoes falling to the right push their 
 * adjacent dominoes standing on the right.
 * 
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 * 
 *  For the purposes of this question, we will consider that a falling domino expends no additional 
 * force to a falling or already fallen domino.
 * 
 * You are given a string dominoes representing the initial state where:

    dominoes[i] = 'L', if the ith domino has been pushed to the left,
    dominoes[i] = 'R', if the ith domino has been pushed to the right, and
    dominoes[i] = '.', if the ith domino has not been pushed.
    
 * Return a string representing the final state.
 */
class problem838{

    public static void main(String[] args)
    {
        //Solution: "RR.L"
        String example1 = "RR.L";

        //Solution: "LL.RR.LLRRLL.."
        String example2 = ".L.R...LR..L..";

        //Solution: "LL.RR"
        String example3 = ".L.R.";

        System.out.println( pushDominoes(example1));
        System.out.println( pushDominoes(example2));
        System.out.println( pushDominoes(example3));

    }

    //Time complexity: O(n)
    //Space complexity: O(n)
    public static String pushDominoes(String dominoes) {

        //Padding left and right to not worry about edge cases
        String d = 'L' + dominoes + 'R';

        //String builder that we will be appending our solution too
        StringBuilder res = new StringBuilder();

        //Iterate through the string
        for (int left = 0, right = 1; right < d.length(); right++) {

            //We are only searching for cases where its not a "."
            if (d.charAt(right) == '.') 
                continue;

            //This will tell us how many dots are between the left and right
            int middle = right - left - 1;

            //Since left no longer is in our padding, we want to append the left character
            if (left > 0)
                res.append(d.charAt(left));
            
            //The left character and the right character are the same, so we make all the dots in between
            // the same letter
            if (d.charAt(left) == d.charAt(right))
                //Iterate how many dots were found
                for (int k = 0; k < middle; k++)
                    res.append(d.charAt(left));
            //left side is "L" and right side is "R", meaning the middle will never be affected by dominoes falling
            else if (d.charAt(left) == 'L' && d.charAt(right) == 'R')
                //iterate for how many dots were found
                for (int k = 0; k < middle; k++)
                    res.append('.');
            
            //Dots in the middle are going to be affected by some action, so we need to iterate through and append
            else {
                //Since left = "R", we iterate through half the dots found and make them "R"
                for (int k = 0; k < middle / 2; k++)
                    res.append('R');
                //Since its an odd number of dots, that middle dot will not be affected due to left="R" and right="L"
                if (middle % 2 == 1)
                    res.append('.');
                //Append whatever dots are left with "L"
                for (int k = 0; k < middle / 2; k++)
                    res.append('L');
            }

            //Make the left pointer equal to the right
            left = right;
        }

        //Return the completed string
        return res.toString();
    }
}
