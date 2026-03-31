public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // Traverse both lists
        while (a != b) {
            // Move to next node, or switch to other list's head
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        // Either intersection node or null
        return a;
    }
}
