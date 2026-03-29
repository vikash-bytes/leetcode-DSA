class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move prev to the node before 'left'
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse sublist
        ListNode curr = prev.next;
        ListNode next = null;
        ListNode sublistPrev = null;

        for (int i = 0; i <= right - left; i++) {
            next = curr.next;
            curr.next = sublistPrev;
            sublistPrev = curr;
            curr = next;
        }

        // Step 3: Connect reversed sublist back
        prev.next.next = curr;   // tail of reversed sublist points to remainder
        prev.next = sublistPrev; // prev points to new head of sublist

        return dummy.next;
    }
}
