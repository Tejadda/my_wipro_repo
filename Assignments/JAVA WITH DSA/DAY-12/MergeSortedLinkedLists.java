/*Merging Two Sorted Linked Lists

You are provided with the heads of two sorted linked lists. The lists are sorted in ascending order. Create a merged linked list in ascending order from the two input lists without using any extra space (i.e., do not create any new nodes).

To merge two sorted linked lists without using any extra space, you can manipulate the pointers of the existing nodes. Here's the approach to merge the lists in ascending order:

1.)Initialize a pointer for the merged list, initially pointing to the head of the first list.
Traverse both lists simultaneously, comparing the values of the nodes.
2.)If the value of the current node in the first list is greater than the value of the current node in the second list, swap the nodes to maintain the sorted order.
3.)Move the pointers forward in the lists.
Repeat steps 3 and 4 until one of the lists is fully traversed.
4.)If any nodes are remaining in the second list, append them to the end of the merged list.

Here's the Java code implementing this approach:*/
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeSortedLinkedLists {

    public static ListNode mergeLists(ListNode l1, ListNode l2) {
        // If one of the lists is empty, return the other list
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Pointer to the head of the merged list
        ListNode mergedHead = l1.val < l2.val ? l1 : l2;

        // Pointer to track the previous node of the current node in the merged list
        ListNode prev = null;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev = l1;
                l1 = l1.next;
            } else {
                ListNode nextNode = l2.next;
                if (prev != null) {
                    prev.next = l2;
                }
                l2.next = l1;
                prev = l2;
                l2 = nextNode;
            }
        }

        // If any nodes remaining in the second list, append them to the end of the merged list
        if (l2 != null) {
            prev.next = l2;
        }

        return mergedHead;
    }

    // Method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Creating two sorted linked lists: 1->3->5 and 2->4->6
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        System.out.println("List 1:");
        printList(l1);
        System.out.println("List 2:");
        printList(l2);

        // Merge the lists
        ListNode mergedList = mergeLists(l1, l2);

        System.out.println("Merged list:");
        printList(mergedList);
    }
}
 /*This implementation merges two sorted linked lists without using any extra space, as it only manipulates the pointers of the existing nodes. It maintains the sorted order while traversing both lists simultaneously.*/


