import java.util.Stack;

public class StackSorting {
    // Method to sort a stack using an additional temporary stack
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        
        while (!stack.isEmpty()) {
            // Pop an element from the original stack
            int current = stack.pop();
            
            // While temporary stack is not empty and the top of tempStack is greater than current
            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                // Pop from temporary stack and push it back to the original stack
                stack.push(tempStack.pop());
            }
            
            // Push the current element to the temporary stack
            tempStack.push(current);
        }
        
        // Transfer sorted elements back to the original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    // Main method for demonstration
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Unsorted stack: " + stack);
        
        sortStack(stack);
        
        System.out.println("Sorted stack: " + stack);
    }
}
