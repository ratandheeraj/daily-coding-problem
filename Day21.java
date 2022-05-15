// Question:
// Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), 
// find the minimum number of rooms required.

// For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.


// Answer:
// The minimum no. of room required are the maximum number of overlapping intervals. 
// So we need to figure out the manimum no. of overlapping intervals.

// We will create an array of custom class Pair, which will hold the value, and type (start or end interval)
// and store all the intervals in this array. 
// [1,2] will be stored as [Pair(1,"s"), Pair(2,"e")]   {here s is start, e is end}
// then we will sort the array by their values.

// then we will iterate through this array.
// if element type is start, time is added, so we will increment the count,
// if element type is end, time is subtracted, so we will decrement the count,

// for every iteration, we will find the maxCount which is the max of maxCount and count

import java.util.*;
import java.lang.*;
import java.io.*;

public class Day21{
	
    public class Pair
    {
        int value;
        char type;
        
        Pair(int value, char type)
        {
            this.value = value;
            this.type = type;
        }
    }

    public int countOverlaps(int[][] v)
    {
        int maxCount = 0;
        int count = 0;
        ArrayList<Pair> data = new ArrayList<>();
        
        for(int i = 0; i < v.length; i++)
        {
            data.add(new Pair(v[i][0], 's'));
            data.add(new Pair(v[i][1], 'e'));
        }

        Collections.sort(data, (a, b) -> a.value - b.value);

        for(int i = 0; i < data.size(); i++)
        {
            if (data.get(i).type == 's')
                count++;

            if (data.get(i).type == 'e')
                count--;

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static void main(String[] args)
    {
        Day21 day21 = new Day21();
        int[][] v = {{30, 75}, {0, 50}, {60, 150}} ;
        System.out.println(day21.countOverlaps(v));
    }
}


// Time Complexity: O(n logn) {Since we used sort function}
// Space Complexity: O(n)