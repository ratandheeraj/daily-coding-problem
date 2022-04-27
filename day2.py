#Day2
# Given an array of integers, return a new array such that each element at index i
# of the new array is the product of all the numbers in the original array 
# except the one at i.

# For example, if our input was [1, 2, 3, 4, 5], 
# the expected output would be [120, 60, 40, 30, 24]. 
# If our input was [3, 2, 1], 
# the expected output would be [2, 3, 6].

# Answer:
# Multiply all the elements in the array and store the value in a variable 'multiplier'
# Iterate the array again this time divide multiplier with the value in array
# Store this value in the new array

def solution(arr):
    ansArr = []
    mulplier = 1
    for i in arr:
        mulplier *= i
    print(mulplier)
    for i in arr:
        ansArr.append(mulplier//i)
    return ansArr

arr = list(map(int, input("List: ").strip().split()))
print(solution(arr))

# Time Complexity: O(n)
# Space Complexity: O(n)