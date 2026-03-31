class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Step 1: Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Step 2: Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Step 3: Remove the nth node
        slow.next = slow.next.next;
        
        // Return new head
        return dummy.next;
    }
}
