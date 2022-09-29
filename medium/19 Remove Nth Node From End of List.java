package medium;

class problem19{
    
    public static void main(String[] args) {
        
        
    }

    public static ListNode createListNodes(int[] list)
    {
        ListNode head = new ListNode();
        ListNode tail = head;

        for(int i: list)
        {
            tail.val = i;
            tail.next = new ListNode();
            tail = tail.next;
        }


        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        
        int length = 0;
        ListNode temp = head;
        
        while(temp != null)
        {
            temp = temp.next;
            length++;
        }
        
        temp = head;
        ListNode prev = temp;
        
        if(length-n==0)
            return temp.next;
        
        for(int i=0; i<length-n; i++)
        {
            prev = temp;
            temp = temp.next;
        }
        
        prev.next = temp.next;
        return head;
    }
}
