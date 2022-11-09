package medium.November;

import java.util.Stack;

class problem901{
    
    public static void main(String[] args) {
        
        StockSpanner example1 = new StockSpanner();
    }

    public static class StockSpanner {

        Stack<Integer> stack;
        int prevMax;
        int prevNumber;
        
        public StockSpanner() {
            this.stack = new Stack<>();
            this.prevMax = 1;
            this.prevNumber = 1;
        }
        
        public int next(int price) {
            
            if(stack.isEmpty())
            {
                stack.push(price);
                return 1;
            }
            else if( price < stack.peek() )
            {
                stack.push(price);
                this.prevMax = 1;
                this.prevNumber = price;
                return 1;
            }
            else
                stack.push(price);
            
            Stack<Integer> temp = (Stack<Integer>)stack.clone();
            int max = 0;
            
            while(!temp.isEmpty())
            {
                if( temp.pop() <= price)
                    max++;
                else
                    return max;
            }
            
            
            return max;
        }
    }
}
