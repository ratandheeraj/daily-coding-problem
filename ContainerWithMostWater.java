// Container With Most Water [Medium]

// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the
// ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

// Example 1:
// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of 
// water (blue section) the container can contain is 49.

// Example 2:
// Input: height = [1,1]
// Output: 1

// Answer:
// We use the greedy apporach and use 2 pointers, one pointer at the beginning, one pointer at the end
// We will find the area of water that can be contained in the container with left and right lines. 
// -> min of(leftHeight,rightHeight) multiplied by (high-low) to find the area

// we will store the value in possible answer and compare with answer.
// we will compare the heights of left and right lines, and decrement/increment the pointer which least value
// We will compare all the possible answers in a greedy way, so we will get the answer which is better than 
// all possible combinations

class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int answer = 0;
        int low = 0;
        int high = height.length-1;

        while(low < high){
            int leftHeight = height[low];
            int rightHeight = height[high];
            int possibleAnswer = Math.min(leftHeight,rightHeight)*(high-low);

            if(possibleAnswer > answer){
                answer = possibleAnswer;
            }

            if(leftHeight<rightHeight){
                low++;
            }
            else{
                high--;     
            }
        }
            return answer;
    }
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}


// Time Complexity: O(n)
// Space Complexity: O(1)