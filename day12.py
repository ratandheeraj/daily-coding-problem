# Question:
# There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. 
# Given N, write a function that returns the number of unique ways you can climb the staircase. 
# The order of the steps matters.
# For example, if N is 4, then there are 5 unique ways:
# 1, 1, 1, 1
# 2, 1, 1
# 1, 2, 1
# 1, 1, 2
# 2, 2
# What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set 
# of positive integers X? 
# For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.

# Answer:
# We will solve this question using dynamic programming.
# We store the data in a dictionary.
# We will try to get all possible ways to climb the staircase, store the values in a dictionary and
# use then when necessay

def countUniqueWays(n, X, memo = {}):
    # if answer is stored in dictionary, we will print it
    if n in memo:
        return memo[n]
    # the base case, end of steps
    if n <= 1:
        return 1
    # initializing the memory
    memo[n] = 0
    # all possible steps can be found and stored
    for i in X:
        memo[n] += countUniqueWays(n-i,X,memo)
    return memo[n]

print(countUniqueWays(15,[1,2,4]))

# Time Complexity: O(n*X)
# Space Complexity: O(n)