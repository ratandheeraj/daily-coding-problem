# Question:

# Given an array of integers and a number k, where 1 <= k <= length of the array, 
# compute the maximum values of each subarray of length k.

# For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

# 10 = max(10, 5, 2)
# 7 = max(5, 2, 7)
# 8 = max(2, 7, 8)
# 8 = max(7, 8, 7)

# Do this in O(n) time and O(k) space. You can modify the input array in-place and you do
# not need to store the results. You can simply print them out as you compute them.


# Answer:
# Iterate through the array, and print the max value of the subarray arr from 
# index i(through iteration) to i+k, 
# print the answer directly to save the memory


def maximumValuesOfEachSubarray(arr,k):
    for i in range(len(arr)-k+1):
        print(max(arr[i:i+k]),end=" ")
    print()

maximumValuesOfEachSubarray([10, 5, 2, 7, 8, 7],3)

# Time Complexity: O(n)
# Space Complexity: O(1)