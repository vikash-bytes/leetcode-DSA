class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        flattenDFS(head);
        return head;
    }

    // Helper function returns the tail after flattening
    private Node flattenDFS(Node node) {
        Node curr = node;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            // If current node has a child
            if (curr.child != null) {
                // Flatten the child list
                Node childTail = flattenDFS(curr.child);

                // Connect curr with child
                curr.next = curr.child;
                curr.child.prev = curr;

                // Connect childTail with next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                // Child is now flattened, set to null
                curr.child = null;
                last = childTail;
            } else {
                last = curr;
            }

            curr = next;
        }
        return last;
    }
}
