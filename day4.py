# Day4
# Question:
# Given an array of integers, find the first missing positive integer in linear time
# and constant space. In other words, find the lowest positive integer that does 
# not exist in the array. The array can contain duplicates and negative numbers as well.
# For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

# Answer:
# 1) Find the lowest positive integer in the array 
# 2) If another positive integer less than lowest positive integer exists then return it
# 3) If not then iterate through the array again to find the next biggest integer that does
#    not exist in the array.

def solution(arr):
    lowest = arr[0]
    for i in arr:
        if i < lowest and i >0:
            lowest = i
    if lowest-1 > 0:
        return lowest-1
    ans = lowest
    for i in arr:
        ans += 1
        if ans not in arr:
            return ans

arr = list(map(int, input("List: ").strip().split()))
print(solution(arr))

# Time Complexity: O(n)
# Space Complexity: O(n)