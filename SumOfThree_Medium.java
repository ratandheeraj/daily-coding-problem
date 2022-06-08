import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 3 Sum [Medium]


// Question:
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, 
// and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]

// Example 2:
// Input: nums = []
// Output: []

// Example 3:
// Input: nums = [0]
// Output: []


// Answer:

// We will use 3 pointers, to get hold of triplets whose sum are 0

// We will first sort the array, to get the duplicate numbers together, and sepeate negative and positive numbers
// We will use a loop, to iterate through the array, and keep the first pointer at the start.
// We will keep the second pointer after the first pointer, and third pointer at the end of the array.
// We then check their sum, if sum is 0, we will add that to the answer array, and decrement the third array,
// if the sum is not 0, we will increment the second pointer, and check the sum again,

// if second pointer's value becomes more than the third pointer's value, it means we checked the combination, so break
// the array

public class SumOfThree_Medium {
    public List<List<Integer>> threeSum(int[] nums){

        // Sort the given array 
        Arrays.sort(nums);

        List < List < Integer >> answerArray = new ArrayList < > ();

        for(int ptr1 = 0; ptr1 + 2 < nums.length; ptr1++){
            // if the first pointer itself is not a negative number, the sum of triplet can never become zero
            // avoid duplicate number 
            if(ptr1 > 0 && nums[ptr1] == nums[ptr1 - 1]){
                continue;
            }
            
            // next number after the ptr1
            int ptr2 = ptr1 + 1;

            // last element in the array
            int ptr3 = nums.length - 1;

            while(ptr2 < ptr3) {
                int sum = nums[ptr2] + nums[ptr3] + nums[ptr1];
                if(sum == 0){

                    answerArray.add(Arrays.asList(nums[ptr1], nums[ptr2], nums[ptr3]));
                    ptr3--;

                    // Skiping all duplicates from right
                    while (ptr2 < ptr3 && nums[ptr3] == nums[ptr3 + 1]) 
                        ptr3--;

                }else if(sum > 0) {
                    ptr3--;
                }else{
                    ptr2++;
                }
            }
        }
        return answerArray;
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(n)