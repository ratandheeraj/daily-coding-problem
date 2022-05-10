# Question:
# Given two singly linked lists that intersect at some point, find the intersecting node. 
# The lists are non-cyclical.

# For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

# In this example, assume nodes with the same value are the exact same node objects.

# Answer:
# We will iterate through one linked list and store all the values in a dictionary, 
# Then we will iterate through another linked list and check with the dictionary, if element is 
# found in dictionary then it means it is the intersectingPoint.

# Node in linked list
class Node:
    def __init__(self,data):
        self.data = data
        self.next = None


def findIntersectingPoint(s1,s2):
    memo = {}
    p1,p2 = s1,s2
    while(p1.next != None):
        memo[p1.data] = p1.data
        p1 = p1.next
    
    while(p2.next != None):
        if(p2.data in memo):
            return memo[p2.data]
        p2 = p2.next



s1 = Node(3)
s1.next = Node(7)
s1.next.next = Node(8)
s1.next.next.next = Node(10)

s2 = Node(99)
s2.next = Node(1)
s2.next.next = Node(8)
s2.next.next.next = Node(10)

print(findIntersectingPoint(s1,s2))

# Time Complexity: O(n+m)
# Space Complexity: O(n)