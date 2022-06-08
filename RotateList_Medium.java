// Rotate List [Medium]

// Given the head of a linked list, rotate the list to the right by k places.

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]

// Example 2:
// Input: head = [0,1,2], k = 4
// Output: [2,0,1]


// Answer:

// We find find the length of the linked list,
// then we will perform a modular division on k, as if the list is rotated lenOfList times, it will be the same list again

// We will store the head in ptr, 
// and use 2 pointers to find the last and second last elements respectively

// After find the last two nodes, last second node becomes the last node, by clearing the next address.
// ptr1.next = null;

// Last node will hold the location to the first node in the linked list.
// ptr2.next = ptr;

// Last node will now be the first node in the linked list
// ptr = ptr2;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}

    ListNode(int val){ 
        this.val = val; 
    }
    ListNode(int val, ListNode next) { 
        this.val = val; this.next = next; 
    }
}

public class RotateList_Medium{
    public static ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode ptr = head;
        while(ptr!=null){
            ptr = ptr.next;
            len++;
        }
        if(len == 0 || k == 0){
            return head;
        }
        k = k % len;
        ptr = head;
        while(k>0 && len > 1){
            ListNode ptr1 = head;
            ListNode ptr2 = ptr1.next;
            while(ptr2.next != null){
                ptr1 = ptr2;
                ptr2 = ptr2.next;
            }
            ptr1.next = null;
            ptr2.next = ptr;
            ptr = ptr2;
            k--;
        }
        return ptr;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = rotateRight(head,2);

        while(head != null){
            System.out.print(head.val);
            System.out.print("\t");
            head = head.next;
        }
        System.out.print("\n");
    }
}

// Time Complexity: O(n*k)
// Space Complexity: O(1)