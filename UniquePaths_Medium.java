// Unique Paths [Medium]

// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or 
// right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the 
// bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 109.
 

// Example 1:
// Input: m = 3, n = 7
// Output: 28

// Example 2:
// Input: m = 3, n = 2
// Output: 3
// Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down


// Answer:

// Let's condider a 1 * 1 grid, the start place will be the end, so number of unique paths are 1
// This is the base care for recursion.

// Let's condider a 2 * 2 grid, 
// S-> start, O-> Normal grid, E-> end
// S O
// O E 

// if robot takes right, then there is no chance that robot will touch left column,
// so it can only traverse through n-1 rows. the new grid, in which the robot can travel will be [m][n-1]

// i.e 

// O
// E

// if robot takes down, then there is no chance that robot will touch top row again,
// so it can only traverse through m-1 rows. The new grid, in which the robot can travel will be [m-1][n]

//i.e 

// E


// here, the grid is 1*1, which is the base case, so it returns 1


// The answer will be modifying the dimensions of the grid, to check all possible paths from start to end.


// we use a matrix to store the values, of answer is calculated for m and n values already, (memorization)

// This approach is Dynamic programming


class UniquePaths_Medium {
    public static int uniquePaths(int m, int n) {
        return uniquePathsHelper(m - 1, n - 1, new int[n][m]);
    }
  
    private static int uniquePathsHelper(int m, int n,int[][] memo) {
        if (m < 0 || n < 0)
            return 0;
        else if (m == 0 || n == 0) 
            return 1;
        else if (memo[n][m] > 0)
            return memo[n][m];
        
        else {
            memo[n][m] = uniquePathsHelper(m - 1, n, memo) + uniquePathsHelper(m, n - 1, memo);
            return memo[n][m];
        }
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(2,2));
    }
}



// Time Complexity: O(m*n)
// Space Complexity: O(m*n)