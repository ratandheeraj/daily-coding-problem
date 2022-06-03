// Swap Nodes in Pairs [Medium]

// Question:
// Given a linked list, swap every two adjacent nodes and return its head. 
// You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)


// Example1:
// Input: head = [1,2,3,4]
// Output: [2,1,4,3]

// Example 2:
// Input: head = []
// Output: []

// Example 3:
// Input: head = [1]
// Output: [1]


// Answer:

// if the list, contains only a single node, or no nodes at all we can simple, return the head, no need to swap

// We will use a tempNode to attach it before head, to get the value of head later

// We need two nodes, to hold the values, prevNode and CurrNode, to chagne addesses of Nodes.
// previous node will contain the address of tempNode, and currNode will contain address of head node, at start

// 1 -> 2 -> 3 -> 4 should become
// 2 -> 1 -> 4 -> 3
 
// After adding tempNode
// tempNode -> 2 -> 1 -> 4 -> 3

//After adding prevNode and CurrNode:

//   prevNode  currNode
//      |        |
//   tempNode -> 1 -> 2 -> 3 -> 4 



// Since we want to swap nodes, prevNode's next should be currNode's next
// So prevNode.next = currNode.next

// And currNode's next should point to what prevNode is pointing next
// So currNode.next = prevNode.next.next

// The node at prevNode.next.next should point the current value, 
// So prevNode.next.next = currNode

// After 2 nodes are swapped, we should increment prevNode and currNode and repeat the process
// prevNode = currNode
// currNode = currNode.next

class ListNode {
    public int val;
    public ListNode next;

    ListNode() {}

    ListNode(int val){ 
        this.val = val; 
    }
    ListNode(int val, ListNode next) { 
        this.val = val; this.next = next; 
    }

}

public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        
        // If one or no nodes present, no need to swap
        if(head == null || head.next == null) 
            return head;
		
        // Dummy node to hold the headNode, placed before headNode
        ListNode tempNode = new ListNode();

        ListNode prevNode = tempNode;
        ListNode currNode = head;
        
        while(currNode != null && currNode.next != null){
            
            prevNode.next = currNode.next;
            currNode.next = prevNode.next.next;
            prevNode.next.next = currNode;
            
            prevNode = currNode;
            currNode = currNode.next;
        }
        
        return tempNode.next;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = swapPairs(head);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}


// Time Complexity: O(n)
// Space Complexity: O(1)