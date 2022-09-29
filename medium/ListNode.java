package medium;

public class ListNode {
    
    int val;
    ListNode next;

    ListNode() 
    {}

    ListNode(int val)
    {
        this.val = val;
    }
    
    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }

    public void printListNode()
    {
        if(next == null)
            System.out.println(this.val);
        else
        {
            ListNode temp = this.next;
            System.out.print(this.val + " ");

            while(temp.next != null)
            {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
        }

        System.out.println();
    }
}
