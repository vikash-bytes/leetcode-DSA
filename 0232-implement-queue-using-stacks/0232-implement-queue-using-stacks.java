import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // Push element x to the back of queue
    public void push(int x) {
        stack1.push(x);
    }
    
    // Removes the element from the front of queue and returns it
    public int pop() {
        shiftStacks();
        return stack2.pop();
    }
    
    // Get the front element
    public int peek() {
        shiftStacks();
        return stack2.peek();
    }
    
    // Returns whether the queue is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    // Helper method to move elements from stack1 to stack2 if stack2 is empty
    private void shiftStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
