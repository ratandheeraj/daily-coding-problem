# Question:
# A builder is looking to build a row of N houses that can be of K different colors. 
# He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

# Given an N by K matrix where the nth row and kth column represents the cost to build the nth 
# house with kth color, return the minimum cost which achieves this goal.

# Answer:

# In the matrix 
# | 5 6 |
# | 8 4 |
# The answer will be 5+4 = 9. 
# We have to pick elements diagonally, i.e cannot choose an element below another element

# We can solve this using dynamic programming
# We will create a possibleAnswer to store the highest values so far in the matrix.
# We will iterate through the matrix and compare the values excluding the adjacent ones and update the 
# possibleAnswer with the minimum values.

# the minimum value in the possibleAnswer array will be answer.


def minimumCostToBuild(matrix):
    n = len(matrix[0])
    possibleAnswer = [0] * n

    for row in matrix:
        tempRow = []
        for index, val in enumerate(row):
            temp = []
            for i in range(n):
                if(i != index):
                    temp.append(possibleAnswer[i])
            tempRow.append(min(temp)+val)
        possibleAnswer = tempRow

    return min(possibleAnswer)


print(minimumCostToBuild([[5,6,7],[4,5,3],[7,8,9]]))
print(minimumCostToBuild([[5,6],[8,3]]))

# Time Complexity: O(n*k^2)
# Space Complexity: O(n*k)