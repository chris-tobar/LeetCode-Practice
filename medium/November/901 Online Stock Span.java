package medium.November;

import java.util.Stack;

/*
 * Design an algorithm that collects daily price quotes for some stock and 
 * returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number
 of consecutive days (starting from today and going backward) for which 
 the stock price was less than or equal to today's price.

    For example, if the price of a stock over the next 7 days were 
    [100,80,60,70,60,75,85], then the stock spans would be [1,1,1,2,1,4,6].

    Implement the StockSpanner class:

    StockSpanner() Initializes the object of the class.
    int next(int price) Returns the span of the stock's price given that today's price is price.

 */
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
