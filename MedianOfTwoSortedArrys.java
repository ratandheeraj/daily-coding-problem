import java.util.ArrayList;

// Median of Two Sorted Arrays [Hard]

// Question: 
// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

// Example1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// Example2:
// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


// Answer:

// Using merge algorithm, we can merge the two arrays first, after merging the two arrays, we will return
// the median

class MedianOfTwoSortedArrays{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        ArrayList<Integer> nums = new ArrayList<>();
        int i=0,j=0;
        while(i<n && j<m){
            if(nums1[i]<=nums2[j]){
                nums.add(nums1[i]);
                i++;
            }
            else{
                nums.add(nums2[j]);
                j++;
            }
        }
        while(i<n){
            nums.add(nums1[i]);
                i++;
        }
        while(j<m){
            nums.add(nums2[j]);
                j++;
        }
                
        int len = nums.size();
        int mid = (int)len/2 - 1;
        if(len % 2 == 1){
            return (double)nums.get(mid+1);
        }else{
            return ((double)nums.get(mid) + nums.get(mid+1))/2;
        }
    }

    public static void main(String[] args){
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {5,6,7,8};
        double ans = findMedianSortedArrays(nums1,nums2);
        System.out.println(ans);
    }
}


// Time Complexity: O(m + n)
// Space Complexity: O(m + n)