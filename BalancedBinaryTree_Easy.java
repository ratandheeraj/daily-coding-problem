// Balanced Binary Tree [Easy]

// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as:

// a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 
// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: true


// Example 2:
// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false


// Example 3:
// Input: root = []
// Output: true

// Answer:

// If there is no tree, then it's balanced tree, so if root is null, we will return true
// we will use a helper function to find the heights of sub trees.

// In height function:

// We will calculate the height of left and right subtrees and compare them
// If their difference is not in between -1 and 1, then the tree is not balanced

// else it is balanced


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BalancedBinaryTree_Easy {
    public static boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        return height(root) != -1;

    }

    public static int height(TreeNode node){
        if(node == null)
            return 0;

        int leftSubTree = height(node.left);
        if(leftSubTree == -1)
            return -1;
        
        int rightSubTree = height(node.right);
        if(rightSubTree == -1)
            return -1;
        
        if(leftSubTree-rightSubTree < -1 || leftSubTree-rightSubTree > 1)
            return -1;
        
        return Math.max(leftSubTree,rightSubTree) + 1;
    }
}


// Time Complexity: O(n)
// Space Complexity: O(1)