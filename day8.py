# Day 8:
# Question:
# A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
# Given the root to a binary tree, count the number of unival subtrees.
# For example, the following tree has 5 unival subtrees:
#    0
#   / \
#  1   0
#     / \
#    1   0
#   / \
#  1   1

# Answer:
# For countUnivalSubtrees function
# Using recursion to count the unival subtrees
# If it is unival countUnivalSubtrees function returns 1 + left + right
# else it returns left + right

# For isUnival function
# if there is no node, then it means it is unival
# Unival depends on the children nodes


def isUnival(root, value):
    if root == None:
        return True
    if root.value == value:
        return isUnival(root.left, value) and isUnival(root.right, value)
    return False

def countUnivalSubtrees(root):
    if root == None:
        return 0
    left = countUnivalSubtrees(root.left)
    right = countUnivalSubtrees(root.right)
    if isUnival(root, root.value):
        return 1 + left + right
    else:
        return left + right

# Defining the tree node
class Node:
    def __init__(self, value = None, left = None, right = None):
        self.value = value
        self.left = left
        self.right = right

# Creating the example tree
#    0
#   / \
#  1   0
#     / \
#    1   0
#   / \
#  1   1
head = Node(0)
head.left = Node(1)
head.right = Node(0)
head.right.left = Node(1)
head.right.left.left = Node(1)
head.right.left.right = Node(1)
head.right.right = Node(0)

# Testing the code
print(countUnivalSubtrees(head))