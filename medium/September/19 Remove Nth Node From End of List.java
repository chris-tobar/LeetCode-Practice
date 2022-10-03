package medium.September;

class problem19{
    
    public static void main(String[] args) {
        
        ListNode example1 = createListNodes( new int[] {1,2,3,4,5} );
        ListNode example2 = createListNodes(new int[] {1});
        ListNode example3 = createListNodes(new int[] {1,2});

        ListNode temp1 = removeNthFromEnd(example1, 2);
        ListNode temp2 = removeNthFromEnd(example2, 1);
        ListNode temp3 = removeNthFromEnd(example3, 1);

        temp1.printListNode();
        temp2.printListNode();
        temp3.printListNode();
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
