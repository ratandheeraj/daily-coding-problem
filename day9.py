# Day 9:
# Question:
# Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
# Numbers can be 0 or negative.

# For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. 
# [5, 1, 1, 5] should return 10, since we pick 5 and 5.

# Follow-up: Can you do this in O(N) time and constant space?

# Answer:
# A simple dynamic programming way to solve the question.
# We need to store the best possible sum in "memo" array which is first initialized to be zeros
# We will check with the array to see which is the best possible sum of non adjacent elements and 
# store the result in the memo array.
# Example Iteration:
# [2, 4, 6, 2, 5]
# -> memo = [0,0,0,0,0] 
# -> memo = [2,0,0,0,0] 
# -> memo = [2,4,0,0,0] 
# -> memo = [2,4,8,0,0] 
# -> memo = [2,4,8,8,13] 
# First we will check if including the next element is better ( arr[i] + memo[i-2] ) or not including
# the element (memo[i-1]) is better and update the values accordingly.

# The last element of the memo will the maximum sum or non adjacent numbers.

def largestSum(arr):
    n = len(arr)
    # Edge case
    if n <= 2:
        return max(0, max(arr))
    
    memo = [0] * n
    memo[0] = max(0, arr[0])
    memo[1] = max(arr[0], arr[1])

    for i in range(2, n):
        memo[i] = max(arr[i] + memo[i - 2], memo[i - 1])
    
    return memo[n-1]

print(largestSum([2, 4, 6, 2, 5]))

# Time Complexity: O(n)
# Space Complexity: O(n)