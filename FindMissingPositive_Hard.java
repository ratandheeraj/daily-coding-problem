// 41. First Missing Positive [Hard]

// Given an unsorted integer array nums, return the smallest missing positive integer.

// You must implement an algorithm that runs in O(n) time and uses constant extra space.

// Example 1:
// Input: nums = [1,2,0]
// Output: 3

// Example 2:
// Input: nums = [3,4,-1,1]
// Output: 2

// Example 3:
// Input: nums = [7,8,9,11,12]
// Output: 1


// Answer:

// We need to find the smallest missing positive integer in the array, so the integer will not be a negative number, 
// or a number which is greater than array.length+1.

// so we will use, cyclic sort to sort the numbers in the array which are positive and less than nums.length
// it will place the numbers in their respective places

// Then we will loop through the array, and find the first number which is not in its place, return it as answer

// If no element is found, then all elements are in place, so the number must be nums.length+1



public class FindMissingPositive_Hard {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i= 0;i<n;i++) {
            int correct = nums[i]-1;
            if (nums[i]>0 &&  nums[i]<=n && nums[i] != nums[correct]){
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
            }
        }

        for(int j =0;j<n;j++){
            if (nums[j]!=j+1)
                return j+1;
        }

        return n+1;
    }

    public static void main(String[] args){
        int[] nums = {1,5,4,3,6};
        System.out.println(firstMissingPositive(nums));
    }
}



// Time Complexity: O(n)
// Space Complexity: O(1)