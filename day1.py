# Day 1 
# Question:
# Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
# For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

# Answer:
# Let us assume that there will be two numbers 'a' and 'b' in the array which will add up to the value 'k',
# i.e., a + b == k 
# so if we have an element a the other element b == k - a
# We will use a hashmap(dictionary) to store values
# While iterating through array we will check if the remainder value exists in the dictionary
# if exists then two numbers can add up to the value 'k'
# if there is no such number then we can't add two numbers to get the value 'k'

def canSum(arr,k):
    seen = {}
    for i in arr:
        remaining = k - i

        if remaining in seen:
            return True
        else:
            seen[i] = i
    return False

arr = list(map(int, input("List: ").strip().split()))
k = int(input("K: "))
print(canSum(arr,k))

# Time Complexity : O(n)
# Space Complexity : O(n)