package medium.November;

import java.util.Stack;

class problem901{
    
    public static void main(String[] args) {
        
        StockSpanner example1 = new StockSpanner();
    }

    static class StockSpanner {

        //Stack that will hold pair values of PRICE and COUNT
        Stack<int[]> stack;
        
        //Initalize the stack
        public StockSpanner() {
            this.stack = new Stack<>();
        }
        
        public int next(int price) {
            
            //Since the starting price is always counted, we start at 1
            int count = 1;
            
            //While there are still items in the stack AND top of stack is <= to current price
            // Append that prices count to the current count
            while(!stack.isEmpty() && stack.peek()[0] <= price)
                count += stack.pop()[1];
            
            //No more items left in stack, or value top of stack is bigger than current price
            //Push the value pair into the stack
            stack.push( new int[] {price, count} );

            //Return the count found 
            return count;
        }
    }
}
