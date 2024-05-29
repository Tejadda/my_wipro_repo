import java.util.Stack;

public class SequenceInStack {
    public static boolean isSequencePresent(Stack<Integer> stack, int[] sequence) {
        // Iterate over the sequence in reverse order
        for (int i = sequence.length - 1; i >= 0; i--) {
            // If stack is empty or top element doesn't match sequence, return false
            if (stack.isEmpty() || stack.peek() != sequence[i]) {
                return false;
            }
            // Pop elements from stack until sequence[i] is found
            while (!stack.isEmpty() && stack.peek() == sequence[i]) {
                stack.pop();
            }
        }
        // If the sequence is found, stack should be empty
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int[] sequence = {3, 4, 5};

        boolean sequencePresent = isSequencePresent(stack, sequence);
        System.out.println("Is the sequence present in the stack? " + sequencePresent);
    }
}
