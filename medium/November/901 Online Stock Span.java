package medium.November;

import java.util.Stack;

class problem901{
    
    public static void main(String[] args) {
        
        StockSpanner example1 = new StockSpanner();
    }

    static class StockSpanner {

        Stack<int[]> stack;
        
        public StockSpanner() {
            this.stack = new Stack<>();
        }
        
        public int next(int price) {
            
            int count = 1;
            
            while(!stack.isEmpty() && stack.peek()[0] <= price)
                count += stack.pop()[1];
            
            stack.push( new int[] {price, count} );
            return count;
        }
    }
}
